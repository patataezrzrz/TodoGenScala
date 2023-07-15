name := "HelloWorld"
version := "0.1"
scalaVersion := "3.3.0"

libraryDependencies ++= Seq(
    "org.scalatest" %% "scalatest" % "3.2.16"% Test
)

val Http4sVersion = "1.0.0-M21"
val CirceVersion = "0.14.0-M5"
libraryDependencies ++= Seq(
  "org.http4s"      %% "http4s-blaze-server" % Http4sVersion,
  "org.http4s"      %% "http4s-circe"        % Http4sVersion,
  "org.http4s"      %% "http4s-dsl"          % Http4sVersion,
  "io.circe"        %% "circe-generic"       % CirceVersion,
)

libraryDependencies += "org.typelevel" %% "cats-effect" % "3.5.1"