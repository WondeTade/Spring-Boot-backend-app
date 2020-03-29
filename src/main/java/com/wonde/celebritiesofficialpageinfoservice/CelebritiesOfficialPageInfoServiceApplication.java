package com.wonde.celebritiesofficialpageinfoservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.wonde.celebritiesofficialpageinfoservice.repository"})
public class CelebritiesOfficialPageInfoServiceApplication {

//	@Bean
//	public RestTemplate getRestTemplate() {
//		return new RestTemplate();
//	}


	public static void main(String[] args) {
		SpringApplication.run(CelebritiesOfficialPageInfoServiceApplication.class, args);
	}


}
