addAnA [] = []
addAnA (x:xs) = ("a " ++ x):addAnA xs

{-
  ghci> addAnA  ["foo","bar","boo"]
  ["a foo","a bar","a boo"]
-}


myMap f [] = [] -- 終了条件
myMap f (x:xs) = (f x):myMap f xs

{-
  ghci> myMap ("add A" ++) ["hoge", "fuga", "piyo"]
  ["add Ahoge","add Afuga","add Apiyo"]
-}
