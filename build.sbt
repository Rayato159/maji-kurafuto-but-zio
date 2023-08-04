ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.3.0"

libraryDependencies ++= Seq(
  "dev.zio" %% "zio" % "2.0.15",
  "io.d11"  %% "zhttp" % "2.0.0-RC10",
  "dev.zio" %% "zio-jdbc" % "0.1.0",
  "dev.zio" %% "zio-json" % "0.5.0"
)

lazy val root = (project in file("."))
  .settings(
    name := "zio-practice"
  )
