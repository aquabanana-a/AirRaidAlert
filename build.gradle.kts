buildscript {
    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath("com.android.tools.build:gradle:${Dependencies.Versions.buildToolsVersion}")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${Dependencies.Kotlin.Versions.kotlin}")
        classpath("com.google.firebase:firebase-crashlytics-gradle:${Dependencies.Versions.crashlyticsGradle}")
        classpath("org.jetbrains.kotlin:kotlin-serialization:${Dependencies.Kotlin.Versions.kotlin}")
        classpath("com.google.gms:google-services:${Dependencies.Versions.googleServices}")
    }
}