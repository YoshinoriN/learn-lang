trait Monoid[A] {
  def mappend(a: A, b: A): A
  def mzero: A
}

object IntMonoid extends Monoid[Int] {
  def mappend(a: Int, b: Int): Int = a + b
  def mzero: Int = 0
}

object StringMonoid extends Monoid[String] {
  def mappend(a: String, b: String): String = a + b
  def mzero: String = ""
}

/*
// IntMonoidのみの場合
scala> def sum(xs: List[Int]): Int = xs.foldLeft(IntMonoid.mzero)(IntMonoid.mappend)
def sum(xs: List[Int]): Int

scala> sum(List(1,2,3,4))
val res0: Int = 10

// Monoidを継承したIntMonoidの場合
scala> def sum(xs: List[Int], m: Monoid[Int]): Int = xs.foldLeft(m.mzero)(m.mappend)
def sum(xs: List[Int], m: Monoid[Int]): Int

scala> sum(List(1,2,3,4), IntMonoid)
val res0: Int = 10

// Monoidをimplicitにして毎回渡さなくてもよいようにする
scala> def sum[A](xs: List[A])(implicit m: Monoid[A]): A = xs.foldLeft(m.mzero)(m.mappend)
def sum[A](xs: List[A])(implicit m: Monoid[A]): A

scala> implicit val intMonoid = IntMonoid
val intMonoid: IntMonoid.type = IntMonoid$@6e46ee7f

scala> sum(List(1,2,3,4))
val res1: Int = 10
*/

trait FoldLeft[F[_]] {
  def foldLeft[A, B](xs: F[A], b: B, f: (B, A) => B): B
}

object FoldLeft {
  implicit val FoldLeftList: FoldLeft[List] = new FoldLeft[List] {
    def foldLeft[A, B](xs: List[A], b: B, f: (B, A) => B) = xs.foldLeft(b)(f)
  }
}

object Sum {
  implicit val intMonoid = IntMonoid
  implicit val stringMonoid = StringMonoid

  def sum[M[_]: FoldLeft, A: Monoid](xs: M[A]): A = {
    // context bound
    val m = implicitly[Monoid[A]]
    val fl = implicitly[FoldLeft[M]]
    fl.foldLeft(xs, m.mzero, m.mappend)
  }
}
