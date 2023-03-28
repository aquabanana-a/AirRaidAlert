rootProject.name = "Air Raid Alert"
include(
    ":app",
    ":api"
)

val isCiServer = System.getenv().containsKey("CI")
buildCache {
    local {
        isEnabled = !isCiServer
    }
    remote<HttpBuildCache> {
        url = uri("http://gradle-cache.gradle-cache/cache/")
        isEnabled = isCiServer
        isPush = isCiServer
    }
}

pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
        maven { url = uri("https://maven.google.com") }
    }
}