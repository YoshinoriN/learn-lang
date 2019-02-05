package recursion

object Accumulator extends App {

  println(f(30000))

  def f(x: Long, acc: Long = 1): Long = {
    if (x == 1) {
      acc
    } else {
      f(x - 1, x * acc)
    }
  }

}

