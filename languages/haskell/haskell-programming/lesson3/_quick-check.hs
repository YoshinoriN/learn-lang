-- 3-1
f = \x -> x * 2

{-
  ghci> f = \x -> x * 2
  ghci> f(4)
  8
  ghci> f(5)
  10
-}


-- 3-2
{-
doubleDouble x = dubs * 2
  where dubs = x * 2
-}

doubleDouble = \x -> (x * 2) *2


-- 3-3
overwriteWithLambda x = (\x -> (\x -> (\x -> x) 4) 3) 2
