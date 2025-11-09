package com.assignment.dropbox;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DropboxIntegrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(DropboxIntegrationApplication.class, args);
	}

}
