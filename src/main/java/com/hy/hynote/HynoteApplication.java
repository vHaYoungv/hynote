package com.hy.hynote;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class HynoteApplication {

	public static void main(String[] args) {
		SpringApplication.run(HynoteApplication.class, args);
	}

}
