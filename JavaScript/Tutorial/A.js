function main(input) {
  const i = input.split("\n");
  const a = parseInt(i[0]);
  const b = parseInt(i[1].split(" ")[0]);
  const c = parseInt(i[1].split(" ")[1]);

  // %dでnumber %sで文字列の出力になる
  console.log('%d %s', a + b + c, i[2])

}
main(require('fs').readFileSync('/dev/stdin', 'utf8'));

/*
https://atcoder.jp/contests/abs/tasks/practice_1
cat data.txt | node A.js
*/
