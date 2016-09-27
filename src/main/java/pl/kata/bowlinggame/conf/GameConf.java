package pl.kata.bowlinggame.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GameConf {
	
	GameRepositoryImpl gameRepository;
	
	@Bean
	GameService gameService(){
		return new GameService(gameRepository);
	}
}
