package org.yyama.master.mainte;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@SpringBootApplication
public class MasterMainteApplication {

	public static void main(String[] args) {
		SpringApplication.run(MasterMainteApplication.class, args);
	}
}
