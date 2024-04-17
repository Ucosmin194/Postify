import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    kotlin("jvm") version "1.9.23"
    id("org.jetbrains.compose") version "1.6.1"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    google()
    mavenCentral()
    maven("https://jitpack.io")
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
}

dependencies {
    implementation("org.xerial", "sqlite-jdbc", "3.36.0.1")
    implementation("org.jetbrains.exposed", "exposed-core", "0.49.0")
    implementation("org.jetbrains.exposed", "exposed-dao", "0.49.0")
    implementation("org.jetbrains.exposed", "exposed-jdbc", "0.49.0")
    implementation("androidx.compose.ui", "ui", "1.6.1")
    implementation("androidx.compose.material", "material", "1.6.1")
    implementation("androidx.compose.ui", "ui-tooling", "1.6.1")
    implementation("androidx.compose.runtime", "runtime", "1.6.1")
    implementation("io.ktor:ktor-client-core:2.3.10")
    implementation("io.ktor:ktor-client-json:2.3.10")
    implementation("io.ktor:ktor-client-apache:2.3.10")
    implementation("io.ktor:ktor-client-content-negotiation:2.3.10")
    implementation("io.ktor:ktor-serialization-gson:2.3.10")
    implementation("io.ktor:ktor-client-logging:2.3.10")
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(19)
}

compose.desktop {
    application {
        mainClass = "MainKt"
        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb, TargetFormat.Rpm)
            packageName = "Postify"
            packageVersion = "1.0.0"
        }
    }
}
