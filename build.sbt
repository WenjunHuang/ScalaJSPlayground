import Dependencies._

lazy val root = (project in file(".")).
    enablePlugins(ScalaJSPlugin, ScalaJSBundlerPlugin).
    settings(
        inThisBuild(List(
            organization := "com.github/wenjunhuang",
            scalaVersion := "2.12.2",
            version := "0.1.0-SNAPSHOT"
        )),
        name := "ScalaJSPlayground",
        libraryDependencies += "com.github.japgolly.scalajs-react" %%% "core" % "1.0.1",
        libraryDependencies += scalaTest % Test,
        npmDependencies in Compile ++= Seq(
            "react" -> "15.5.4",
            "react-dom" -> "15.5.4")
    )
