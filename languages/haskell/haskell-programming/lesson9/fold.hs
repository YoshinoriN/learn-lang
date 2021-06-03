concatAll xs = foldl (++) "" xs

{-
  ghci> concatAll ["a","b","c","d"]
  "abcd"
-}

sumOfSquare xs = foldl (+) 0 (map (^2) xs)

{-
  ghci> sumOfSquare [1,2,3]
  14
-}
