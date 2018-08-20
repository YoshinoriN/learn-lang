lazy val root = project in file(".")

name := "circe-example"
organization := "net.yoshinorin"
version := "0.1"
scalaVersion := "2.12.6"

scalacOptions ++= Seq(
  "-deprecation",
  "-feature",
  "-unchecked"
)

libraryDependencies ++= Seq(

)

scalafmtOnCompile := true