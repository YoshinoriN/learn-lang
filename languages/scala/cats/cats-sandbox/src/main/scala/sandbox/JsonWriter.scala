import cats.Show
import cats.instances.int._ // for Show
import cats.instances.string._ // for Show

object Main {

  val showInt: Show[Int] = Show.apply[Int]
  val showString: Show[String] = Show.apply[String]

}
