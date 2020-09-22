function generateCombination(e) {
  let S = [];
  for (i = 0; e > i; i++) {
    S.push(0);
  }
  select(0, e, S)
}

function select(i, e, S) {
  if (i === e) {
    console.log(S);
    return;
  }

  select(i + 1, e, S);
  S[i] = 1;
  select(i + 1, e, S);
  S[i] = 0;
}

generateCombination(3);

/*
node generateCombination.js

[ 0, 0, 0 ]
[ 0, 0, 1 ]
[ 0, 1, 0 ]
[ 0, 1, 1 ]
[ 1, 0, 0 ]
[ 1, 0, 1 ]
[ 1, 1, 0 ]
[ 1, 1, 1 ]
*/
