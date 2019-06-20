package challenges.pck.prelim.p0381

object Main extends App {
  val arr = io.StdIn.readLine().split(" ").map(_.toInt)
  println(Math.abs(arr(0) - arr(1)))
}
