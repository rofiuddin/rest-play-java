name := """testPlayApp"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  javaJdbc,
  cache,
  javaWs,
  "mysql" % "mysql-connector-java" % "5.1.36",
  javaJpa,
  "org.hibernate" % "hibernate-entitymanager" % "5.1.0.Final",
  evolutions
)