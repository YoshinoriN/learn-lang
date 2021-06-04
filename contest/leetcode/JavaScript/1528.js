var restoreString = function(s, indices) {
  const x = s.split('').map((s, i) => {
    return [indices[i], s]
  });
  x.sort((a, b) => {
    if (a[0] > b[0]) {
      return -1;
    }
    if (a[0] < b[0]) {
      return 1;
    }
    return 0;
  });
  return x.reverse().map(x => {
    return x[1];
  }).join('');
};

console.log(restoreString("codeleet", [4,5,6,7,0,2,1,3]));
console.log(restoreString("abc", [0,1,2]));
console.log(restoreString("aiohn", [3,1,4,2,0]));
console.log(restoreString("aaiougrt", [4,0,2,6,7,3,1,5]));
console.log(restoreString("art", [1,0,2]));
