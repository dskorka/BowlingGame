package pl.kata.bowlinggame.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.kata.bowlinggame.finder.GameFinder;
import pl.kata.bowlinggame.finder.GameViewModel;
import pl.kata.bowlinggame.finder.JdbcGameFinder;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes ={DataSourceTestConfiguration.class})

public class JdbcGameFinderTest {

	@Autowired
	JdbcOperations jdbc;
	
	private GameFinder gameFinder;
	
	@Before
	public void setUp(){
		gameFinder = new JdbcGameFinder(jdbc);
	}
	
	@Test
	public void should_get_all(){
		// given
		int searchColumnNumber = GameViewModelColumnParametr.getColumnNumber("id");
		// when
		List<GameViewModel> list = gameFinder.findAll(searchColumnNumber);
		
		// then
		assertThat(list).isNotEmpty();
	}
}
