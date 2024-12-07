pluginManagement {
    includeBuild("build-logic")
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven(uri("https://androidx.dev/storage/compose-compiler/repository/"))
        maven(uri("https://jitpack.io"))
    }
}

rootProject.name = "DrugApp"
include(":app")
include(":core:ds")
include(":core:ui")
include(":core:common")
include(":core:model")
include(":core:network")
include(":core:test")
include(":data")
include(":presentation:login")
include(":presentation:home")
include(":presentation:drugdetails")
