package com.grabbag;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({ "com.grabbag" })
@SpringBootApplication
public class MediaGrabBagApplication {

	public static void main(String[] args) {
		SpringApplication.run(MediaGrabBagApplication.class, args);
	}

}
