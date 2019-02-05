scalaVersion := "2.12.1"

/*
下記を記述することでscalacが...

今後廃止予定のAPI使用(-deprecation)
明示的に宣言しないといけない実験的な機能や注意しないといけない機能を使用している(-feature)
型消去などでパターンマッチがゆうこうに機能しない(-unchecked)
その他、望ましくない書き方についての情報(-Xlint)

といった警告を表示してくれるようになる
 */
scalacOptions ++= Seq("-deprecation", "-feature", "-unchecked", "-Xlint")

addSbtPlugin("io.get-coursier" % "sbt-coursier" % "1.0.0-M15")