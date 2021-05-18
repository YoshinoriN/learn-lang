ThisBuild / scalaVersion     := "2.13.5"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.example"
ThisBuild / organizationName := "example"

lazy val root = (project in file("."))
  .settings(
    name := "doobie-quill-example",
    libraryDependencies ++= Seq(
      "org.tpolecat" %% "doobie-core" % "0.13.2",
      "org.tpolecat" %% "doobie-quill" % "0.12.1"
    )
  )
