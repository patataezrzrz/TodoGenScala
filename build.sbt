name := "HelloWorld"
version := "0.1"
scalaVersion := "3.3.0"

libraryDependencies ++= Seq(
    "org.scalatest" %% "scalatest" % "3.2.16"% Test
)

val circeVersion = "0.14.1"

libraryDependencies ++= Seq(
  "io.circe" %% "circe-core",
  "io.circe" %% "circe-generic",
  "io.circe" %% "circe-parser"
).map(_ % circeVersion)
