plugins {
    id("java")
    id("application")
    id("org.openjfx.javafxplugin") version "0.0.8"
}

group = "com.windhc"
version = "1.0-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_14
    targetCompatibility = JavaVersion.VERSION_14
}

repositories {
    maven { url = uri("https://maven.aliyun.com/repository/public") }
}

dependencies {
    testImplementation("junit:junit:4.12")
}

javafx {
    version = "14"
    modules = listOf("javafx.controls", "javafx.fxml")
}

application {
    mainClassName = "com.windhc.MainApp"
}

tasks.jar {
    manifest {
        attributes["Main-Class"] = "com.windhc.Launcher"
    }
    from(configurations.runtimeClasspath.get().map { if (it.isDirectory) it else zipTree(it) })
}

