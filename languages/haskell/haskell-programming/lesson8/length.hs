len [] = 0
len x = 1 + len (tail x)
