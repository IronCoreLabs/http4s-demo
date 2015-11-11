resolvers += Resolver.sonatypeRepo("releases")

addSbtPlugin("org.brianmckenna" % "sbt-wartremover" % "0.14")

addSbtPlugin("org.scalastyle" %% "scalastyle-sbt-plugin" % "0.7.0")

addSbtPlugin("com.typesafe.sbt" % "sbt-scalariform" % "1.3.0")

addSbtPlugin("com.typesafe.sbteclipse" % "sbteclipse-plugin" % "3.0.0")

resolvers += Resolver.url("scoverage-bintray", url("https://dl.bintray.com/sksamuel/sbt-plugins/"))(Resolver.ivyStylePatterns)

resolvers += Classpaths.sbtPluginReleases

// *** Measure code coverage of unit tests
addSbtPlugin("org.scoverage" % "sbt-scoverage" % "1.3.3")
