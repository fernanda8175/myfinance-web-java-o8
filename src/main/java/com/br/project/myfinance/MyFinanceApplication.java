package com.br.project.myfinance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.br.project.myfinance.model.domain")
public class MyFinanceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyFinanceApplication.class, args);
	}

}
