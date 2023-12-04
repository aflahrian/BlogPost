package com.example.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;


@SpringBootApplication
public class BlogApplication {

	public static void main(String[] args) {
//		SpringApplication.run(BlogApplication.class, args);
		
		 SpringApplication app = new SpringApplication(BlogApplication.class);
		    app.addListeners(new ApplicationListener<ApplicationReadyEvent>() {
		        @Override
		        public void onApplicationEvent(ApplicationReadyEvent event) {
		        }
		    });
			app.run(args);
	}

}
