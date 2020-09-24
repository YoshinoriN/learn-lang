// https://onlinejudge.u-aizu.ac.jp/courses/lesson/1/ALDS1/5/ALDS1_5_A

const x = require('fs').readFileSync('/dev/stdin', 'utf8').split("\n");
const listA = x[1].split(" ");
const listB = x[3].split(" ");

function solve(i, n, m, S) {

  if (m === 0) {
    return true;
  }

  if (i >= n) {
    return false;
  }

  return solve(i + 1, n, m, S) || solve(i + 1, n, m - S[i], S);
}

listB.forEach(e => {
  if (solve(0, listA.length, e, listA)) {
    console.log("yes");
  } else {
    console.log("no");
  }
});


/*
cat 5_A.data.txt | node 5_A.js

*/
