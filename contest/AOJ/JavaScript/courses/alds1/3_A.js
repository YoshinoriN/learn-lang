class Stack {
  constructor() {
    this._stack = [];
  }

  push(item) {
    this._stack[this._stack.length] = item;
  }

  pop() {
    if (this._stack.length == 0) {
      return null;
    }
    const top = this._stack[this._stack.length - 1]
    this._stack.splice(this._stack.length - 1, 1);
    return top;
  }
}

const symbols = require('fs').readFileSync('/dev/stdin', 'utf8').split(' ').map(x => x.replace("\n", ""));
const stack = new Stack();

symbols.forEach(x => {
  if (x === "+") {
    let a = stack.pop();
    let b = stack.pop();
    stack.push(b + a);
  } else if (x === "-") {
    let a = stack.pop();
    let b = stack.pop();
    stack.push(b - a);
  } else if (x === "*") {
    let a = stack.pop();
    let b = stack.pop();
    stack.push(b * a);
  } else {
    stack.push(parseInt(x));
  }
});

console.log(stack.pop());


/*
cat 3_A.data.txt | node 3_A.js

*/
