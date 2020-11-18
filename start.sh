#!/usr/bin/env bash
app="idata-app"
docker build --build-arg JAR_FILE="build/libs/*.jar" -t ${app} .
docker run -d -p 56565:8080 ${app}