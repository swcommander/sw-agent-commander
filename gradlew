#!/bin/bash
DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
export JAVA_HOME=$(/usr/libexec/java_home 2>/dev/null || echo /usr/lib/jvm/java-17-openjdk-amd64)
$DIR/gradle/bin/gradle "$@"
