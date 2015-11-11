scalaVersion := "2.11.7"

val ScalazVersion = "7.1.4"
val Http4sVersion = "0.10.0"


Lint.settings

resolvers ++= Seq(
  "Typesafe repository" at "http://repo.typesafe.com/typesafe/release/",
  "Scalaz Bintray Repo" at "http://dl.bintray.com/scalaz/releases"
)

libraryDependencies ++= Seq(
  "org.scalaz" %% "scalaz-core" % ScalazVersion, // for type awesomeness
  "org.scalaz" %% "scalaz-concurrent" % ScalazVersion, // for type awesomeness
  "io.argonaut" %% "argonaut" % "6.1", // json (de)serialization scalaz style
  "org.http4s" %% "http4s-dsl" % Http4sVersion,
  "org.http4s" %% "http4s-blaze-core" % Http4sVersion,
  "org.http4s" %% "http4s-blaze-server" % Http4sVersion,
  "org.http4s" %% "http4s-argonaut" % Http4sVersion
)


// Apply default Scalariform formatting.
// Reformat at every compile.
// c.f. https://github.com/sbt/sbt-scalariform#advanced-configuration for more options.
scalariformSettings

scalacOptions ++= Seq(
  "-deprecation",
  "-encoding", "UTF-8", // yes, this is 2 args
  "-feature",
  "-unchecked",
  "-language:higherKinds",
  "-Xfatal-warnings",
  // "-Xlog-implicits",
  "-Xlint",
  "-Yno-adapted-args",
  "-Ywarn-numeric-widen",
  "-Ywarn-value-discard",
  "-Xfuture"
)
