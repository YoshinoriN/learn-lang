class Item {

  constructor(value) {
    this._value = value;
    this._prevItem = null;
  }

  getValue() {
    return this._value;
  }

  setPrevItem(item) {
    this._prevItem = item;
  }

  getPrevItem() {
    return this._prevItem;
  }

}

class Stack {

  constructor() {
    this._size = 0;
    this._top = null;
  }

  push(item) {
    this._size++;
    item.setPrevItem(this._top);
    this._top = item;
  }

  pop() {
    if (this._size === 0) {
      return null;
    }
    const top = this._top;
    this._top = this._top.getPrevItem();
    this._size--;
    return top;
  }
}
const stack = new Stack();

stack.push(new Item('a'));
stack.push(new Item('b'));
stack.push(new Item('c'));

console.log(stack.pop());
console.log(stack.pop());
console.log(stack.pop());
console.log(stack.pop());
