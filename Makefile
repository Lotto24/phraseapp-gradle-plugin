# PhraseApp Gradle Plugin
# author: Mike Winkelmann <mike.winkelmann@esailors.de>

.PHONY: clean build install publish

clean:
	./gradlew clean

build: clean
	./gradlew build

install: clean build
	./gradlew install

publish: clean build
	./gradlew publishPlugins
