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
	filepath.Walk("./2020", func(path string, fileInfo os.FileInfo, err error) error {
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
		for scanner.Scan() {
			var s = scanner.Text()
			if isH1(s) {
				fmt.Println(s)
			}
		}
		if err = scanner.Err(); err != nil {
			panic(err)
		}
		fmt.Println("\n")
		return nil
	})
}
