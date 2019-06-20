package challenges.pck.prelim.p0358

object Main extends App {
  val nums = io.StdIn.readLine().split(" ").map(_.toInt)
  val m = nums(0)
  val f = nums(1)
  val b = nums(2)

  b match {
    case x if x <= m => println(0);
    case x if x > m + f => println("NA")
    case x  => println(x - m)
  }
}
