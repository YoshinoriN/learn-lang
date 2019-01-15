function main(input) {
  console.log(input * input * input);
}
main(require('fs').readFileSync('/dev/stdin', 'utf8'));

/*
echo 3 | node 1_B.js
*/
