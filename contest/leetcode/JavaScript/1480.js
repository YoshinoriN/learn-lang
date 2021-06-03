var runningSum = function(nums) {
  let i = 0;
  let r = [];
  nums.forEach(x => {
    r.push(x + i);
    i = i + x;
  });
  return r;
};

console.log(runningSum([3,1,2,10,1]));
