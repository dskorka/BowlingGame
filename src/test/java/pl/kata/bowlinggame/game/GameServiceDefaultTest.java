package pl.kata.bowlinggame.game;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = GameServiceDefaultTest.GameConf.class)
public class GameServiceDefaultTest {
	
	@Autowired
	GameServiceDefault gameService;
	
	@Test
	public void shoudl_build_frame(){
		Game game = new Game(1);
		for (int i = 0; i < 2; i++) {
			game.roll(1);
			game.roll(2);
			game.roll(3);
			game.roll(4);
			game.roll(5);
			game.roll(6);
			game.roll(7);
			game.roll(8);
			game.roll(9);
			game.roll(9);
		}
		
		String[] list = {"1/2", "3/4", "5/6", "7/8", "9/9","1/2", "3/4", "5/6", "7/8", "9/9/0"};
		Assert.assertArrayEquals(list, gameService.prepareFramesWithScores(game.getRolls()));
	}
	
	@Configuration
	@ComponentScan(basePackages={"pl.kata.bowlinggame.game"})
	static class GameConf {

	}
}
