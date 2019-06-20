package abc081

object Main extends App {
  println(io.StdIn.readLine().mkString(",").split(",").map(_.toInt).sum)
}

/*
https://atcoder.jp/contests/abc081/tasks/abc081_a
101
111
000
001
110
 */
