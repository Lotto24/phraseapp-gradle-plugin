# PhraseApp Gradle Plugin
# author: Mike Winkelmann <mike.winkelmann@esailors.de>

.PHONY: clean test build install publish

GRADLE = ./gradlew

clean:
	${GRADLE} clean

test:
	${GRADLE} test

build: clean test
	${GRADLE} build

install: clean build
	${GRADLE} install

publish: clean build
	${GRADLE} publishPlugins
