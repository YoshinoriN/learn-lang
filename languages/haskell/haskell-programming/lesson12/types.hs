-- dataで新しい型を作成できる
-- Sex は 型コンストラクタ（データコンストラクタのどちらかのインスタンス）
-- Male, Female はデータコンストラクタ
data Sex = Male | Female

sexInitial :: Sex -> Char
sexInitial Male = 'M'
sexInitial Female = 'F'

{--
ghci> sexInitial Male
'M'
--}


data RhType = Positive | Negative
data ABOType = A | B | AB | O
-- RhTypeとABOTypeを組み合わせてBloodTypeを定義する
-- この場合BloodTypeのデータコンストラクタ（右辺のBloodType）は型コンストラクタ（左辺のBloodType）と同じになる
data BloodType = BloodType ABOType RhType
