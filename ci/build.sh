#!/bin/bash
# The purpose of this script is to verify the builds for each of maven and gradle
#

export TERM=${TERM:-dumb}

SCRIPT="$0"

# SCRIPT may be an arbitrarily deep series of symlinks. Loop until we have the concrete path.
while [ -h "$SCRIPT" ] ; do
  ls=`ls -ld "$SCRIPT"`
  # Drop everything prior to ->
  link=`expr "$ls" : '.*-> \(.*\)$'`
  if expr "$link" : '/.*' > /dev/null; then
    SCRIPT="$link"
  else
    SCRIPT=`dirname "$SCRIPT"`/"$link"
  fi  
done

# Change into our working directory
cd `dirname ${SCRIPT}`/..

echo "Building with gradle"

./gradlew --no-daemon --info build

