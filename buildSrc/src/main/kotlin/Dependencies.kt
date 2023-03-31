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
            const val dateTime = "0.4.0"
        }

        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
        const val stdlibCommon = "org.jetbrains.kotlin:kotlin-stdlib-common:$${Versions.kotlin}"
        const val stdlibJdk = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$${Versions.kotlin}"
        const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.kotlinCoroutines}"
        const val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.kotlinCoroutines}"
        const val serializationCore = "org.jetbrains.kotlinx:kotlinx-serialization-core:${Versions.kotlinSerialization}"
        const val serializationJson = "org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.kotlinSerialization}"
        const val dateTime = "org.jetbrains.kotlinx:kotlinx-datetime:${Versions.dateTime}"
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
            const val navigation = "2.5.3"
            const val navigationUi = "2.5.3"
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
        const val navigation = "androidx.navigation:navigation-fragment:${Versions.navigation}"
        const val navigationUi = "androidx.navigation:navigation-ui-ktx:${Versions.navigationUi}"
    }

    object RxJava {
        object Versions {
            const val runtime = "3.1.6"
            const val rxandroid = "3.0.2"
            const val rxkotlin = "3.0.1"
        }

        const val runtime = "io.reactivex.rxjava3:rxjava:${Versions.runtime}"
        const val rxandroid = "io.reactivex.rxjava3:rxandroid:${Versions.rxandroid}"
        const val rxkotlin = "io.reactivex.rxjava3:rxandroid:${Versions.rxkotlin}"
    }

    object Retrofit {
        object Versions {
            const val retrofit2 = "2.9.0"
            const val gsonConverter = "2.5.0"
            const val retrofitSerializationConverter = "0.8.0"
            const val rxJavaAdaper = "2.9.0"
        }

        val runtime = "com.squareup.retrofit2:retrofit:${Versions.retrofit2}"
        val gsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.gsonConverter}"
        val rxJavaAdapter = "com.squareup.retrofit2:adapter-rxjava3:${Versions.rxJavaAdaper}"
        val ktxSerializationConverter = "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:${Versions.retrofitSerializationConverter}"
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
        add(Kotlin.dateTime)
    }

    val retrofitLibraries = arrayListOf<String>().apply {
        add(Retrofit.runtime)
        add(Retrofit.rxJavaAdapter)
        add(Retrofit.gsonConverter)
        add(Retrofit.ktxSerializationConverter)
    }

    val rxJavaLibraries = arrayListOf<String>().apply {
        add(RxJava.runtime)
        add(RxJava.rxandroid)
        add(RxJava.rxkotlin)
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