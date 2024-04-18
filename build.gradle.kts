import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    kotlin("multiplatform") version "1.9.23"
    id("org.jetbrains.compose") version "1.6.2"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    google()
    mavenCentral()
    maven("https://jitpack.io")
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
}

kotlin {
    jvm {
        jvmToolchain(19)
        withJava()
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                api("org.jetbrains.compose.runtime:runtime:1.6.2")
                api("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.0")
            }
        }
        val commonTest by getting {
            dependencies {
                api(kotlin("test-common"))
                api(kotlin("test-annotations-common"))
            }
        }
        val jvmMain by getting {
            dependencies {
                implementation(compose.desktop.currentOs)
                api("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.0")
                api("org.jetbrains.compose.ui:ui:1.6.2")
                api("org.jetbrains.compose.foundation:foundation:1.6.2")
                api("org.jetbrains.compose.material:material:1.6.2")
                api("org.jetbrains.compose.runtime:runtime:1.6.2")
            }
        }
        val jvmTest by getting {
            dependencies {
                api(kotlin("test-junit"))
                api("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.8.0")
            }
        }
    }
}

dependencies {
    commonMainImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.0")
    commonMainImplementation("org.xerial", "sqlite-jdbc", "3.36.0.1")
    commonMainImplementation("org.jetbrains.exposed", "exposed-core", "0.49.0")
    commonMainImplementation("org.jetbrains.exposed", "exposed-dao", "0.49.0")
    commonMainImplementation("org.jetbrains.exposed", "exposed-jdbc", "0.49.0")
    commonMainImplementation("io.ktor:ktor-client-core:2.3.10")
    commonMainImplementation("io.ktor:ktor-client-json:2.3.10")
    commonMainImplementation("io.ktor:ktor-client-apache:2.3.10")
    commonMainImplementation("io.ktor:ktor-client-content-negotiation:2.3.10")
    commonMainImplementation("io.ktor:ktor-serialization-gson:2.3.10")
    commonMainImplementation("io.ktor:ktor-client-logging:2.3.10")
    commonTestImplementation(kotlin("test"))
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