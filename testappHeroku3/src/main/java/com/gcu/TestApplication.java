package com.gcu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.gcu.LoggerComponent.ConsoleLoggerInterceptor;
import com.gcu.LoggerComponent.LoggerInterceptor;

@ComponentScan({ "com.gcu" })
@SpringBootApplication
public class TestApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
		
	}

	@Bean
    public LoggerInterceptor loggerInterceptor() {
        return new ConsoleLoggerInterceptor();
    }
	
}
