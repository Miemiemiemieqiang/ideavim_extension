import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("java")
    id("org.jetbrains.intellij") version "1.4.0"
    id("org.jetbrains.kotlin.jvm") version "1.6.0"
    id("maven-publish")
}

intellij {
    pluginName.set("IdeaVimExtension")
    version.set("IC-2021.3")
    plugins.add("IdeaVIM:1.10.0")
    updateSinceUntilBuild.set(false)
    downloadSources.set(true)
}

tasks.withType<KotlinCompile> {
    kotlinOptions.apiVersion = "1.5"
    kotlinOptions.languageVersion = "1.5"
    kotlinOptions.jvmTarget = "1.8"
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
}

group = "io.github.hadix"

repositories {
    mavenCentral()
}

publishing {
    repositories {
        maven {
            name = "GitHubPackages"
            setUrl("https://maven.pkg.github.com/Miemiemiemieqiang/ideavim_extension")
            credentials {
                username = System.getenv("GITHUB_ACTOR")
                password = System.getenv("GITHUB_TOKEN")
            }
        }
    }
}