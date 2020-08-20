# Go lang

> [Official](https://golang.org/)
> [Install](https://golang.org/doc/install)

## VSCode settings

* Install Plugin
    * [Go: Go Team at Google](https://marketplace.visualstudio.com/items?itemName=golang.Go)

```json
{
  "version": "0.2.0",
  "configurations": [
    {
      "name": "Launch",
      "type": "go",
      "request": "launch",
      "mode": "auto",
      "program": "${fileDirname}",
      "env": {
        "GOPATH": "c:\\Go\\bin"
      },
      "args": []
    }
  ]
}
```
