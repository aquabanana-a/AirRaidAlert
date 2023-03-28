import gradle.kotlin.dsl.accessors._6290cb8d6b896674b22d6c4b18eaf7bd.implementation

plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
}

android {
    compileSdk = Config.compileSdk

    defaultConfig {
        minSdk = Config.minSdk
        targetSdk = Config.targetSdk

        versionCode = Config.versionCode
        versionName = Config.versionName
        applicationId = Config.applicationId

        testInstrumentationRunner = Config.androidTestInstrumentation
    }
    buildTypes {
        debug {}
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), Config.proguardRules)
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
}