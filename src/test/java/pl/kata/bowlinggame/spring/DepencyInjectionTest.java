package pl.kata.bowlinggame.spring;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.kata.bowlinggame.conf.GameRepositoryImpl;
import pl.kata.bowlinggame.conf.GameService;
import pl.kata.bowlinggame.game.Game;
import pl.kata.bowlinggame.repository.GameRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DepencyInjectionTest.Config.class)
public class DepencyInjectionTest {

	@Autowired
	GameService gameService;
		
	@Test
	public void should_init_game_service_bean(){
		Assert.assertNotNull(gameService);
	}
	
	@Configuration
	static class Config{

		@Bean
		public GameRepository gameRepository(){
			return new GameRepositoryImpl() {
				
				@Override
				public void save(Game game) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public Game load(int idGame) {
					// TODO Auto-generated method stub
					return null;
				}
			};
		}
				
		@Bean
		GameService gameService(GameRepositoryImpl gameRepository){
			return new GameService(gameRepository);
		}
	}
}