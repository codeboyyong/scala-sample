 

name := "my_scala_sample"

version := "1.0"

organization := "codeboyyong"

scalaVersion := "2.10.4"
                  
libraryDependencies += "org.scalatest" %% "scalatest" % "1.9.1" % "test"

libraryDependencies += "junit" % "junit" % "4.10" % "test"

javacOptions ++= Seq("-source", "1.6", "-target", "1.6")

scalacOptions ++= Seq("-unchecked", "-deprecation")

pollInterval := 1000

fork := true

fork in Test := false

javaOptions += "-Xmx512m"

parallelExecution := true

parallelExecution in Test := false
