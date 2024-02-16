ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.12"

lazy val root = (project in file("."))
  .settings(
    name := "CatsPractice"
  )

libraryDependencies += "org.typelevel" %% "cats-core" % "2.9.0"

libraryDependencies += "org.scalatest" %% "scalatest" %"3.2.15" %"test"