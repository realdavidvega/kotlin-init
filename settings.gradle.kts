pluginManagement {
  repositories {
    mavenCentral()
    gradlePluginPortal()
  }
}

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

// root project
rootProject.name = "kotlin-init"

// sub-projects
include("kotlin-init-core")
project(":kotlin-init-core").projectDir = file("core")
