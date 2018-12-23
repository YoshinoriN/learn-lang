package ABC083.B

object Main extends App {

  val input = io.StdIn.readLine().split(' ')
  val n = input(0).toInt
  val f = input(1).toInt
  val l = input(2).toInt

  val nums = for (x <- 0 to n) yield {
    Tuple2(x, x.toString.mkString(",").split(",").map(_.toInt).sum)
  }
  val result = for(y <- nums.filter(_._2 >= f).filter(_._2 <= l)) yield {
    y._1
  }
  println(result.sum)

}


/*
https://atcoder.jp/contests/abc083/tasks/abc083_b

20 2 5

10 1 2

100 4 16
 */
