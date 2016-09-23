package pl.kata.bowlingGameSpring;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class InitializeContext {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(GameConfig.class);
		Object gameService = context.getBean("gameService");
		System.out.println(gameService);
	}
}
