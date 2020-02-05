import org.jetbrains.kotlin.gradle.tasks.KotlinCompile


plugins{
	id("org.springframework.boot")  version "2.2.4.RELEASE"
	id("io.spring.dependency-management") version "1.0.9.RELEASE"
	kotlin("jvm") version "1.3.61"
	kotlin("plugin.spring") version "1.3.61"
	kotlin("plugin.jpa") version "1.3.61"
	kotlin("plugin.allopen") version "1.3.61"

}

group = "com.test"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

val developmentOnly by configurations.creating
configurations {
	runtimeClasspath {
		extendsFrom(developmentOnly)
	}
}

repositories {
	mavenCentral()
	jcenter()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-batch")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("org.springframework.boot:spring-boot-starter-jdbc")
	implementation("org.postgresql:postgresql")
// Lightmin dependencies
	implementation("org.tuxdevelop:spring-batch-lightmin-bom:2.1.0")
	implementation("org.tuxdevelop:spring-batch-lightmin-server-standalone:2.1.0")
	implementation("org.tuxdevelop:spring-batch-lightmin-client-classic:2.1.0")
	implementation("org.tuxdevelop:spring-batch-lightmin-repository-jdbc:2.1.0")

//	implementation("org.springframework.boot:spring-boot-starter")
//	implementation("org.springframework.boot:spring-boot-starter-mustache")
//	implementation("org.springframework.batch:spring-batch-integration:4.2.0.RELEASE")
//	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
//	implementation("org.jetbrains.kotlin:kotlin-reflect")
//	implementation("org.springframework.batch:spring-batch-core")

	developmentOnly("org.springframework.boot:spring-boot-devtools")
//	runtimeOnly("com.h2database:h2")
	runtimeOnly("org.springframework.boot:spring-boot-devtools")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.springframework.batch:spring-batch-test")
	testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")

}



tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "1.8"
	}
}

allOpen {
	annotation("javax.persistence.Entity")
	annotation("javax.persistence.Embeddable")
	annotation("javax.persistence.MappedSuperclass")
}