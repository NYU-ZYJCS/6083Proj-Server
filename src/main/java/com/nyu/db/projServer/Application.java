package com.nyu.db.projServer;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.nyu.db.projServer.mapper")
public class Application {


	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}




}
