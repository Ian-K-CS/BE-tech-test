ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.10"

lazy val root = (project in file("."))
  .settings(
    name := "BE-tech-test"
  )

val http4sVersion = "1.0.0-M39"

libraryDependencies ++= Seq(
  "org.http4s" %% "http4s-ember-client" % http4sVersion, //TODO not sure I need this as I want sttp for client calls.
  "org.http4s" %% "http4s-ember-server" % http4sVersion,
  "org.http4s" %% "http4s-dsl"          % http4sVersion,
  "org.http4s" %% "http4s-circe"        % http4sVersion,
  // Optional for auto-derivation of JSON codecs
  "io.circe" %% "circe-generic" % "0.14.5",
  // Optional for string interpolation to JSON model
  "io.circe" %% "circe-literal" % "0.14.5"
)

//addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.0" cross CrossVersion.full)