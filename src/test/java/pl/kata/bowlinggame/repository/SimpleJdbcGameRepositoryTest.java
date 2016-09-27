package pl.kata.bowlinggame.repository;

import javax.sql.DataSource;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import pl.kata.bowlinggame.game.Game;
import pl.kata.bowlinggame.repository.SimpleJdbcGameRepository;

public class SimpleJdbcGameRepositoryTest {
	
	SimpleJdbcGameRepository dataBaseGameRepository;
	
	@Before
	public void setUp(){
		DataSource ds = H2DataSourceCreator.create();
		dataBaseGameRepository = new SimpleJdbcGameRepository(ds);
	}
	
	@Test
	public void should_save_and_load_game_of_file(){
		// given
		Game testGame = new Game(1);
		for(int i=0; i<20;i++){
			testGame.roll(2);
		}
		
		// when
		dataBaseGameRepository.save(testGame);
		Game gameOfRepository = dataBaseGameRepository.load(testGame.getId());
		
		// then
		int score = gameOfRepository.score();
		Assert.assertEquals(40, score);
	}
	
	@Test
	public void should_have_the_same_id_after_save(){
		// given
		Game testGame = new Game(1);
		for(int i=0; i<20;i++){
			testGame.roll(1);
		}
		
		// when
		dataBaseGameRepository.save(testGame);
		Game gameOfRepo = dataBaseGameRepository.load(testGame.getId());
		
		// then
		Assert.assertEquals(testGame.getId(), gameOfRepo.getId());
	}
	
	@Test
	public void should_save_part_game_to_file(){
		//given
		Game testGame = new Game(6);
		for(int i=0; i<10;i++){
			testGame.roll(2);
		}
		dataBaseGameRepository.save(testGame);
		
		for(int i=0; i<10;i++){
			testGame.roll(1);
		}
		dataBaseGameRepository.save(testGame);
		// when
		
		Game gameOfRepo = dataBaseGameRepository.load(testGame.getId());
		
		// then
		Assert.assertEquals(30, gameOfRepo.score());
	}
}
