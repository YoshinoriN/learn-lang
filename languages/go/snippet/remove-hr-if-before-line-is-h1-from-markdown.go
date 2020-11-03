package main

import (
	"bufio"
	"fmt"
	"os"
	"path/filepath"
	"regexp"
	"strings"
)

var h1Regexp = regexp.MustCompile(`^# (.+)`)

func isH1(text string) bool {
	var s = strings.TrimSpace(text)
	if !h1Regexp.Match([]byte(s)) {
		return false
	}
	return true
}

func main() {
	filepath.Walk("./2020-2", func(path string, fileInfo os.FileInfo, err error) error {
		if err != nil {
			panic(err)
		}
		if fileInfo.IsDir() {
			return nil
		}

		if !strings.HasSuffix(fileInfo.Name(), ".md") {
			return nil
		}

		file, err := os.Open(path)
		if err != nil {
			panic(err)
		}
		defer file.Close()

		fmt.Println(path)
		scanner := bufio.NewScanner(file)

		var needExclude = false
		var result []string
		for scanner.Scan() {
			var s = scanner.Text()
			if needExclude {
				needExclude = false
			} else {
				result = append(result, s)
			}
			if isH1(s) {
				needExclude = true
			}
		}

		if err = scanner.Err(); err != nil {
			panic(err)
		}
		println(strings.Join(result, "\n"))
		fmt.Println("\n")
		return nil
	})
}
