name := "monadic-rx-scalatags"

version := "0.1"

scalaVersion := "2.12.6"

enablePlugins(ScalaJSPlugin)

libraryDependencies ++= Seq(
  "org.scala-js"  %%% "scalajs-dom" % "0.9.2",
  "in.nvilla"     %%% "monadic-rx"  % "0.4.0-RC1",
  "com.lihaoyi"   %%% "scalatags"   % "0.6.7",
  "org.scalatest" %%% "scalatest"   % "3.+"     % "test"
)

jsEnv := new org.scalajs.jsenv.jsdomnodejs.JSDOMNodeJSEnv