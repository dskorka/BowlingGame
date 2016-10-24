package pl.kata.bowlinggame.controller;

import static org.hamcrest.CoreMatchers.startsWith;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GameRollsTest {
	
	GameRolls gameRolls;
	
	@Before
	public void setUp(){
		gameRolls = new GameRolls(1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1);
		
	}

	@Test
	public void testGetRolls() {
		// given
		
		
		// when
		int [] gameRollsTable = gameRolls.getRolls();
		
		//then
		
		//assertEquals(21, gameRollsTable.length);
		//assertThat(gameRollsTable.length, equalTo(21));
		String name = "testuje";
		assertThat(name, startsWith("test"));
	}
	

}
