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

group = "io.github.Miemiemiemieqiang"

repositories {
    mavenCentral()
}

publishing {
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/Miemiemiemieqiang/ideavim_extension")
            credentials {
                username = project.findProperty("gpr.user") as String? ?: System.getenv("USERNAME")
                password = project.findProperty("gpr.key") as String? ?: System.getenv("TOKEN")
            }
        }
    }
    publications {
        register<MavenPublication>("gpr") {
            from(components["java"])
        }
    }
}