name := "Niagara"

version := "1.0"

scalaVersion := "2.11.7"

resolvers += "Typesafe Repository" at  "http://repo.typesafe.com/typesafe/releases/"

// Akka http version
lazy val akkaHttpVersion = "2.0.3"

// Actor
val dependencyList = Seq( "com.typesafe.akka" %% "akka-actor" % "2.3.14",
                          "com.typesafe.akka" %% "akka-stream-experimental" % akkaHttpVersion,
                          "com.typesafe.akka" %% "akka-http-core-experimental" % akkaHttpVersion,
                          "com.typesafe.akka" %% "akka-http-experimental" % akkaHttpVersion,
                          "com.typesafe.akka" %% "akka-http-spray-json-experimental" % akkaHttpVersion)

libraryDependencies := dependencyList