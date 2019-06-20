package challenges.pck.prelim.p0382

object Main extends App {
  val persons = io.StdIn.readLine().split(" ")(0).toInt + 1
  val cakes = io.StdIn.readLine().split(" ").map(_.toInt).sum
  cakes % persons match {
    case 0 => println(cakes / persons)
    case _ => println(cakes / persons + 1)
  }
}
