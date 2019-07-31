buildscript {
    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath(Libs.androidGradlePlugin)
        classpath(Libs.Kotlin.gradlePlugin)
        classpath(Libs.Kotlin.extensions)
        classpath(Libs.gradleVersionsPlugin)
        classpath(Libs.AndroidX.Navigation.safeArgs)
    }
}

plugins {
    id("com.diffplug.gradle.spotless") version ("3.23.1")
    id("com.github.ben-manes.versions") version ("0.21.0")
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}

subprojects {
    apply(plugin = "com.diffplug.gradle.spotless")
    spotless {
        kotlin {
            target("**/*.kt")
            ktlint("0.31.0")
        }
    }
    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().all {
        kotlinOptions.apply {
            jvmTarget = "1.8"
            allWarningsAsErrors = true
        }
    }
}
