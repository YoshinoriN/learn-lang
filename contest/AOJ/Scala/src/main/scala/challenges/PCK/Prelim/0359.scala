package challenges.pck.prelim.p0359

object Main extends App {
  io.StdIn.readLine().toInt % 7 match {
    case 0 => println("thu")
    case 1 => println("fri")
    case 2 => println("sat")
    case 3 => println("sun")
    case 4 => println("mon")
    case 5 => println("tue")
    case 6 => println("wed")
  }
}
