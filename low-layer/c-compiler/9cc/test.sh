#!/bin/bash

assert() {
  expected="$1"
  input="$2"

  ./9cc "$input" > tmp.s
  gcc -static -o tmp tmp.s
  ./tmp
  actual="$?"

  if [ "$actual" = "$expected" ]; then
    echo "$input => $actual"
  else
    echo "$input => $expected expected, but got $actual"
    exit 1
  fi
}

assert 0 0
assert 42 42
assert 21 "5+20-4"
assert 41 " 12 + 34 - 5 "
assert 47 '5+6*7'
assert 15 '5*(9-6)'
assert 4 '(3+5)/2'

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
