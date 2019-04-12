#!/bin/bash

export TERM=${TERM:-dumb}
cd tcs-embed-example

./gradlew --no-daemon build
