rootProject.name = "learn-kotlin"

pluginManagement {
    repositories {
        maven("https://dl.bintray.com/kotlin/kotlin-eap")
        mavenCentral()
        maven("https://plugins.gradle.org/m2/")
    }
}

// subprojects
// specify custom subproject path: https://docs.gradle.org/7.4.2/dsl/org.gradle.api.initialization.Settings.html#org.gradle.api.initialization.Settings:include(java.lang.String%5B%5D)
include("koans")
project(":koans").projectDir = file("exercises/koans")

includeBuild("exercises/tasks")
