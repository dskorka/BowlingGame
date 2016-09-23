package pl.kata.bowlingGame;

import java.io.File;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import pl.kata.bowlingGame.Game;
import pl.kata.bowlingGame.repository.FileGameRepository;


public class FileGameRepositoryTest {
	
	FileGameRepository fileGameRepo;
	final File filePathToTheGams = new File("D:\\projects\\BowlingGame\\src\\main\\resources\\gameScore.txt");
	
	@Before
	public void setUp(){
		fileGameRepo = new FileGameRepository(filePathToTheGams);
	}
	
	@Test
	public void should_save_and_load_game_of_file(){
		// given
		Game testGame = new Game(2);
		for(int i=0; i<20;i++){
			testGame.roll(1);
		}
		// when
		fileGameRepo.save(testGame);
		Game gameOfRepo = fileGameRepo.load(testGame.getId());
		// then
		int score = gameOfRepo.score();
		Assert.assertEquals(20, score);
	}
	
	@Test
	public void should_save_and_load_game_with_large_id_of_file(){
		// given
		Game testGame = new Game(111123);
		for(int i=0; i<20;i++){
			testGame.roll(1);
		}
		// when
		fileGameRepo.save(testGame);
		Game gameOfRepo = fileGameRepo.load(testGame.getId());
		// then
		int score = gameOfRepo.score();
		Assert.assertEquals(20, score);
	}
	
	
	@Test
	public void should_have_the_same_id_after_save(){
		// given
		Game testGame = new Game(1);
		for(int i=0; i<20;i++){
			testGame.roll(1);
		}
		// when
		fileGameRepo.save(testGame);
		Game gameOfRepo = fileGameRepo.load(testGame.getId());
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
		fileGameRepo.save(testGame);
		
		for(int i=0; i<10;i++){
			testGame.roll(1);
		}
		fileGameRepo.save(testGame);
		// when
		Game gameOfRepo = fileGameRepo.load(testGame.getId());
		// then
		Assert.assertEquals(30, gameOfRepo.score());
	}
}
