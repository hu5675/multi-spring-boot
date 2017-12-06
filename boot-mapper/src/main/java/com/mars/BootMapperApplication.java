package com.mars;

import javafx.application.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

//@SpringBootApplication
public class BootMapperApplication {

	public static void main(String[] args) throws IOException {
		Properties properties = new Properties();
		InputStream inputStream =  BootMapperApplication.class.getClassLoader().getResourceAsStream("application-mapper.yml");
		properties.load(inputStream);

		SpringApplication app = new SpringApplication(BootMapperApplication.class);
		app.setDefaultProperties(properties);
		app.run(args);
//		SpringApplication.run(BootMapperStartApplication.class, args);
	}
}
