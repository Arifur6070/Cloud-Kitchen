package com.cloud.kitchen;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;

import io.jsonwebtoken.io.IOException;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;


@SpringBootApplication(exclude = {SecurityAutoConfiguration.class, UserDetailsServiceAutoConfiguration.class})
@OpenAPIDefinition(
    info = @Info(
        title = "Cloud Kitchen API",
        version = "v1",
        description = "Kitchen At your doorstep",
        contact = @Contact(
            name = "Md Arifur Rahman",
            email = "md-arifur.rahman@stud.uni-bamberg.de",
            url = "https://www.linkedin.com/in/arifur-rahman-41a211169/"
        ),
        license = @License(
            name = "Apache 2.0",
            url = "http://www.apache.org/licenses/LICENSE-2.0"
        )
    ),
    servers = {
        @Server(url = "http://localhost:8080", description = "Local server"),
        @Server(url = "http://api.example.com", description = "Production server")
    }
)
public class CloudKitchenApplication {

	public static void main(String[] args) {

		// Dotenv.configure().load();
		try {
			loadEnvVariables();
		} catch (java.io.IOException e) {
			
			e.printStackTrace();
		}
		SpringApplication.run(CloudKitchenApplication.class, args);
	}


	private static void loadEnvVariables() throws FileNotFoundException, java.io.IOException {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(".env"));
            for (String key : properties.stringPropertyNames()) {
                System.setProperty(key, properties.getProperty(key));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
