package com.example.assignment3;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}


	public void addCorsMappings(CorsRegistry registry) {
	registry.addMapping("/**")
			.allowedMethods("GET", "POST", "PUT", "DELETE")	//postman
			.allowedHeaders("Content-Type", "Authorization");
			// .allowedOrigins("http://localhost:4200")
}

}


