plugins {
    java
    application
}

repositories {
    mavenCentral()
}

val slf4jVersion = "1.7.30"

dependencies {
    implementation(group = "org.slf4j", name = "slf4j-api", version = slf4jVersion)
    implementation(group = "org.slf4j", name = "slf4j-simple", version = slf4jVersion)

    // Use JUnit Jupiter API for testing.
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")

    // Use JUnit Jupiter Engine for testing.
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.6.0")
}

application {
    mainClass.set("dgroomes.App")
}

val test by tasks.getting(Test::class) {
    useJUnitPlatform()
}
