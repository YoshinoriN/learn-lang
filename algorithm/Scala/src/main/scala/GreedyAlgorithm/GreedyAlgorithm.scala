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
    val maybeNextLesson = lessons.filter(_.start.compareTo(currentLesson.end) >= 0)
    if (maybeNextLesson.isEmpty) {
      answer
    } else  {
      val nextLesson = maybeNextLesson.minBy(_.end)
      findNextLesson(nextLesson, lessons, answer :+ nextLesson)
    }
  }

}

/*
List(Lesson(Art,09:00,10:00), Lesson(Mathematics,10:00,11:00), Lesson(Music,11:00,12:00))
 */
