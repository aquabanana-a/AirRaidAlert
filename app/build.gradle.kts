plugins {
    id("base-app")
}

android {
    namespace = "com.banana.ara"
}

dependencies {
    implementation(project(":api"))

    implementation(Dependencies.kotlinLibraries)

    implementation(Dependencies.AndroidX.coreKtx)
    implementation(Dependencies.AndroidX.appcompat)
    implementation(Dependencies.AndroidX.material)
    implementation(Dependencies.AndroidX.constraintLayout)

    implementation(Dependencies.rxJavaLibraries)

    implementation(Dependencies.AndroidX.navigation)
    implementation(Dependencies.AndroidX.navigationUi)

    // Unit tests
    testImplementation(Dependencies.testLibraries)
}