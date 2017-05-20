FROM java:8-alpine
MAINTAINER Your Name <you@example.com>

ADD target/uberjar/clicker.jar /clicker/app.jar

EXPOSE 3000

CMD ["java", "-jar", "/clicker/app.jar"]
