plugins {
    id("java")
    application
}

group = "org.example"
version = "1.0-SNAPSHOT"

application{
    mainClass.set("org.example.TCPApplicationMain")
}

java{
    toolchain{
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.beust:jcommander:1.82")
    runtimeOnly("org.jcommander:jcommander:2.0")

    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.jar{
    manifest{
        attributes(
            "Main-Class" to application.mainClass.get()
        )
    }
    from({
        configurations.compileClasspath.get().map { if (it.isDirectory) it else zipTree(it) }
    })
}

tasks.test {
    useJUnitPlatform()
}