package jvreis.webscrapingf1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Webscrapingf1Application {

	public static void main(String[] args) {
		//SpringApplication.run(Webscrapingf1Application.class, args);
		new ScrapingConfiguration();
	}

}
