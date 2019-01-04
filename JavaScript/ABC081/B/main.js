function f(nums, i) {
  //AtCoderのサポートバージョン（v5.12.0）ではブロックスコープでのletがサポートされていない
  var arr = [];
  var canDivide = true;

  for (var n = 0; n < nums.length; n++) {
    if (nums[n] % 2 === 0) {
      arr.push(nums[n] / 2);
    } else {
      canDivide = false;
      break;
    }
  }
  if (canDivide) {
    return f(arr, i + 1);
  }
  return i;
}

function main(input) {
  const nums = input.split("\n")[1].split(" ").map((x) => parseInt(x));
  console.log(f(nums, 0));
}

main(require('fs').readFileSync('/dev/stdin', 'utf8'));

/*
https://atcoder.jp/contests/abc081/tasks/abc081_b

cat data.txt | node main.js
*/
