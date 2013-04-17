name :="ScalaWithMongo"

version :="1.0"

scalaVersion :="2.10.0"

resolvers += "Scala-tools" at "https://oss.sonatype.org/content/groups/scala-tools"

resolvers += "Sonatype Snapshot" at "https://oss.sonatype.org/content/repositories/releases"

resolvers += "Novus Release Repository" at "http://repo.novus.com/releases/"

resolvers += "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"

 libraryDependencies ++= Seq(
            "org.mongodb" % "casbah_2.10" % "2.5.1",
            "org.scalatest" % "scalatest_2.10" % "1.9.1" % "test",
            "junit" % "junit" % "4.7" % "test",
            "org.specs2" % "specs2_2.10" % "1.14" % "test" ,
            "com.novus" %% "salat" % "1.9.2-SNAPSHOT",
            "org.slf4j" % "slf4j-simple" % "1.6.4"        
     )