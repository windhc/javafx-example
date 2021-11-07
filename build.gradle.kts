plugins {
    id("java")
    id("application")
    id("org.openjfx.javafxplugin") version "0.0.10"
}

group = "com.windhc"
version = "1.0-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

repositories {
    maven { url = uri("https://maven.aliyun.com/repository/public") }
}

dependencies {
}

javafx {
    version = "17"
    modules = listOf("javafx.controls", "javafx.fxml")
}

application {
    mainClass.set("com.windhc.MainApp")
}

tasks.jar {
    manifest {
        attributes["Main-Class"] = "com.windhc.Launcher"
    }
    from(configurations.runtimeClasspath.get().map { if (it.isDirectory) it else zipTree(it) })
}

