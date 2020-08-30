// https://onlinejudge.u-aizu.ac.jp/courses/lesson/1/ALDS1/3/ALDS1_3_C
class Node {
  constructor(data) {
    this._data = data;
    this._prev = null;
    this._next = null;
  }

  getData() {
    return this._data;
  }

  getPrev() {
    return this._prev;
  }

  setPrev(node) {
    this._prev = node;
  }

  getNext() {
    return this._next;
  }

  setNext(node) {
    this._next = node;
  }
}

class DoubleLinkedList {
  constructor() {
    this._head = null;
    this._tail = null;
  }

  // O(1)
  insert(node) {
    if (this._head !== null) {
      this._head.setPrev(node);
      node.setNext(this._head);
    } else {
      this._tail = node;
    }
    this._head = node;
  }

  // O(N)
  //値が一致する最初の要素を消す
  delete(node) {
    if (this._head === null) {
      return;
    }

    let current = this._head;
    while(current !== null) {
      if (current.getData() === node.getData()) {
        const prev = current.getPrev();
        const next = current.getNext();
        if (prev !== null) {
          prev.setNext(next);
        }
        if (next !== null) {
          next.setPrev(prev);
        }
        if (this._head === current) {
          this._head = next;
        }
        if (this._tail === current) {
          this._tail = prev;
        }
        break;
      }
      current = current.getNext();
    }
  }

  // O(1)
  deleteFirst() {
    if (this._head === null) {
      return;
    }

    const next = this._head.getNext();
    if (next !== null) {
      next.setPrev(null);
      this._head = next;
    } else {
      this._head = null;
    }
  }

  // O(1)
  deleteLast() {
    if (this._tail === null) {
      return;
    }

    const prev = this._tail.getPrev();
    if (prev !== null) {
      prev.setNext(null);
      this._tail = prev;
    } else {
      if (this._head === this._tail) {
        this._head = null;
      }
      this._tail = null;
    }
  }

  getValues() {
    if (this._head === null) {
      return [];
    }

    let current = this._head;
    let values = [];
    while(current !== null) {
      values.push(current.getData());
      current = current.getNext();
    }
    return values;
  }
}

const x = require('fs').readFileSync('/dev/stdin', 'utf8').split("\n");
x.shift();

const doubleLinkedList = new DoubleLinkedList();
x.forEach(y => {
  const z = y.split(" ");
  console.log(doubleLinkedList.getValues());
  switch (z[0]) {
    case 'insert':
      doubleLinkedList.insert(new Node(z[1]));
      break;
    case 'delete':
      doubleLinkedList.delete(new Node(z[1]));
      break;
    case 'deleteFirst':
      doubleLinkedList.deleteFirst();
      break;
    case 'deleteLast':
      doubleLinkedList.deleteLast();
      break;
    default:
      break;
  }
})

/*
const doubleLinkedList = new DoubleLinkedList();

doubleLinkedList.insert(new Node("5"));
console.log(doubleLinkedList.getValues());
doubleLinkedList.insert(new Node("2"));
console.log(doubleLinkedList.getValues());
doubleLinkedList.insert(new Node("3"));
console.log(doubleLinkedList.getValues());
doubleLinkedList.delete(new Node("1"));
console.log(doubleLinkedList.getValues());
doubleLinkedList.insert(new Node("3"));
console.log(doubleLinkedList.getValues());
doubleLinkedList.insert(new Node("6"));
console.log(doubleLinkedList.getValues());
doubleLinkedList.insert(new Node("5"));
console.log(doubleLinkedList.getValues());
doubleLinkedList.deleteFirst();
console.log(doubleLinkedList.getValues());
doubleLinkedList.deleteLast();
console.log(doubleLinkedList.getValues());
*/
