package org.yyama.master.mainte;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

//@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@SpringBootApplication
@ServletComponentScan
public class MasterMainteApplication {

	public static void main(String[] args) {
		SpringApplication.run(MasterMainteApplication.class, args);
	}
}
