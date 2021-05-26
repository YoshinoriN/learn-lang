greatestCommonDivisor a b = if remainder == 0
                            then b
                            else greatestCommonDivisor b remainder

  where remainder = a `mod` b

{-

ghci> greatestCommonDivisor 20 16
4
ghci> greatestCommonDivisor 20 15
5

-}
