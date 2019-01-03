```js
function main(input) {
  console.log(input);
}
main(require('fs').readFileSync('/dev/stdin', 'utf8'));
```

### Input example

```
$ echo hogegege | node A.js
hogegege
```

```
$ cat data.txt | node A.js
hogegege
```
