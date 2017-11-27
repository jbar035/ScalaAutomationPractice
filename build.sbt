import play.core.PlayVersion

name := "cucumber-learning"

version := "0.0.1"

scalaVersion := "2.11.11"

val ScalatestVersion = "3.0.1"
val CucumberVersion = "1.2.5"

credentials += Credentials(Path.userHome / ".sbt" / ".credentials")

val hmrcRepoHost = java.lang.System.getProperty("hmrc.repo.host", "https://nexus-preview.tax.service.gov.uk")

scalacOptions ++= Seq("-unchecked", "-deprecation")

resolvers ++= Seq(
  "hmrc-snapshots" at hmrcRepoHost + "/content/repositories/hmrc-snapshots",
  "hmrc-releases" at hmrcRepoHost + "/content/repositories/hmrc-releases",
  "typesafe-releases" at hmrcRepoHost + "/content/repositories/typesafe-releases")

resolvers += "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"


libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % ScalatestVersion % "test",
  "org.seleniumhq.selenium" % "selenium-java" % "3.4.0" % "test",
  "com.google.guava" % "guava" % "21.0",
  "org.pegdown" % "pegdown" % "1.6.0" % "test",
  "info.cukes" % "cucumber-junit" % CucumberVersion % "test",
  "info.cukes" % "cucumber-picocontainer" % CucumberVersion % "test",
  "info.cukes" %% "cucumber-scala" % CucumberVersion % "test",
  "org.typelevel" %% "cats" % "0.9.0",
  "com.typesafe.play" %% "play-test" % PlayVersion.current
)
