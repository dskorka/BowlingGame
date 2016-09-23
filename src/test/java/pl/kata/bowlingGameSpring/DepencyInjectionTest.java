package pl.kata.bowlingGameSpring;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.kata.bowlingGame.Game;
import pl.kata.bowlingGame.repository.GameRepository;
import pl.kata.bowlingGameSpring.GameService;

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
			return new GameRepository() {
				
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
		GameService gameService(GameRepository gameRepository){
			return new GameService(gameRepository);
		}
	}
}
