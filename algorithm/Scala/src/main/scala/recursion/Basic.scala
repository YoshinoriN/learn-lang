package recursion

object Basic extends App {

  println(f(30000))

  def f(x: Int): Int = {
    if (x == 1) {
      x
    } else {
      x * f(x - 1)
    }
  }

}

/*
Exception in thread "main" java.lang.StackOverflowError
	at recursion.Basic$.f(Basic.scala:11)
	at recursion.Basic$.f(Basic.scala:11)
	at recursion.Basic$.f(Basic.scala:11)
*/
