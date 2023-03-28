plugins {
    id("base-app")
}

android {
    namespace = "com.banana.ara"
}

dependencies {
    implementation(Dependencies.kotlinLibraries)

    implementation(Dependencies.AndroidX.coreKtx)
    implementation(Dependencies.AndroidX.appcompat)
    implementation(Dependencies.AndroidX.material)
    implementation(Dependencies.AndroidX.constraintLayout)

    implementation(Dependencies.rxJavaLibraries)

    implementation(project(mapOf("path" to ":api")))

    // Unit tests
    testImplementation(Dependencies.testLibraries)
}