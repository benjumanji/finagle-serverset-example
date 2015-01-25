com.twitter.scrooge.ScroogeSBT.newSettings

scalaVersion := "2.10.4"

resolvers ++= Seq(
  "Twitter's Repository" at "http://maven.twttr.com/"
)

libraryDependencies ++= Seq(
  "org.apache.thrift" % "libthrift" % "0.8.0",
  "com.github.finagle" %% "finch-core" % "0.4.0",
  "com.twitter" %% "finagle-core" % "6.24.0",
  "com.twitter" %% "finagle-http" % "6.24.0",
  "com.twitter" %% "finagle-serversets" %  "6.24.0",
  "com.twitter" %% "finagle-thriftmux" %  "6.24.0",
  "com.twitter" %% "scrooge-runtime" %  "3.17.0"
)
