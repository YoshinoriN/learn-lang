package ABC087.B

object Main extends App {

  val a = (0 to io.StdIn.readLine().toInt).map(_ * 500)
  val b = (0 to io.StdIn.readLine().toInt).map(_ * 100)
  val c = (0 to io.StdIn.readLine().toInt).map(_ * 50)
  val x = io.StdIn.readLine().toInt

  val ab = a.map(m => b.map(n => m + n)).flatten
  val abc = ab.map(m => c.map(n => m + n)).flatten
  println(abc.filter(_ == x).length)

}

/*
https://atcoder.jp/contests/abc087/tasks/abc087_b

2
2
2
100

5
1
0
150

30
40
50
6000
 */
