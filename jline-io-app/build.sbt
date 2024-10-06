val scala3Version = "3.4.0"
//val scala3TargetVersion = "3.3"

lazy val root = (project in file("."))
  .settings(
    organization         := "Develeon",
    scalaVersion         := scala3Version,
    name                 := "jline-test",
    Compile / run / fork := true,
    libraryDependencies ++= Seq(
      "org.typelevel"       %% "cats-core"   % "2.12.0",
      "org.typelevel"       %% "cats-effect" % "3.5.4",
      "org.jline"            % "jline"       % "3.25.0",
      "org.fusesource.jansi" % "jansi"       % "2.4.1"
    )
  )
