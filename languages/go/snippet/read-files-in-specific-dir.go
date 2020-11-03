package main

import (
	"io"
	"os"
	"path/filepath"
	"strings"
)

func main() {
	filepath.Walk("./your/dir", func(path string, fileInfo os.FileInfo, err error) error {
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
		io.Copy(os.Stdout, file)
		return nil
	})
}
