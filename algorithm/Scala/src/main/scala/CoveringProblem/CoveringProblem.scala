package CoveringProblem

object CoveringProblem extends App {

  case class Station(name: String, state: List[String])

  //カバー対象の県のリスト
  val neededPrefectures : List[String] = List("三重", "岡山", "和歌山", "兵庫", "大阪", "京都", "滋賀", "香川")

  //各放送局がカバーしている県
  val stations: List[Station] = List(
    Station("放送局1", List("兵庫", "大阪", "京都")),
    Station("放送局2", List("岡山", "兵庫", "三重")),
    Station("放送局3", List("和歌山", "大阪", "滋賀")),
    Station("放送局4", List("大阪", "京都")),
    Station("放送局5", List("滋賀", "香川")),
  )

  val result = search(neededPrefectures, stations, List())
  println(result)

  def search(neededPref: List[String], stations: List[Station], result: List[String]): List[String] = {
    if (neededPref.isEmpty) {
      result
    } else {
      // カバー対象の県のリストを順次処理しつつも、積集合で処理対象の県を含めて最もカバー率の高い放送局を取得する
      val s = stations.map(s => Station(s.name, List(neededPref.head) intersect s.state)).maxBy(_.state.length)

      // カバー済みになった県と放送局を除外して続けて調べる
      search(neededPref diff stations.filter(_.name == s.name).head.state, stations.filter(_.name != s.name), result :+ s.name)
    }
  }

}

/*
結果
List(放送局2, 放送局3, 放送局1, 放送局5)
*/
