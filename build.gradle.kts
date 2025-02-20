plugins {
	war
	id("org.springframework.boot") version "3.4.2"
	id("io.spring.dependency-management") version "1.1.7"
}

group = "com.wolfired"
version = "0.0.1"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(23)
	}
}

repositories {
    maven { setUrl("https://maven.aliyun.com/repository/public/") }
    maven { setUrl("https://maven.aliyun.com/repository/central/") }
    maven { setUrl("https://maven.aliyun.com/repository/gradle-plugin/") }
    maven { setUrl("https://maven.aliyun.com/repository/apache-snapshots/") }
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	runtimeOnly("org.mariadb.jdbc:mariadb-java-client")
	providedRuntime("org.springframework.boot:spring-boot-starter-tomcat")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
