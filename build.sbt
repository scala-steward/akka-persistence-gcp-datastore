
val akkaVersion = "2.6.3"

val akkaPersistence      = "com.typesafe.akka"  %% "akka-persistence"       % akkaVersion
val akkaPersistenceQuery = "com.typesafe.akka"  %% "akka-persistence-query" % akkaVersion
val akkaTCK              = "com.typesafe.akka"  %% "akka-persistence-tck"   % akkaVersion
val javaUUIDGenerator    = "com.fasterxml.uuid" % "java-uuid-generator"     % "3.2.0"
val playJson             = "com.typesafe.play"  %% "play-json"              % "2.8.1"
val googleDatastore      = "com.google.cloud"   % "google-cloud-datastore"  % "1.102.0"

libraryDependencies ++= Seq(
  akkaPersistence % "compile",
  akkaPersistenceQuery,
  akkaTCK,
  javaUUIDGenerator % "compile",
  googleDatastore   % "compile",
  playJson          % "compile"
)

organization := "de.innfactory"
name := "akka-persistence-gcp-datastore"
version := "1.0.0"
scalaVersion := "2.13.1"
scalacOptions ++= Seq(
  "-deprecation",
  "-encoding",
  "UTF-8",
  "-explaintypes",
  "-Yrangepos",
  "-feature",
  "-language:higherKinds",
  "-language:existentials",
  "-unchecked",
  "-Xlint:_,-type-parameter-shadow",
  "-Xfatal-warnings",
  "-Ywarn-numeric-widen",
  "-Ywarn-unused:patvars,-implicits"
)

parallelExecution in ThisBuild := false
parallelExecution in Test := false
logBuffered in Test := false

testOptions += Tests.Setup(_ => sys.props("testing") = "true")
organizationName := "innFactory GmbH | innfactory.de"
startYear := Some(2020)
licenses += ("Apache-2.0", new URL("https://www.apache.org/licenses/LICENSE-2.0.txt"))

addCommandAlias("fmt", "all scalafmtSbt scalafmt test:scalafmt")
addCommandAlias(
  "check",
  "all scalafmtSbtCheck scalafmtCheck test:scalafmtCheck"
)

lazy val root = (project in file(".")).settings().enablePlugins(AutomateHeaderPlugin)
