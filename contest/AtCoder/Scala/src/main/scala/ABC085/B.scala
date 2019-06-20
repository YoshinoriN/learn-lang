package ABC085.B

object Main extends App {
  val nums = for(l <- scala.io.Source.stdin.getLines.drop(1)) yield (l.toInt)
  println(nums.toSet.size)
}

/*
https://atcoder.jp/contests/abc085/tasks/abc085_b

 */
