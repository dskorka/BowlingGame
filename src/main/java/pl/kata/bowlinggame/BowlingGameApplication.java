package pl.kata.bowlinggame;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
@ComponentScan("pl.kata.bowlinggame")
public class BowlingGameApplication {
	public static void main(String[] args){
		SpringApplication.run(BowlingGameApplication.class, args);
	}
}
