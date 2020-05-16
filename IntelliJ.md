# IntelliJ Setup Guide

#### Open Project

- Make sure to have `JDK >= 9` and `Maven >= 3.3.9`
- Import Project: `${JONIX_HOME}/pom.xml`

#### Use Jonix Java Code Style

    File > Settings.. > Editor > Code Style > Java > Scheme: Project > (Gear) Import Scheme > IntelliJ IDEA code style XML > 
        ${JONIX_HOME}/jonix-codestyle-intellij.xml > OK > Check "Current scheme" > OK

#### Use Jonix Checkstyle Rules

Install [CheckStyle-IDEA Plugin](https://plugins.jetbrains.com/plugin/1065-checkstyle-idea/)

    File > Settings.. > Checkstyle > Checkstyle version: 8.30

    File > Settings.. > Checkstyle > (+) Configuration File > 
        Description           : jonix-checkstyle
        local Checkstyle file : ${JONIX_HOME}/checkstyle.xml
        Store relative        : yes
