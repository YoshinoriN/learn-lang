package challenges.pck.prelim.p0336

object Main extends App {
  val input = io.StdIn.readLine().split(" ").map(_.toInt)

  input(0) + input(1) match {
    case x if x == 0 => println(0)
    case x if x  >= 1 => println(1)
    case _ => println(-1)
  }
}
