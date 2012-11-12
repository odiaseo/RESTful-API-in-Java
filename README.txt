System Requirements:
====================
- Maven 2.0.9 or higher

Building the project:
====================
mvn clean install

This will build a WAR in /target/bbc-1.0.war, run it with tomcat6

Assumptions
===============
1. Adequate security measures are in place
2. Rest API would be consumed specifying the appropriate HTTP Method (POST, DELETE, PUT and GET)
