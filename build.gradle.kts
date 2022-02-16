plugins {
    kotlin("jvm") version "1.4.10"
    maven
    signing
    `maven-publish`
}

group = "ru.chermenin"
version = "0.2.2"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("com.github.ua-parser:uap-java:1.5.2")

    // Test dependencies
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit")
    testImplementation("org.hamcrest:hamcrest:2.2")
}

tasks {
    val sourcesJar by creating(Jar::class) {
        archiveClassifier.set("sources")
        from(sourceSets.main.get().allSource)
    }

    val javadocJar by creating(Jar::class) {
        dependsOn.add(javadoc)
        archiveClassifier.set("javadoc")
        from(javadoc)
    }

    artifacts {
        archives(sourcesJar)
        archives(javadocJar)
        archives(jar)
    }
}

val nexusUsername: String? by project
val nexusPassword: String? by project

tasks.named<Upload>("uploadArchives") {
    repositories {
        withConvention(MavenRepositoryHandlerConvention::class) {
            mavenDeployer {
                beforeDeployment { signing.signPom(this) }
            }
        }
        withGroovyBuilder {
            "mavenDeployer" {
                "repository"("url" to "https://oss.sonatype.org/service/local/staging/deploy/maven2/") {
                    "authentication"("userName" to nexusUsername, "password" to nexusPassword)
                }
                "snapshotRepository"("url" to "https://oss.sonatype.org/content/repositories/snapshots/") {
                    "authentication"("userName" to nexusUsername, "password" to nexusPassword)
                }
                "pom" {
                    "project" {
                        setProperty("name", "Kotlin User Agents")
                        setProperty("packaging", "jar")
                        setProperty(
                            "description",
                            "A library to identify device, browser and some additional information from user agent strings."
                        )
                        setProperty("url", "https://code.chermenin.ru/kotlin-user-agents/")
                        "scm" {
                            setProperty("connection", "scm:")
                            setProperty("developerConnection", "scm:")
                            setProperty("url", "")
                        }
                        "developers" {
                            "developer" {
                                setProperty("id", "chermenin")
                                setProperty("name", "Alex Chermenin")
                                setProperty("email", "alex@chermenin.ru")
                            }
                        }
                        "licenses" {
                            "license" {
                                setProperty("name", "MIT")
                                setProperty("url", "https://github.com/chermenin/kotlin-user-agents/blob/master/LICENSE")
                                setProperty("distribution", "repo")
                            }
                        }
                    }
                }
            }
        }
    }
}

signing {
    sign(configurations.archives.get())
}

publishing {
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/chermenin/kotlin-user-agents")
            credentials {
                username = project.findProperty("gpr.user") as String? ?: System.getenv("USERNAME")
                password = project.findProperty("gpr.key") as String? ?: System.getenv("TOKEN")
            }
        }
    }
    publications {
        register<MavenPublication>("gpr") {
            from(components["java"])
        }
    }
}
