import sbt._
import org.scalajs.sbtplugin.ScalaJSPlugin.autoImport._

/**
 * Application settings. Configure the build for your application here.
 * You normally don't have to touch the actual build definition after this.
 */
object Settings {
  /** The name of your application */
  val name = "scalajs-spa"

  /** The version of your application */
  val version = "1.1.5"

  /** Options for the scala compiler */
  val scalacOptions = Seq(
    "-Xlint",
    "-unchecked",
    "-deprecation",
    "-feature"
  )

  /** Declare global dependency versions here to avoid mismatches in multi part dependencies */
  object Versions {
    val scala = "2.12.6"
    val scalaDom = "0.9.5"
    val scalajsReact = "1.2.0"
    val scalaCSS = "0.5.5"
    val scalaTags = "0.6.7"
    val log4js = "1.4.13"
    val autowire = "0.2.6"
    val booPickle = "1.3.0"
    val diode = "1.1.3"
    val uTest = "0.6.4"

    val react = "16.1.0"
    val jQuery = "3.2.1"
    val bootstrap = "4.1.0"
    val chartjs = "2.7.2"

    val scalajsScripts = "1.1.2"
    
    val circe = "0.9.3"
    val akka = "2.5.12"
    val akkaHttp = "10.1.0"
  
    val cassandraPersistence = "0.83"
  
  
  }

  /**
   * These dependencies are shared between JS and JVM projects
   * the special %%% function selects the correct version for each project
   */
  val sharedDependencies = Def.setting(Seq(
    "com.lihaoyi" %%% "autowire" % Versions.autowire,
    "io.suzaku" %%% "boopickle" % Versions.booPickle
  ))

  /** Dependencies only used by the JVM project */
  val jvmDependencies = Def.setting(Seq(
    "com.vmunier" %% "scalajs-scripts" % Versions.scalajsScripts,
    "com.lihaoyi" %% "scalatags" % Versions.scalaTags,
    "org.webjars" % "font-awesome" % "4.3.0-1" % Provided,
    "org.webjars" % "bootstrap" % Versions.bootstrap % Provided,
    "org.webjars.bower" % "compass-mixins" % "0.12.7" % Provided,
    "com.lihaoyi" %% "utest" % Versions.uTest % Test,
    /** testing */
    "org.scalatest" %% "scalatest" % "3.0.5",
    "com.github.dnvriend" %% "akka-persistence-inmemory" % "2.5.1.1",
    
    /** json */
    "io.circe" %% "circe-config" % "0.4.1",
    "io.circe" %% "circe-generic" % Versions.circe,
    "io.circe" %% "circe-core" % Versions.circe,
    "io.circe" %% "circe-parser" % Versions.circe,
    
    /** akka */
    "com.typesafe.akka" %% "akka-actor" % Versions.akka,
    "com.typesafe.akka" %% "akka-stream" % Versions.akka,
    "com.typesafe.akka" %% "akka-http" % Versions.akkaHttp,
    "de.heikoseeberger" %% "akka-http-circe" % "1.20.0",
    "com.typesafe.akka" %% "akka-testkit" % Versions.akka,
    "com.typesafe.akka" %% "akka-http-testkit" % Versions.akkaHttp,
    "com.typesafe.akka" %% "akka-slf4j" % Versions.akka,
    "com.typesafe.akka" %% "akka-persistence" % Versions.akka,
    "com.typesafe.akka" %% "akka-persistence-query" % Versions.akka,
    "com.typesafe.akka" %% "akka-cluster" % Versions.akka,
    "com.typesafe.akka" %% "akka-cluster-sharding" % Versions.akka,
    "com.typesafe.akka" %% "akka-cluster-tools" % Versions.akka,
  
    /** cassandra */
    "com.typesafe.akka" %% "akka-persistence-cassandra" % Versions.cassandraPersistence,
    "com.typesafe.akka" %% "akka-persistence-cassandra-launcher" % Versions.cassandraPersistence,
  
    /** logging */
    "com.typesafe.scala-logging" %% "scala-logging" % "3.7.2",
    "ch.qos.logback" % "logback-classic" % "1.2.3"
    
  ))

  /** Dependencies only used by the JS project (note the use of %%% instead of %%) */
  val scalajsDependencies = Def.setting(Seq(
    "com.github.japgolly.scalajs-react" %%% "core" % Versions.scalajsReact,
    "com.github.japgolly.scalajs-react" %%% "extra" % Versions.scalajsReact,
    "com.github.japgolly.scalacss" %%% "ext-react" % Versions.scalaCSS,
    "io.suzaku" %%% "diode" % Versions.diode,
    "io.suzaku" %%% "diode-react" % Versions.diode,
    "org.scala-js" %%% "scalajs-dom" % Versions.scalaDom,
    "com.lihaoyi" %%% "scalatags" % Versions.scalaTags,
    "com.lihaoyi" %%% "utest" % Versions.uTest % Test
  ))

  /** Dependencies for external JS libs that are bundled into a single .js file according to dependency order */
  val jsDependencies = Def.setting(Seq(
    "org.webjars.bower" % "react" % Versions.react / "react-with-addons.js" minified "react-with-addons.min.js" commonJSName "React",
    "org.webjars.bower" % "react" % Versions.react / "react-dom.js" minified "react-dom.min.js" dependsOn "react-with-addons.js" commonJSName "ReactDOM",
    "org.webjars" % "jquery" % Versions.jQuery / "jquery.js" minified "jquery.min.js",
    "org.webjars" % "bootstrap" % Versions.bootstrap / "bootstrap.js" minified "bootstrap.min.js" dependsOn "jquery.js",
    "org.webjars" % "chartjs" % Versions.chartjs / "Chart.js" minified "Chart.min.js",
    "org.webjars" % "log4javascript" % Versions.log4js / "js/log4javascript_uncompressed.js" minified "js/log4javascript.js"
  ))
}
