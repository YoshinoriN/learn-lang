import Data.List

compareLastNames n1 n2 = if lastName1 > lastName2
                         then GT
                         else if lastName1 < lastName2
                              then LT
                              else EQ

  where lastName1 = snd n1
        lastName2 = snd n2

{-
ghci> sortBy compareLastNames [("Hoge", "Fuga"),("Bar", "Boo"),("Taa", "Coo")]
[("Bar","Boo"),("Taa","Coo"),("Hoge","Fuga")]
-}
