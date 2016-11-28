# PhraseApp Gradle Plugin
# author: Mike Winkelmann <mike.winkelmann@esailors.de>

.PHONY: clean test build install publish

clean:
	./gradlew clean

test:
	./gradlew test

build: clean test
	./gradlew build

install: clean build
	./gradlew install

publish: clean build
	./gradlew publishPlugins
