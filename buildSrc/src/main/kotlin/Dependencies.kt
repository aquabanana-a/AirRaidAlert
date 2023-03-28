import org.gradle.api.artifacts.dsl.DependencyHandler

object Dependencies {
    object Versions {
        const val buildToolsVersion = "7.4.2"
        const val crashlyticsGradle = "2.9.2"
        const val googleServices = "4.3.15"
    }

    object Kotlin {
        object Versions {
            const val kotlin = "1.8.0"
            const val kotlinCoroutines = "1.6.4"
            const val kotlinSerialization = "1.5.0"
        }

        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
        const val stdlibCommon = "org.jetbrains.kotlin:kotlin-stdlib-common:$${Versions.kotlin}"
        const val stdlibJdk = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$${Versions.kotlin}"
        const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.kotlinCoroutines}"
        const val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.kotlinCoroutines}"
        const val serializationCore = "org.jetbrains.kotlinx:kotlinx-serialization-core:${Versions.kotlinSerialization}"
        const val serializationJson = "org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.kotlinSerialization}"
    }

    object AndroidX {
        object Versions {
            const val appcompat = "1.6.1"
            const val material = "1.8.0"
            const val annotations = "1.6.0"
            const val coreKtx = "1.9.0"
            const val recyclerView = "1.3.0"
            const val constraintLayout = "2.1.4"
            const val fragment = "1.5.6"
            const val swipeRefreshLayout = "1.1.0"
            const val dataStore = "1.0.0"
        }

        const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
        const val annotations = "androidx.annotation:annotation:${Versions.annotations}"
        const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
        const val recyclerView = "androidx.recyclerview:recyclerview:${Versions.recyclerView}"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
        const val material = "com.google.android.material:material:${Versions.material}"
        const val fragment = "androidx.fragment:fragment:${Versions.fragment}"
        const val fragmentKtx = "androidx.fragment:fragment-ktx:${Versions.fragment}"
        const val swipeRefreshLayout = "androidx.swiperefreshlayout:swiperefreshlayout:${Versions.swipeRefreshLayout}"
        const val dataStore = "androidx.datastore:datastore-preferences-core:${Versions.dataStore}"
    }

    object Retrofit {
        object Versions {
            const val retrofit = "2.9.0"
            const val retrofitSerializationConverter = "0.8.0"
        }

        val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
        val serializationConverter = "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:${Versions.retrofitSerializationConverter}"
    }

    object Navigation {
        object Versions {
            const val navigation = "2.5.3"
        }

        const val fragment = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
        const val ui = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
        const val features = "androidx.navigation:navigation-dynamic-features-fragment:${Versions.navigation}"
    }

    object Test {
        object Versions {
            const val junit = "4.13.2"
            const val junitExt = "1.1.5"
            const val espressoCore = "3.5.1"
        }

        const val junit = "junit:junit:${Versions.junit}"
        const val junitExt = "androidx.test.ext:junit:${Versions.junitExt}"
        const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espressoCore}"
    }

    object Other {
        object Versions {

        }

    }

    val kotlinLibraries = arrayListOf<String>().apply {
        add(Kotlin.stdlib)
        add(Kotlin.stdlibCommon)
        add(Kotlin.stdlibJdk)
        add(Kotlin.coroutinesCore)
        add(Kotlin.coroutinesAndroid)
        add(Kotlin.serializationJson)
    }

    val testLibraries = arrayListOf<String>().apply {
        add(Test.junit)
        add(Test.junitExt)
        //add(Test.espressoCore)
    }
}

fun DependencyHandler.kapt(list: List<String>) {
    list.forEach { dependency ->
        add("kapt", dependency)
    }
}

fun DependencyHandler.implementation(list: List<String>) {
    list.forEach { dependency ->
        add("implementation", dependency)
    }
}

fun DependencyHandler.androidTestImplementation(list: List<String>) {
    list.forEach { dependency ->
        add("androidTestImplementation", dependency)
    }
}

fun DependencyHandler.testImplementation(list: List<String>) {
    list.forEach { dependency ->
        add("testImplementation", dependency)
    }
}