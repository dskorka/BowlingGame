package pl.kata.bowlinggame.conf;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages={"pl.kata.bowlinggame.conf"})
public class InitializeContext {

	public static void main(String[] args) {

		try (ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(InitializeContext.class)) {
			Object gameService = context.getBean(GameService.class);
			System.out.println(gameService);
		}
	}
}
