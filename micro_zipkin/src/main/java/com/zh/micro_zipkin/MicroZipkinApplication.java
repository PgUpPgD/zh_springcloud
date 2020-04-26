package com.zh.micro_zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin2.server.internal.EnableZipkinServer;

@SpringBootApplication
@EnableZipkinServer
public class MicroZipkinApplication {

	public static void main(String[] args) {
//		new SpringApplicationBuilder(MicroZipkinApplication .class)
//				.web(WebApplicationType.NONE)
//				.run(args);
		SpringApplication.run(MicroZipkinApplication.class, args);
	}

}

