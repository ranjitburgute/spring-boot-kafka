#!/bin/sh

echo "Building weather application..."
./gradlew build

echo "Running testcases for weather application..."
./gradlew test

echo "Creating docker image for weather application..."
docker build -t rburgute/weather-app:1.0 .

echo "Running application in docker-compose..."
docker-compose up -d