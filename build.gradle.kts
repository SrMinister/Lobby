plugins {
    java
    id("com.github.johnrengelman.shadow") version "6.1.0"
}

group = "com.artyx.lobby"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    mavenLocal()
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
    maven ("https://oss.sonatype.org/content/groups/public/")
    maven ("https://libraries.minecraft.net/")
    maven("https://repo.nickuc.com/maven2/")
    maven ("https://repo.codemc.org/repository/maven-public")

    maven( "https://jitpack.io")
}

dependencies {


    compileOnly ("org.spigotmc:spigot-api:1.8.8-R0.1-SNAPSHOT")
    compileOnly ("com.github.azbh111:craftbukkit-1.8.8:R")

    //command-framework
    implementation("com.github.SaiintBrisson.command-framework:shared:1.2.0")
    implementation("com.github.SaiintBrisson.command-framework:bukkit:1.2.0")
    //luckperms
    compileOnly("net.luckperms:api:5.3")
    //inventory-framework
    implementation("com.github.DevNatan:inventory-framework:v2.0.3")

    //nlogin
    compileOnly("com.nickuc.login:nlogin-api:10.0")

    //lombok
    compileOnly ("org.projectlombok:lombok:1.18.20")
    annotationProcessor ("org.projectlombok:lombok:1.18.20")

    //apis
    implementation (fileTree("libs"))

}

tasks {
    java {
        targetCompatibility = JavaVersion.VERSION_1_8
        sourceCompatibility = JavaVersion.VERSION_1_8
    }
    compileJava { options.encoding = "UTF-8"}

    java {
        shadowJar { archiveFileName.set("lobby-1.0-SNAPSHOT.jar") }
    }
}

