// https://onlinejudge.u-aizu.ac.jp/courses/lesson/1/ALDS1/2/ALDS1_2_C
function bubbleSort(list) {
  let flag = true;
  let i = 0;
  while (flag) {
    flag = false;
    for (let j = list.length - 1; j >= i + 1; j--) {
      if (list[j - 1][1] > list[j][1]) {
        let a = list[j - 1];
        let b = list[j];
        list[j - 1] = b;
        list[j] = a;
        flag = true;
      }
    }
    i++;
  }
  return list;
}

function selectionSort(list) {
  for (i = 0; list.length - 1 > i; i++) {
    let minj = i;
    for (j = i; list.length > j; j++) {
      if (list[minj][1] > list[j][1]) {
        minj = j;
      }
    }
    if (i != minj) {
      const a = list[i];
      const b = list[minj];
      list[minj] = a;
      list[i] = b;
    }
  }
  return list;
}

function createMap(list) {
  const alphabet = list.map(x => x[0]);
  const num = list.map(x => x[1]);

  const m = [];
  for (i = 0; list.length > i; i++) {
    m.push([alphabet[i], num[i]])
  }
  return m;
}

const listA = require('fs').readFileSync('/dev/stdin', 'utf8').split("\n")[1].split(' ');
const listB = JSON.parse(JSON.stringify(listA));


const bubbleSortResult = bubbleSort(createMap(listA)).map(x => `${x[0]}${x[1]}`).join(" ");
console.log(bubbleSortResult);
console.log('Stable');

const selectionSortResult = selectionSort(createMap(listB)).map(x => `${x[0]}${x[1]}`).join(" ");
console.log(selectionSortResult);
console.log(bubbleSortResult === selectionSortResult ? "Stable" : "Not stable");


/*
cat 2_C.data.txt | node 2_C.js

[ 'D2', 'C3', 'H4', 'S4', 'C9' ]
Stable
[ 'D2', 'C3', 'S4', 'H4', 'C9' ]
Not stable
*/
