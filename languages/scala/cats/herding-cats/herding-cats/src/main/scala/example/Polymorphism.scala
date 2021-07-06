trait Plus[A] {
  def plus(a2: A):A
}

// サブタイピング多相はmixinしないと使えない
// なのでIntやStringでは使えない
case class Human(name: String) extends Plus[Human] {
  def plus(a2: Human): Human = Human(this.name + ":" + a2.name)
}

/*
def plus[A <: Plus[A]](a1: A, a2: A): A = a1.plus(a2)

scala> def plus[A <: Plus[A]](a1: A, a2: A): A = a1.plus(a2)
plus: [A <: Plus[A]](a1: A, a2: A)A

scala> plus(Human("Taro"), Human("Jiro"))
res6: Human = Human(Taro:Jiro)
*/
