"use strict";

const fs = require('fs');
const cache = {};

// 同期と非同期が混在する関数
function inconsistentRead(fileName, callback) {
  if (cache[fileName]) {
    // 同期
    callback(cache[fileName]);
  } else {
    // 非同期
    fs.readFile(fileName, 'utf8', (error, data) => {
      cache[fileName] = data;
      callback(data);
    });
  }
}

function createFileReader(fileName) {
  const listeners = [];
  inconsistentRead(fileName, value => {
    listeners.forEach(listener => listener(value));
  });

  return {
    onDataReady: listener => listeners.push(listener)
  }
}

const reader1 = createFileReader('data.txt');
reader1.onDataReady(data => {
  console.log('First call data: ' + data);

  // 2回目以降はキャッシュにのる
  // inconsistentReadは同期的に実行されるため、inconsistentReadのコールバックは即時実行される
  const reader2 = createFileReader('data.txt');
  reader2.onDataReady(data => {
    console.log('Second call data: ' + data);
  });
});
