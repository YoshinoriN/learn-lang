m, n :: Int

m = 1 + 7
n = 9 + 9

-- as pattern
t@(a, b, c, d) = ("hello", 123 , True, 89.98)

main = do
  print m
  print n
  print a
  print b
  print c
  print d
  print t

{--
8
18
"hello"
123
True
89.98
("hello",123,True,89.98)
--}
