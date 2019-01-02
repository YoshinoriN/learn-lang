package ABC049.C

object Main extends App {

  f(io.StdIn.readLine().reverse.toList)

  def f(s: List[Char]): Unit = {
    if (s.isEmpty) {
      println("YES")
      sys.exit
    }
    s match {
      // _* がその他全てを意味する。@でそれらに変数名を指定できる。
      // つまり x @ _* でListの残りがxに格納される
      case List('m', 'a', 'e', 'r', 'd', x @ _*) => f(x.toList)
      case List('r', 'e', 'm', 'a', 'e', 'r', 'd', x @ _*) => f(x.toList)
      case List('e', 's', 'a', 'r', 'e', x @ _*) => f(x.toList)
      case List('r', 'e', 's', 'a', 'r', 'e', x @ _*) => f(x.toList)
      case _ => {
        println("NO")
        sys.exit
      }
    }
  }
}

//Failed reason of memory limit exceed
//メモリオーバでダメな例
/*
object Main extends App {
  f(io.StdIn.readLine().reverse)

  def f(s: String): Unit = {
    if (s.length == 0) {
      println("YES")
      sys.exit
    }
    if (s.startsWith("maerd")) {
      f(s.drop(5))
    }
    if (s.startsWith("remaerd")) {
      f(s.drop(7))
    }
    if (s.startsWith("esare")) {
      f(s.drop(5))
    }
    if (s.startsWith("resare")) {
      f(s.drop(6))
    }
    println("NO")
    sys.exit
  }
}
*/
/*
https://atcoder.jp/contests/abc049/tasks/arc065_a

dreameraser
erasedream
dreamerer
*/
