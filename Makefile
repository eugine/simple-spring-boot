dev:
	docker-compose up

dev-down:
	docker-compose down

run:
	./gradlew --no-daemon bootRun --args='--spring.profiles.active=local'

