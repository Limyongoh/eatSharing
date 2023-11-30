package com.project.eatSharing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing //JpaAuditing 기능을 사용하기 위해 추가 - @createDate, @modifyDate.....
@SpringBootApplication
public class EatSharingApplication {

	public static void main(String[] args) {
		SpringApplication.run(EatSharingApplication.class, args);
	}

}
