function main(input) {
  const a = parseInt(input.split("\n")[0]);
  const b = parseInt(input.split("\n")[1]);
  const c = parseInt(input.split("\n")[2]);
  const x = parseInt(input.split("\n")[3]);

  var cnt = 0;
  for (an = 0; an <= a; an++) {
    for (bn = 0; bn <= b; bn++) {
      for (cn = 0; cn <= c; cn++) {
        if ((an * 500 + bn * 100 + cn * 50) === x) {
          cnt++;
        }
      }
    }
  }
  console.log(cnt);
}
main(require('fs').readFileSync('/dev/stdin', 'utf8'));

/*
https://atcoder.jp/contests/abc087/tasks/abc087_b

cat data.txt | node main.js
cat data2.txt | node main.js
*/
