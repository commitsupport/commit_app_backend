package com.commit.connections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ConnectionsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConnectionsApplication.class, args);
	}

}
