package ABC085.C

object Main extends App {
  val input = io.StdIn.readLine().split(' ')
  val n = input(0).toInt
  val y = input(1).toInt
  var c = 0
  for (a <- 0 to n) {
    for (b <- 0 to n - a) {
      c = n - a - b
      if ((a * 10000 + b * 5000 + c * 1000) == y) {
        println(s"$a $b $c")
        sys.exit
      }
    }
  }
  println("-1 -1 -1")
}

/*
https://atcoder.jp/contests/abc085/tasks/abc085_c

20 196000
1000 1234000
2000 0 0
 */
