package setexample

object SetExample extends App {

  val u = List(1, 3, 8, 10) union List(1, 2, 8, 10, 11)
  println(u)   // List(1, 3, 8, 10, 1, 2, 8, 10, 11)

  val i = List(1, 3, 8, 10) intersect List(1, 2, 8, 10, 11)
  println(i)   // List(1, 8, 10)

  val d = List(1, 3, 8, 10) diff List(1, 2, 8, 10, 11)
  val d2 = List(1, 2, 8, 10, 11) diff List(1, 3, 8, 10)
  println(d)   // List(3)
  println(d2)  // List(2, 11)

}
