name := "derevo"

version := "0.4.5"

scalaVersion := "2.12.6"

crossScalaVersions := List("2.11.12", "2.12.6")

libraryDependencies in ThisBuild += scalaOrganization.value % "scala-reflect" % scalaVersion.value % Provided

libraryDependencies in ThisBuild += compilerPlugin("org.scalamacros" % "paradise" % "2.1.1" cross CrossVersion.patch)

scalacOptions in ThisBuild ++= Vector(
  "-language:experimental.macros",
  "-language:higherKinds"
)

lazy val core = project

lazy val cats = project dependsOn core
lazy val circe = project dependsOn core
lazy val tethys = project dependsOn core
lazy val reactivemongo = project dependsOn core

lazy val derevo = project in file (".") aggregate (core, cats, circe, tethys, reactivemongo)