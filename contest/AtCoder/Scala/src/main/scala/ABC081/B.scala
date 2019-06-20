package ABC081B

object Main extends App {

  val n = io.StdIn.readLine().toInt
  val nums = io.StdIn.readLine().split(' ').map(_.toInt)
  calc(nums)

  def calc(nums: Array[Int], cnt: Int = 0): Array[Int] = {
    val t = for (x <- nums) yield {
      if (x % 2 != 0) {
        println(cnt)
        sys.exit
      }
      x / 2
    }
    calc(t, cnt + 1)
  }

}



/*
https://atcoder.jp/contests/abc081/tasks/abc081_b

3
8 12 40

3
8 24 40

4
5 6 8 10

*/
