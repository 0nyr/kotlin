/*
 * This file was generated by the Gradle 'init' task.
 *
 * This is a general purpose Gradle build.
 * Learn more about Gradle by exploring our samples at https://docs.gradle.org/7.4.2/samples
 * This project uses @Incubating APIs which are subject to change.
 */

import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import net.onyr.tasks.*

plugins {
    kotlin("jvm") version "1.6.20"
}

allprojects {
    group = "net.onyr"
    version = "1.0.0-SNAPSHOT"

    repositories {
        mavenCentral()
    }
}

subprojects {
    apply {
        plugin("org.jetbrains.kotlin.jvm")  
    }

    dependencies {
        implementation(kotlin("stdlib-jdk8"))
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            jvmTarget = "11"
            freeCompilerArgs = listOf("-Xjsr305=strict")
        }
    }
}

buildscript {
    repositories {
        mavenCentral()
    }
}

//tasks.register<CustomTask>("customTask")