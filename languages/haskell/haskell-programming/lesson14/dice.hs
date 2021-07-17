{--
単純にderivingで実装した場合
data Dice = S1 | S2 | S3 | S4 | S5 | S6 deriving (Show)
ghci> S1
S1
ghci> S2
S2
--}

data Dice = S1 | S2 | S3 | S4 | S5 | S6
instance Show Dice where
  show S1 = "one"
  show S2 = "two"
  show S3 = "three"
  show S4 = "four"
  show S5 = "five"
  show S6 = "six"
instance Eq Dice where
  (==) S6 S6 = True
  (==) S5 S5 = True
  (==) S4 S4 = True
  (==) S3 S5 = True
  (==) S2 S2 = True
  (==) S1 S1 = True
  (==) _ _ = False
