/*
複数の返り値を返す場合は、型パラメータがない言語では引数経由で返すか、それ用のクラスを作る必要がある。
Scalaだと、以下のように書くことで実現できる。(toStringは出力用なので特に意味なし)
 */
class Pair[A, B](val a: A, val b: B) {
  override def toString: String = "(" + a + "," + b + ")"
}

/*
上記のクラスを割り算の商と余りを返すdivideメソッドのようなものでやると下記のようになる。（ちなみにTuple1～22まであらかじめ用意されている）

scala> def divide(m: Int, n: Int): Pair[Int, Int] = new Pair[Int, Int](m / n, m % n)
<console>:11: warning: type Pair in object Predef is deprecated (since 2.11.0): use built-in tuple syntax or Tuple2 instead
       def divide(m: Int, n: Int): Pair[Int, Int] = new Pair[Int, Int](m / n, m % n)
                                   ^
divide: (m: Int, n: Int)Pair[Int,Int]

scala> divide(7,3)
res1: Pair[Int,Int] = (2,1)
 */