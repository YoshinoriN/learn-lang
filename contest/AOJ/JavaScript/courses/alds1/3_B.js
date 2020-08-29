// https://onlinejudge.u-aizu.ac.jp/courses/lesson/1/ALDS1/3/ALDS1_3_B
class CircularQueue {
  constructor(capacity) {
    this._capacity = capacity;
    this._items = new Array(capacity);
    this._head = 0;
    this._tail = 0;
    this._count = 0;
  }

  enqueue(item) {
    if (this._count >= this._capacity) {
      throw new Error("Exceeded capacity");
    }

    this._items[this._tail] = item;

    if (this._tail === this._capacity) {
      this._tail = 0;
    } else {
      this._tail = this._tail + 1;
    }
    this._count++;
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
    this._count--;

    return head;
  }

  isEmpty() {
    return this._count === 0;
  }
}

const x = require('fs').readFileSync('/dev/stdin', 'utf8').split("\n");
x.pop();
const qms = parseInt(x.shift().split(" ")[1]);

const tasks = x.map(y => y.split(" "));
const cq = new CircularQueue(tasks.length);

tasks.forEach(e => {
  cq.enqueue(e);
});

let totalTime = 0;
while (!cq.isEmpty()) {
  const a = cq.dequeue();
  const t = a[1] - qms;
  if (t > 0) {
    totalTime = totalTime + qms;
    cq.enqueue([a[0], t]);
  } else {
    totalTime = totalTime + (t > 0 ? qms : parseInt(a[1]));
    console.log(`${a[0]} ${totalTime}`);
  }
}

/*
cat 3_B.data.txt | node 3_B.js

p2 180
p5 400
p1 450
p3 550
p4 800
*/
