enablePlugins(GhpagesPlugin)

organization       := "com.nrinaudo"
scalaVersion       := "3.0.1"
graphvizStylesheet := Some(graphvizSourceDirectory.value / "style.dss")

scalacOptions ++= Seq("-source", "future", "-Ykind-projector:underscores", "-language:strictEquality")

SitePlugin.autoImport.makeSite / includeFilter :=
  "*.yml" | "*.md" | "*.html" | "*.css" | "*.png" | "*.jpg" | "*.gif" | "*.js" | "*.eot" | "*.svg" | "*.ttf" |
    "*.woff" | "*.woff2" | "*.otf"

git.remoteRepo := "git@github.com:nrinaudo/dsl-tagless.git"
