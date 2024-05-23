# Use OpenJDK version to run as the base image
FROM tomcat:10.1.24-jre17
LABEL "Project"="Cloud Kitchen Backend"
LABEL "Author"="Md Arifur rahman"

# Setting up the directory
WORKDIR /usr/local/tomcat/

#Installing netcat for necesary work in entrypoint script
RUN apt-get update && apt-get install -y netcat && rm -rf /var/lib/apt/lists/*

# Removing default webapps root
RUN rm -rf /usr/local/tomcat/webapps/*

# Coping my WAR file
COPY target/0.1.1-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/ROOT.war

#Copying my entrypoint script
COPY entrypoint.sh /usr/local/tomcat/entrypoint.sh


# Making my script executable
RUN chmod +x /usr/local/tomcat/entrypoint.sh



EXPOSE 8080

# Seting up the entrypoint
ENTRYPOINT ["sh","/usr/local/tomcat/entrypoint.sh"]
