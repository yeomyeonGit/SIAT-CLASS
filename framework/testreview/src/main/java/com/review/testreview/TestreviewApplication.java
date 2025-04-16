package com.review.testreview;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

// 서버 연동
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class TestreviewApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestreviewApplication.class, args);
	}

}
