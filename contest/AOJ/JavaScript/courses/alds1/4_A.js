// https://onlinejudge.u-aizu.ac.jp/courses/lesson/1/ALDS1/4/ALDS1_4_A

const x = require('fs').readFileSync('/dev/stdin', 'utf8').split("\n");
const listA = Array.from(new Set(x[1].split(" ")));
const listB = Array.from(new Set(x[3].split(" ")));

let cnt = 0;

listB.forEach(x => {
  for (i = 0; listA.length > i; i++) {
    if (listA[i] === x) {
      cnt++;
    }
  }
})

console.log(cnt);

/*
cat 4_A.data.txt | node 4_A.js

*/
