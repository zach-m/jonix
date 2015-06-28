#!/bin/sh

# mvn versions:set -DnewVersion=3.1-SNAPSHOT
mvn clean install
mvn javadoc:javadoc

cd gh-pages
rm -rf $(ls -1)
cp -r ../target/site/apidocs/* .
