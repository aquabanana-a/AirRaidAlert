plugins {
    id("base-module")
    id("kotlinx-serialization")
    id("kotlin-kapt")
}

android {
    namespace = "com.banana.ara.api"
}

dependencies {
    implementation(Dependencies.kotlinLibraries)
    implementation(Dependencies.retrofitLibraries)
    implementation(Dependencies.rxJavaLibraries)
    testImplementation(Dependencies.testLibraries)
}