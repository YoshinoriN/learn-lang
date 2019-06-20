package challenges.pck.prelim.p0337

object Main extends App {
  val input = io.StdIn.readLine().split(" ").map(_.toInt)
  val n = input(0)
  val ad = input(1)

  n match {
    case 0 => println(converter(ad))
    case 1 => println(1868 + ad - 1)
    case 2 => println(1912 + ad - 1)
    case 3 => println(1926 + ad - 1)
    case 4 => println(1989 + ad - 1)
    case _ => ???
  }

  def converter(ad: Int): String = {
    ad match {
      case x if 1868 until 1912 contains x => s"M${x + 1 - 1868}"
      case x if 1912 until 1926 contains x => s"T${x + 1 - 1912}"
      case x if 1926 until 1989 contains x => s"S${x + 1 - 1926}"
      case x if 1989 until 2017 contains x => s"H${x + 1 - 1989}"
      case _ => ???
    }
  }
}
