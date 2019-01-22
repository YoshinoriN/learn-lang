function main(input) {
  const nums = input.split("\n")[1].split(" ").map(x => parseInt(x));
  let currentConsecutive = 0;
  let maxConsecurive = 0;
  let befor = 0;

  nums.forEach(x => {
    if (x === 1) {
      if (befor === 1) {
        currentConsecutive++;
      } else {
        currentConsecutive = 1;
      }
      befor = 1;
    } else {
      currentConsecutive = 0;
      befor = 0;
    }
    if (currentConsecutive >= maxConsecurive) {
      maxConsecurive = currentConsecutive;
    }
  });
  console.log(maxConsecurive + 1);
}
main(require('fs').readFileSync('/dev/stdin', 'utf8'));

/*
cat 0642.data.txt | node 0642.js

*/
