package pl.kata.bowlingGame;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import pl.kata.bowlingGame.Game;


public class BowlingGameTest {
	
	Game game;
	
	@Before
	public void setUp(){
		game = new Game(1);
	}
	
	@Test
	public void should_sum_score_when_player_hit_all_number(){
	// given
	for(int i=0; i<20;i++){
		game.roll(1);
	}
	// when
	int score = game.score();
	// then
	Assert.assertEquals(20, score);
	}
	
	@Test
	public void should_sum_score_when_player_hit_nine_and_miss(){
	// given
		for(int i=0; i<10;i++){
			game.roll(9);
			game.roll(0);
		}
	// when
		int score = game.score();
	// then	
		Assert.assertEquals(90, score);
	}
	
	@Test
	public void should_sum_score_when_player_hit_number_and_spare(){
	// given
		for(int i=0; i<10;i++){
			game.roll(5);
			game.roll(5);
		}
	// when
		int score = game.score();
	// then
		Assert.assertEquals(150, score);
	}
	
	/*@Test
	public void should_show_three_previous_score(){
		for(int i=0; i<10;i++){
			game.roll(5);
			game.roll(5);
		}
		ScoreBoardSnapshot scoreBoardSnapshot = game.getSnapshot();
		
		//List<RegularBoardFrame> regularBoardFrame = scoreBoardSnapshot.getRegularFrame();
		
		/*for(RegularBoardFrame regularBoardFrameLoop: regularBoardFrame){
			regularBoardFrameLoop.getFirstFrame();
			regularBoardFrameLoop.getSecondFrame();
		}
		
		int value = scoreBoardSnapshot.frame.get(3).getIncrement();
		System.out.println(value);
	}*/
	
	
	
	/*
	
	@Test
	public void should_sum_score_when_player_miss() {
		// given
		for(int i=0; i<11;i++){
			game.roll(10);
		}
		// when
		int score = game.score();
		// then
		Assert.assertEquals(300, score);
	}
	
	
	
	
	
	
	@Test
	public void should_sum_score_when_player_hit_strike_and_one_miss_and_one(){
	// given
		String resultBolwingGame = "XXXXXXXXX-1";
	// when
		int score = scoreCalculator.sumScore(resultBolwingGame);
	// then
		Assert.assertEquals(243, score);
	}
	
	@Test
	public void should_sum_score_when_player_hit_strike_and_one_and_miss(){
	// given
		String resultBolwingGame = "XXXXXXXXX1-";
	// when
		int score = scoreCalculator.sumScore(resultBolwingGame);
	// then
		Assert.assertEquals(243, score);
	}*/
}
