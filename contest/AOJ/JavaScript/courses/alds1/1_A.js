function main(input) {

  let list = input.split("\n")[1].split(' ').map(x => parseInt(x));
  console.log(list.join(" "));

  //iは未ソート部を表す変数
  for (let i = 1; i < list.length; i++) {
    let v = list[i];
    let j = i - 1;    //jはソート済み部を降順に探索する変数

    while (j >= 0 && list[j] > v) {
      list[j + 1] = list[j];
      j--;
    }
    list[j + 1] = v;
    console.log(list.join(" "));
  }
}
main(require('fs').readFileSync('/dev/stdin', 'utf8'));

/*
cat 1_A.data.txt | node 1_A.js

5 2 4 6 1 3
2 5 4 6 1 3
2 4 5 6 1 3
2 4 5 6 1 3
1 2 4 5 6 3
1 2 3 4 5 6
*/
