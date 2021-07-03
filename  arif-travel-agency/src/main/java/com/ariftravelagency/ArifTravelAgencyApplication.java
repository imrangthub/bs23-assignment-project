package com.ariftravelagency;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class ArifTravelAgencyApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ArifTravelAgencyApplication.class, args);
		System.out.println("Arif Travel Agency MVC Application Run Successfully Done !");
	}

}