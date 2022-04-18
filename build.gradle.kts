import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

// Learn more about Gradle by exploring our samples 
// at https://docs.gradle.org/7.4.2/samples

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
        implementation(kotlin("stdlib-jdk11"))
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            jvmTarget = "11"
            freeCompilerArgs = listOf("-Xjsr305=strict")
        }
    }
}
