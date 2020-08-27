class CircularQueue {

  constructor(capacity) {
    this._capacity = capacity;
    this._items = new Array(capacity);
    this._head = 0;
    this._tail = 0;
  }

  _currentItemsCount() {
    return this._items.filter(x => x !== undefined).length;
  }

  enqueue(item) {
    if (this._currentItemsCount() >= this._capacity) {
      throw new Error("Exceeded capacity");
    }

    this._items[this._tail] = item;

    if (this._tail === this._capacity) {
      this._tail = 0;
    } else {
      this._tail = this._tail + 1;
    }
  }

  dequeue() {
    if (this.isEmpty()) {
      throw new Error("No items");
    }

    const head = this._items[this._head];
    this._items[this._head] = undefined;

    if (this._head === this._capacity) {
      this._head = 0;
    } else {
      this._head = this._head + 1;
    }

    return head;
  }

  isEmpty() {
    return this._currentItemsCount() === 0;
  }

}

const cq = new CircularQueue(5);
cq.enqueue("a");
cq.enqueue("b");
cq.enqueue("c");
cq.enqueue("d");
cq.enqueue("e");
console.log(cq._currentItemsCount());
console.log(cq.dequeue());
console.log(cq.dequeue());
console.log(cq.dequeue());
console.log(cq.dequeue());
console.log(cq.dequeue());
console.log(cq._currentItemsCount());

cq.enqueue("a");
cq.enqueue("b");
console.log(cq.dequeue());
cq.enqueue("c");
cq.enqueue("d");
cq.enqueue("e");
console.log(cq.dequeue());
console.log(cq.dequeue());
cq.enqueue("f");
console.log(cq.dequeue());
console.log(cq.dequeue());
console.log(cq.dequeue());
