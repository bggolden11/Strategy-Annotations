name := "homework2"

version := "0.1"

scalaVersion := "2.13.1"

//mainClass in (Compile, run) := Some("Driver.MathMain")
libraryDependencies ++= Seq("org.json4s" %% "json4s-jackson" % "3.6.7",
  "org.apache.httpcomponents" % "httpclient" % "4.5.10",
  "org.scalactic" %% "scalactic" % "3.0.8",
  "org.scalatest" %% "scalatest" % "3.0.8" % "test",
  "com.typesafe" % "config" % "1.3.4",
  "ch.qos.logback" % "logback-classic" % "1.2.3")
