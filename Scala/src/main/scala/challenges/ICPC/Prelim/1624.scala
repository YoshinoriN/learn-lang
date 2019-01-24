package challenges.icpc.prelim.p1624

object Main extends App {
  var people = io.StdIn.readLine().toInt
  while(people != 0) {
    val incomes = io.StdIn.readLine().split(" ").map(_.toInt)
    println(incomes.filter(x => x <= (incomes.sum / incomes.size)).size)
    people = io.StdIn.readLine().toInt
  }
}
