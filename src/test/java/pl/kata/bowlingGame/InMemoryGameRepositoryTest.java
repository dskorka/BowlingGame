package pl.kata.bowlingGame;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import pl.kata.bowlingGame.Game;
import pl.kata.bowlingGame.repository.GameRepository;
import pl.kata.bowlingGame.repository.InMemoryGameRepository;


public class InMemoryGameRepositoryTest {
	
	GameRepository gameRepository;
	
	@Before
	public void setUp(){
		gameRepository = new InMemoryGameRepository();
	}
	
	@Test
	public void should_save_and_load_game(){
		// given
		Game testGame = new Game(1);
		for(int i=0; i<20;i++){
			testGame.roll(1);
		}
		// when
		gameRepository.save(testGame);
		Game gameOfRepo = gameRepository.load(testGame.getId());
		// then
		int score = gameOfRepo.score();
		Assert.assertEquals(20, score);
	}
	
	@Test
	public void should_have_the_same_id(){
		// given
		Game testGame = new Game(1);
		for(int i=0; i<20;i++){
			testGame.roll(1);
		}
		// when
		gameRepository.save(testGame);
		Game gameOfRepo = gameRepository.load(testGame.getId());
		// then
		Assert.assertEquals(testGame.getId(), gameOfRepo.getId());
	}
	
	@Test
	public void should_update_game(){ 
		//given
		Game testGame = new Game(1);
		for(int i=0; i<10;i++){
			testGame.roll(1);
		}
		gameRepository.save(testGame);
		
		for(int i=0; i<10;i++){
			testGame.roll(1);
		}
		gameRepository.save(testGame);
		// when
		Game gameOfRepo = gameRepository.load(testGame.getId());
		// then
		Assert.assertEquals(20, gameOfRepo.score());
	}
}

