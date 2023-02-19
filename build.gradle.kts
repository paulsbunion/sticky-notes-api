plugins {
	java
	id("org.springframework.boot") version "3.0.2"
	id("io.spring.dependency-management") version "1.1.0"
}

group = "com.defrain"
version = "0.0.1-SNAPSHOT"
//java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	
	// auto update on change
	implementation("org.springframework.boot:spring-boot-devtools")
	
	runtimeOnly("com.h2database:h2")
	//implementation("org.postgresql:postgresql:42.3.1")
	
	// add jackson localDateTime converter object mapping
	// https://mvnrepository.com/artifact/com.fasterxml.jackson.datatype/jackson-datatype-jsr310
	implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.14.2")
	
	
}

tasks.withType<Test> {
	useJUnitPlatform()
}
