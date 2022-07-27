clean:
	./mvnw clean install

install:
	./mvnw install

start:
	./mvnw spring-boot:run

build:
	java -jar target/udemy-spring-framework-0.0.1-SNAPSHOT.jar

run:
	./mvnw package && java -jar target/udemy-spring-framework-0.0.1-SNAPSHOT.jar

docker-build:
	docker build -t test-spring/udemy-spring-docker .