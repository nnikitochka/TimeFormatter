plugins {
    kotlin("jvm") version "2.1.20"
}

group = "nn.edition.utils.format.time"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
}

kotlin {
    jvmToolchain(21)
}