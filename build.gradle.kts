

/*
 * This file was generated by the Gradle 'init' task.
 *
 * This generated file contains a sample Java Library project to get you started.
 * For more details take a look at the Java Libraries chapter in the Gradle
 * user guide available at https://docs.gradle.org/5.2.1/userguide/java_library_plugin.html
 */

plugins {
    // Apply the java-library plugin to add support for Java Library & others
    val plugins = listOf(
		"java-library",
		"eclipse",
		"jacoco"
    	)
    plugins.forEach {
        id(it)
    }
        id("org.sonarqube") version "2.7"
        id("org.springframework.boot") version "2.1.3.RELEASE"
}

dependencies {
    // This dependency is exported to consumers, that is to say found on their compile classpath.
    api("org.apache.commons:commons-math3:3.6.1")

    // This dependency is used internally, and not exposed to consumers on their own compile classpath.
    implementation("com.google.guava:guava:23.0")

    // Use JUnit test framework
    val testdeps = listOf(
	"org.springframework.boot:spring-boot-starter-test:2.1.3.RELEASE"
	)
	testdeps.forEach {
	testImplementation(it)
	}

    // This dependency is requited to use HTML5 parser & etc.


	val deps = listOf(
		"org.springframework.boot:spring-boot-starter-web:2.1.3.RELEASE",
		"org.springframework.boot:spring-boot-starter-security:2.1.3.RELEASE",
		"org.springframework.boot:spring-boot-starter-thymeleaf:2.1.3.RELEASE",
		"org.springframework.security.oauth.boot:spring-security-oauth2-autoconfigure:2.1.3.RELEASE",
		"org.thymeleaf.extras:thymeleaf-extras-springsecurity5:3.0.4.RELEASE",
		"com.pi4j:pi4j-core:1.2"
	)
	deps.forEach {
		implementation(it)
	}

}
// In this section you declare where to find the dependencies of your project

repositories {
    // Use jcenter for resolving your dependencies.
    // You can declare any Maven/Ivy/file repository here.
    mavenCentral()
    val mvnrepo = listOf(
			"https://repo1.maven.org/maven2",
			"https://plugins.gradle.org/m2/"
			)
	mvnrepo.forEach {
		maven(url = StringBuffer(it))
	}
}

eclipse {
	classpath {
		containers("org.springsource.ide.eclipse.gradle.classpathcontainer")
	}
}
tasks {
	jar {
		baseName = "spring-boot-hello-world"
		version =  "0.0.1-SNAPSHOT"
	}
}
// SonarQube Code Scanning 'sonarqube' section.
sonarqube {
	properties {
		property("sonar.host.url","https://sonarcloud.io")
		property("sonar.sources","src/main/java")
		property("sonar.language","java")
	}
}