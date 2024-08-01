@file:Suppress("UnstableApiUsage")

val java: String = libs.versions.java.version
val ktfmt: String = libs.versions.ktfmt.version
val ktlint: String = libs.versions.ktlint.version

plugins {
  base
  alias(libs.plugins.kotlin.jvm)
  alias(libs.plugins.spotless)
  alias(libs.plugins.gradle.ktlint)
}

repositories {
  mavenLocal()
  mavenCentral()
}

dependencies {
  implementation(libs.bundles.kotlin)
  testImplementation(libs.bundles.kotest)
}

java {
  toolchain { languageVersion(java) }
}

kotlin { jvmToolchain { languageVersion(java) } }

spotless {
  kotlin { ktfmt(ktfmt).googleStyle() }
  kotlinGradle { ktfmt(ktfmt).googleStyle() }
}

ktlint { version.set(ktlint) }

tasks {
  val args = listOf("-Xjsr305=strict", "-Xcontext-receivers")
  compileKotlin { compilerOptions { freeCompilerArgs.addAll(args) } }
  compileTestKotlin { compilerOptions { freeCompilerArgs.addAll(args) } }
  test { useJUnitPlatform() }
}
