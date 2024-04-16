plugins {
    kotlin("jvm") version "1.9.23"
//    id("org.jetbrains.compose") version "0.5.0"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    google()
    mavenCentral()
}

dependencies {
    implementation("org.xerial", "sqlite-jdbc", "3.36.0.1")
    implementation("org.jetbrains.exposed", "exposed-core", "0.49.0")
    implementation("org.jetbrains.exposed", "exposed-dao", "0.49.0")
    implementation("org.jetbrains.exposed", "exposed-jdbc", "0.49.0")
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(19)
}
