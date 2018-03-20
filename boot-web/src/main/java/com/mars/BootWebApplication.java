package com.mars;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
//@MapperScan("com.mars.dao")
@EnableCaching
@EnableTransactionManagement
@EnableScheduling
public class BootWebApplication {


	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(BootWebApplication.class, args);
	}
}
