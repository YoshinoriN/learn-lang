object Person {
  def printWeight(): Unit = {
    val taro = new Person("たろー", 20 ,70)
    println(taro.weight)
  }
}

class Person(name: String, age: Int, private val weight: Int)