import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.7.1"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"

	val kotlinVersion = "1.6.21"
	kotlin("jvm") version kotlinVersion
	kotlin("plugin.spring") version kotlinVersion
	kotlin("plugin.jpa") version kotlinVersion
	kotlin("kapt") version kotlinVersion
	kotlin("plugin.allopen") version kotlinVersion
	kotlin("plugin.noarg") version kotlinVersion
}

allOpen {
	annotation("javax.persistence.Entity")
	annotation("javax.persistence.MappedSuperClass")
	annotation("javax.persistence.Embeddable")
}
noArg {
	annotation("javax.persistence.Entity")
	annotation("javax.persistence.MappedSuperClass")
	annotation("javax.persistence.Embeddable")
}

group = "com.cherry"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11
val querydslVersion = "5.0.0"

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

	// MySql
	implementation("mysql:mysql-connector-java")
	implementation("org.springframework.boot:spring-boot-starter-jdbc")

	// QueryDSL
	implementation("com.querydsl:querydsl-jpa:$querydslVersion")
	kapt("com.querydsl:querydsl-apt:$querydslVersion:jpa")
	kapt("org.springframework.boot:spring-boot-configuration-processor")

	// BCrypt
	implementation("org.springframework.boot:spring-boot-starter-security")

	testImplementation(kotlin("test"))
	testImplementation("com.h2database:h2:1.4.199")
	runtimeOnly("org.springframework.boot:spring-boot-devtools")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "11"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
