package main

import (
	"bufio"
	"io/ioutil"
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

var hrRegexp = regexp.MustCompile(`^-{3,10}`)

func isHr(text string) bool {
	var s = strings.TrimSpace(text)
	if !hrRegexp.Match([]byte(s)) {
		return false
	}
	return true
}

func main() {
	filepath.Walk("./source/_posts", func(path string, fileInfo os.FileInfo, err error) error {
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

		var needExclude = false
		var result []string
		scanner := bufio.NewScanner(file)
		for scanner.Scan() {
			var s = scanner.Text()
			if needExclude && isHr(s) {
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

		wFile, err := os.Create(path)
		if err != nil {
			panic(err)
		}
		defer wFile.Close()
		ioutil.WriteFile(path, []byte([]byte(strings.Join(result, "\n"))), 0644)
		return nil
	})
}
