package example

import doobie._
import doobie.implicits._
import doobie.util.ExecutionContexts
import cats._
import cats.data._
import cats.effect._
import cats.implicits._
import io.getquill.{ idiom => _, _ }
import doobie.quill.DoobieContext

case class Country(code: String, name: String, population: Int)

object Hello extends App {

  implicit val cs: ContextShift[IO] = IO.contextShift(ExecutionContexts.synchronous)
  val ctx: DoobieContext.MySQL[SnakeCase] = new DoobieContext.MySQL(SnakeCase)
  val transactor = Transactor.fromDriverManager[IO](
    "org.mariadb.jdbc.Driver",
    "jdbc:mariadb://127.0.0.1/example?useUnicode=true&characterEncoding=utf8mb4",
    "root",
    "pass"
  )

  import ctx._

  val q1 = quote { query[Country].filter(_.code == "GBR") }
  val r1 = run(q1)
  val t1 = r1.transact(transactor)
  t1.unsafeRunSync()

  val c = Country("JPN", "Japan", 120000000)
  val q2 = quote { query[Country].insert(lift(c)) }
  val r2 = run(q2)
  val t2 = r2.transact(transactor)
  val x = t2.unsafeRunSync()
  printf(x.toString)

}
