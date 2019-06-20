function main(input) {
  console.log(parseInt(input.substring(0,1)) + parseInt(input.substring(1,2)) + parseInt(input.substring(2,3)))
}
main(require('fs').readFileSync('/dev/stdin', 'utf8'));

/*
https://atcoder.jp/contests/abs/tasks/abc081_a

cat data.txt | node main.js
*/
