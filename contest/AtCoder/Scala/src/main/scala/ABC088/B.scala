package ABC088.B

object Main extends App {

  val n = io.StdIn.readLine().toInt
  val nums = io.StdIn.readLine().split(' ').map(_.toInt).toSeq.sorted.reverse

  val alice = nums.zipWithIndex.filter(_._2 % 2 == 0).map(_._1).sum
  val bob = nums.zipWithIndex.filter(_._2 % 2 != 0).map(_._1).sum

  println(alice - bob)

}

/*
https://atcoder.jp/contests/abc088/tasks/abc088_b

3
2 7 4

4
20 18 2 18

 */
