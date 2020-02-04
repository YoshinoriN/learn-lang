#!/bin/bash

try() {
  expected="$1"
  input="$2"

  gcc -o 9cc 9cc.c
  ./9cc "$input" > tmp.s
  gcc -o tmp tmp.s
  ./tmp
  actual="$?"

  if [ "$actual" = "$expected" ]; then
    echo "$input => $actual"
  else
    echo "$input => $expected expected, but got $actual"
    exit 1
  fi

  rm -f 9cc tmp.s tmp
}

try 0 0
try 42 42
try 21 "5+20-4"

echo OK

<< COMMENTOUT
$ bash -x ./test.sh

+ try 0 0
+ expected=0
+ input=0
+ gcc -o 9cc 9cc.c
+ ./9cc 0
+ gcc -o tmp tmp.s
+ ./tmp
+ actual=0
+ '[' 0 = 0 ']'
+ echo '0 => 0'
0 => 0
+ rm -f 9cc tmp.s tmp
+ try 42 42
+ expected=42
+ input=42
+ gcc -o 9cc 9cc.c
+ ./9cc 42
+ gcc -o tmp tmp.s
+ ./tmp
+ actual=42
+ '[' 42 = 42 ']'
+ echo '42 => 42'
42 => 42
+ rm -f 9cc tmp.s tmp
+ echo OK
OK
COMMENTOUT
