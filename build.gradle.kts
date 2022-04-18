import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import net.onyr.koans.*

// Learn more about Gradle by exploring our samples 
// at https://docs.gradle.org/7.4.2/samples

plugins {
    kotlin("jvm") version "1.6.20"
}

repositories {
    mavenCentral()
    
}

dependencies {
    compile(kotlin("stdlib-jdk11"))
}

// list tasks here
task<IntroTask>("koans-intro")

tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = "11"
    }
}