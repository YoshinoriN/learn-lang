// Selection Sort
function main(input) {

  let list = input.split("\n")[1].split(' ').map(x => parseInt(x));
  let swapCnt = 0; // AOJ 提出用

  // minj: 未ソート済み配列の位置
  for (i = 0; list.length - 1 > i; i++) {
    let minj = i;

    // 未ソート部から最小を取得
    for (j = i; list.length > j; j++) {
      if (list[minj] > list[j]) {
        minj = j;
      }
    }
    // 未ソート済み配列の先頭と未ソート部最小を比較して入れ替え
    if (i != minj) {
      const a = list[i];
      const b = list[minj];
      list[minj] = a;
      list[i] = b;

      swapCnt++; // AOJ 提出用
    }
  }

  // AOJ 提出用
  console.log(list.join(" "));
  console.log(swapCnt);
}
main(require('fs').readFileSync('/dev/stdin', 'utf8'));

/*
cat 2_B.data.txt | node 2_B.js

*/
