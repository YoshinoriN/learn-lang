t _ [] = []
t 0 _ = []
t n (x:xs) = x:rest
  where rest = t (n - 1) xs
