function main(input) {
  let x = parseInt(input.split("\n")[0]);
  let list = input.split("\n")[1].split(' ').map(x => parseInt(x));

  let head = 0;
  let tail = list.length - 1;
  let middle = 0;

  while (head <= tail) {
    middle = Math.floor((head + tail) / 2);
    if (x === list[middle]) {
      console.log(middle);
      process.exit();
    }
    if (x > list[middle]) {
      head = middle + 1;
    } else {
      tail = middle - 1;
    }
  }
  console.log("Not found");
}
main(require('fs').readFileSync('/dev/stdin', 'utf8'));

/*
cat data.txt | node index.js
*/
