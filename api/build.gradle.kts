plugins {
    id("base-module")
}

android {
    namespace = "com.banana.ara.api"
}

dependencies {
    implementation(Dependencies.kotlinLibraries)

    // Unit tests
    testImplementation(Dependencies.testLibraries)
}