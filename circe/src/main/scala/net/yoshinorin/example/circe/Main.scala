package net.yoshinorin.akkaexample

import io.circe.parser._
import io.circe.parser.decode
import io.circe.syntax._
import io.circe.generic.auto._
import io.circe.generic.semiauto._

object Main {

  val rawJsons: String =
    """
    [
      {
        "id": "1",
        "name": "hoge",
        "description": "example data",
        "child": ["A","B","C"]
      },
      {
        "id": "2",
        "name": "hoge2",
        "description": "example data2",
        "child": ["D","E","F"]
      }
    ]
    """.stripMargin

  def main(args: Array[String]): Unit = {
    this.parseJson()
    this.encodeJson()
    this.decodeJson()
    this.caseClassEncode()
    this.caseClassDecode()
  }

  def parseJson(): Unit = {
    val x = parse(rawJsons)
    for {
      y <- x
    } {
      println(y)
    }
  }

  def encodeJson(): Unit = {
    val intsJson = List(1, 2, 3).asJson
    println(intsJson)
  }

  def decodeJson(): Unit = {
    val s = decode[List[String]]("""["a", "b", "c", "d"]""")
    println(s)

    val i = decode[List[Int]]("[1,3,5,7,10]")
    println(i)
    i match {
      case Right(s) => {
        s.foreach(println(_))
      }
      case Left(f) => println("Failed")
    }
  }

  def caseClassEncode(): Unit = {
    val c1 = exampleCaseClassOne(1, "ex1").asJson
    println(c1)

    val c2 = exampleCaseClassTwo(2, "ex2", List("A", "B", "C")).asJson
    println(c2)

    val nestedC2 = List(
      exampleCaseClassTwo(3, "ex3", List("A", "B", "C")),
      exampleCaseClassTwo(4, "ex4", List("D", "E", "F"))
    ).asJson
    println(nestedC2)
  }

  def caseClassDecode(): Unit = {
    val rawJsons = """[{"id": "1", "name": "ex1"}]"""
  }

  case class exampleCaseClassOne(
    id: Int,
    name: String
  )

  case class exampleCaseClassTwo(
    id: Int,
    name: String,
    child: List[String]
  )

}
