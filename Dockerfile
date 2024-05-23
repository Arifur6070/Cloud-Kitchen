#OpenJDK version to run as the base image
FROM tomcat:10.1.24-jre17-temurin
LABEL "Project"="Cloud Kitchen Backend"
LABEL "Author"="Md Arifur rahman"

RUN rm -rf /usr/local/tomcat/webapps/*
COPY target/0.1.1-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/ROOT.war

EXPOSE 8080
CMD ["catalina.sh", "run"]
WORKDIR /usr/local/tomcat/

