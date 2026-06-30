#!/bin/bash
exec java --enable-native-access=ALL-UNNAMED -jar "$(dirname "$0")/target/demo-0.0.1-SNAPSHOT.jar" "$@"
