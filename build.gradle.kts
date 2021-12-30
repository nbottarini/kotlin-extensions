import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.6.10"
    id("maven-publish")
    id("signing")
    id("io.github.gradle-nexus.publish-plugin") version "1.1.0"
}

val nexusUsername: String? by project
val nexusPassword: String? by project

group = "com.nbottarini"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.2")
    testImplementation("org.assertj:assertj-core:3.21.0")
}

tasks.withType<KotlinCompile> { kotlinOptions.jvmTarget = "1.8" }

kotlin {
    sourceSets["main"].apply {
        kotlin.srcDirs("src")
        resources.srcDirs("resources")
    }
    sourceSets["test"].apply {
        kotlin.srcDir("test")
        resources.srcDir("test_resources")
    }
}

java {
    withJavadocJar()
    withSourcesJar()

    sourceSets["main"].apply {
        java.srcDirs("src")
        resources.srcDirs("resources")
    }
    sourceSets["test"].apply {
        java.srcDir("test")
        resources.srcDir("test_resources")
    }
}

tasks.withType<Test> { useJUnitPlatform() }

tasks.withType<Test>().configureEach {
    reports.html.required.set(false)
    reports.junitXml.required.set(false)
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            artifactId = "asimov-kotlin-extensions"
            from(components["java"])

            pom {
                name.set("Kotlin Extensions")
                description.set("Useful Kotlin extensions. Part of Asimov collection of libraries.")
                url.set("https://github.com/nbottarini/asimov-kotlin-extensions")

                licenses {
                    license {
                        name.set("MIT License")
                        url.set("http://www.opensource.org/licenses/mit-license.php")
                    }
                }

                developers {
                    developer {
                        id.set("nbottarini")
                        name.set("Nicolas Bottarini")
                        email.set("nicolasbottarini@gmail.com")
                    }
                }

                scm {
                    connection.set("scm:git:git://github.com/asimov-kotlin-extensions.git")
                    developerConnection.set("scm:git:ssh://github.com/asimov-kotlin-extensions.git")
                    url.set("https://github.com/nbottarini/asimov-kotlin-extensions")
                }

//                repositories {
//                    maven {
//                        credentials {
//                            username = nexusUsername
//                            password = nexusPassword
//                            name = "Sonatype"
//                            url = uri("https://s01.oss.sonatype.org/service/local/staging/deploy/maven2")
//                        }
//                    }
//                }
            }
        }
    }
}

nexusPublishing {
    repositories {
        sonatype {
            nexusUrl.set(uri("https://s01.oss.sonatype.org/service/local/"))
            snapshotRepositoryUrl.set(uri("https://s01.oss.sonatype.org/content/repositories/snapshots/"))
            username.set(nexusUsername)
            password.set(nexusPassword)
        }
    }
}

signing {
    sign(publishing.publications["maven"])
}
