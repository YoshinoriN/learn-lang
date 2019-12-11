class Rational(n: Int, d: Int) {
  require (d != 0)

  // 補助コンストラクタ
  def this(n: Int) = this(n, 1)

  // 最大公約数
  private val g = gcd(n.abs, d.abs)

  val numer: Int = n / g  // 分子
  val denom: Int = d / g  // 分母

  override def toString = n + "/" + d

  // 最大公約数を求める関数
  private def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)

  // イミュータブルに保ちつつも、分数の加算を行えるようにする
  def + (that: Rational): Rational =
    new Rational(
      numer * that.denom + that.numer * denom,
      denom * that.denom
    )

  def + (i: Int): Rational =
    new Rational(
      numer + i * denom,
      denom
    )

  def - (that: Rational): Rational =
    new Rational(
      numer * that.denom - that.numer * denom,
      denom * that.denom
    )

  // Rationalクラスでも算術演算子は + よりも * が優先される
  def * (that: Rational): Rational =
    new Rational(
      numer * that.numer,
      denom * that.denom
    )

  def * (i: Int): Rational =
    new Rational(
      numer * i,
      denom
    )

  def / (that: Rational): Rational =
    new Rational(
      numer * that.denom,
      denom * that.numer
    )

  def / (i: Int): Rational =
    new Rational(
      numer,
      denom * i
    )

}

object Rational {

  // Int * Rational ができるようになる
  implicit def intToRational(x: Int) = new Rational(x)
}

/*
scala> val x = new Rational(1, 2)
x: Rational = 1/2

scala> val y = new Rational(2, 3)
y: Rational = 2/3

scala> x + y
res0: Rational = 7/6

scala> x + x * y
res1: Rational = 5/6

scala> (x + x) * y
res2: Rational = 2/3

// 補助コンストラクタ
scala> val x = new Rational(2)
x: Rational = 2/1


 */
