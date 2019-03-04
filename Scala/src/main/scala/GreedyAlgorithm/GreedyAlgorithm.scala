package GreedyAlgorithm

import java.time.LocalTime

object GreedyAlgorithm extends App {

  case class Lesson(subject: String, start: LocalTime, end: LocalTime)

  val startTime = LocalTime.of(9,0)
  val endTime = LocalTime.of(12,0)

  val lessons: List[Lesson] = List(
    Lesson("Art", LocalTime.of(9,0), LocalTime.of(10,0)),
    Lesson("NationalLanguage", LocalTime.of(9,30), LocalTime.of(10,30)),
    Lesson("Mathematics", LocalTime.of(10,0), LocalTime.of(11,0)),
    Lesson("Computer", LocalTime.of(10,30), LocalTime.of(11,30)),
    Lesson("Music", LocalTime.of(11,0), LocalTime.of(12,0))
  )

  val firstLesson = lessons.minBy(_.end)
  val result = findNextLesson(firstLesson, lessons, List(firstLesson))
  println(result)

  def findNextLesson(currentLesson: Lesson, lessons: List[Lesson], answer: List[Lesson]): List[Lesson] = {
    lessons.filter(l => l.start == currentLesson.end).headOption match {
      case Some(x) => { x
        findNextLesson(x, lessons, answer :+ x)
      }
      case _ => answer
    }
  }

}
