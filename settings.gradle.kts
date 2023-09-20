pluginManagement {
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
    }
}

rootProject.name = "Rick & Morty"
include(":app")
include(":product")
include(":product:charactersList")
include(":domain")
include(":data")
include(":product:landing")
include(":components")
include(":product:charactersDetails")
