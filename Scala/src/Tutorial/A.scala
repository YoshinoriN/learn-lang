object Main extends App {

  val firstLine = io.StdIn.readLine().toInt
  val secondLine = io.StdIn.readLine().split(' ').map(_.toInt)
  println((firstLine + secondLine.sum).toString + ' ' + io.StdIn.readLine())

}
