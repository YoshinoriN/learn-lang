// Bubble sort
function main(input) {

  let list = input.split("\n")[1].split(' ').map(x => parseInt(x));

  let cnt = 0; // AOJ 提出用

  let flag = true;
  let i = 0;
  while (flag) {
    flag = false;
    for (let j = list.length - 1; j >= i + 1; j--) {
      if (list[j - 1] > list[j]) {
        let a = list[j - 1];
        let b = list[j];
        list[j - 1] = b;
        list[j] = a;
        flag = true;
        cnt++;  // AOJ 提出用
      }
    }
    i++;
  }
  console.log(list.join(" "));
  console.log(cnt);
}
main(require('fs').readFileSync('/dev/stdin', 'utf8'));

/*
cat 2_A.data.txt | node 2_A.js

*/
