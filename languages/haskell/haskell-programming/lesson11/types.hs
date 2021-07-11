-- 型変数 使用するときに実際の型に置き換えられる
-- ジェネリクスと同じ？
simple :: a -> a
simple x = x

{--
ghci> simple "abd"
"abd"
ghci> simple 2
2
--}


-- 最後の型が戻り値
-- この場合はタプル
makeTriple :: a -> b -> c -> (a,b,c)
makeTriple x y z = (x,y,z)

{--
ghci> makeTriple 1 2 3
(1,2,3)
--}
