# PMS

Prisoner Management System is a Java Web Application made to manage Prisoners and their assets.

#Requirements:

Java 11
Developer account - register at https://developer.blackboard.com
Test instance

#Setting Up Your Development Environment

Tomcat: This code was developed and tested against Tomcat 9.
Java 11: This code was developed and tested against openjdk11.0.2.
Gradle: Relies on Gradle 5.6.2.

#To Use

Start tomcat - tomcat/bin/startup.sh
Replace place holders with your developer credentials and System URL, as described in the "Configuring the Script" section below
Build project - ./gradlew build
Deploy war file - cp build/libs/bbdn-rest-demo-java.war tomcat/webapps
Access index in browser - http://localhost:8080/
