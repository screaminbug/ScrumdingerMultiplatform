import java.net.URI

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
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
        maven {
            url = URI("https://androidx.dev/storage/compose-compiler/repository/")
        }
        maven {
            url = URI("https://maven.pkg.jetbrains.space/kotlin/p/kotlin/dev/")
        }
    }
}

rootProject.name = "Scrumdinger"
include(":androidApp")
include(":shared")