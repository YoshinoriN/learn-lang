var numberOfSteps = function(num, cnt = 0) {
  if (num === 0) {
    return cnt
  }
  if (num % 2 === 0) {
    return numberOfSteps(num / 2, cnt = cnt + 1);
  } else {
    return numberOfSteps(num - 1, cnt = cnt + 1);
  }
};

console.log(numberOfSteps(8))

/*
NG:

let cnt = 0;
var numberOfSteps = function(num) {
  if (num === 0) {
    return cnt;
  }
  if (num % 2 === 0) {
    cnt++;
    return numberOfSteps(num / 2);
  } else {
    cnt++;
    return numberOfSteps(num - 1);
  }
};

console.log(numberOfSteps(8))

*/
