import scala.collection.mutable.Map

class CheckSumAccumulator {
  private var sum = 0
  def add (b: Byte) { sum += b }
  def chekcsum(): Int = ~(sum & 0xFF) + 1
}

// コンパニオンオブジェクト
object CheckSumAccumulator {
  private val cache = Map[String, Int]()
  def calculate(s: String): Int =
    if (cache.contains(s))
      cache(s)
    else {
      val acc = new CheckSumAccumulator
      for(c <- s)
        acc.add(c.toByte)
      val cs = acc.chekcsum()
      cache += (s -> cs)
      cs
    }
}
