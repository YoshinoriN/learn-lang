class Item<T> {

    private _value: T;
    get value(): T {
        return this._value;
    }
    set value(value: T) {
        this._value = value;
    }

    private _prevItem: Item<T>;
    get prevItem(): Item<T> {
        return this._prevItem;
    }
    set prevItem(value: Item<T>) {
        this._prevItem = value;
    }

    constructor(data: T) {
        this._value = data;
    }

}

class Stack<T> {

    private _size: number = 0;
    get size(): number {
        return this._size;
    }
    set size(value: number) {
        this._size = value;
    }

    private _top: Item<T>;
    get top(): Item<T> {
        return this._top;
    }
    set top(value: Item<T>) {
        this._top = value;
    }

    constructor() {
        this._size = 0;
        this._top = null;
    }

    push(item: Item<T>) {
        this.size++;
        item.prevItem = this.top;
        this.top = item;
    }

    pop() {
        if (this._size === 0) {
            return null;
        }
        const _top = this.top;
        this.top = this.top.prevItem;
        this.size--;
        return _top;
    }
}
const stack = new Stack<string>();

stack.push(new Item<string>('a'));
stack.push(new Item<string>('b'));
stack.push(new Item<string>('c'));

console.log(stack.pop());
console.log(stack.pop());
console.log(stack.pop());
console.log(stack.pop());
