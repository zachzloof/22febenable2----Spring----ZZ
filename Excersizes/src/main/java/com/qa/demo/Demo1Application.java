package com.qa.demo;

import java.time.LocalTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
@SpringBootApplication
public class Demo1Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Demo1Application.class, args);
//		AppConfig AC = new AppConfig();
//		AC.currentTime();
		Object byName = context.getBean("currentTime");
	    LocalTime byType = context.getBean(LocalTime.class);
	    String byBoth = context.getBean("currentTime", String.class);
		Object byName2 = context.getBean("farewell");
		Object byName3 = context.getBean("greeting");
		System.out.println(byName);
	    System.out.println(byType);
	    System.out.println(byBoth);
	    System.out.println(byName2);
	    System.out.println(byName3);

	}

}
