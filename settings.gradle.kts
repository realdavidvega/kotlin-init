pluginManagement {
  repositories {
    mavenCentral()
    gradlePluginPortal()
  }
}

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

// root project
val projectName = "kotlin-init"
rootProject.name = projectName

// sub-projects
include("$projectName-core")
project(":$projectName-core").projectDir = file("core")

include("$projectName-examples")
project(":$projectName-examples").projectDir = file("examples")
