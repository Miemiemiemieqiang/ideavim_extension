import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	kotlin("jvm") version "1.8.10"
	id("org.jetbrains.intellij") version "1.17.2"
}

intellij {
	pluginName.set("IdeaVimExtension")
	version.set("2023.1.2")
	plugins.add("IdeaVIM:2.7.0")
	updateSinceUntilBuild.set(false)
	downloadSources.set(true)
}

tasks.withType<KotlinCompile> {
	kotlinOptions.jvmTarget = "17"
}

dependencies {
	implementation(kotlin("stdlib"))
}

group = "io.github.miemieqiang"
version = "1.7.4"

repositories {
	mavenCentral()
}