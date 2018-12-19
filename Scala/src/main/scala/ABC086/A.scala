package abc086

object Main extends App {

  val line = io.StdIn.readLine().split(" ").map(_.toInt)

  (line(0) * line(1)) % 2 match {
    case 0 => println("Even")
    case _ => println("Odd")
  }

}

/*
3 4
3 5
1 10000
1 9999
 */
