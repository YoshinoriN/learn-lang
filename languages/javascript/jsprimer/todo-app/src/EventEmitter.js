export class EventEmitter {
  constructor() {
    // 登録する[イベント名, Set(リスナー関数)]を管理するMap
    this._listeners = new Map();
  }

  addEventListener(type, listener) {
    if (!this._listeners.has(type)) {
      this._listeners.set(type, new Set());
    }
    const listenerSet = this._listeners.get(type);
    listenerSet.add(listener);
  }

  emit(type) {
    const listnerSet = this._listeners.get(type);
    if (!listnerSet) {
      return;
    }
    listnerSet.forEach(listener => {
      listener.call(this);
    })
  }

  removeEventListener(type, listener) {
    const listenerSet = this._listeners.get(type);
    if(!listenerSet) {
      return;
    }
    listnerSet.forEach(ownListener => {
      if (ownListener === listener) {
        listnerSet.delete(listener);
      }
    });
  }
}
