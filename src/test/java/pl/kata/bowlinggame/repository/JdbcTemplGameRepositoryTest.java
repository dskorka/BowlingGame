package pl.kata.bowlinggame.repository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.kata.bowlinggame.game.Game;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DataSourceTestConfiguration.class)

public class JdbcTemplGameRepositoryTest {
	
	@Autowired
	JdbcOperations jdbcOperations;
	
	private GameRepository templateGameRepository;
	
	
	@Before
	public void setUp(){
		templateGameRepository = new JdbcTemplateGameRepository(jdbcOperations);
	}
	
	
	@Test
	public void should_init_jdbc_template_game_repository(){
		Assert.assertNotNull(templateGameRepository);
	}

	@Test
	public void should_save_and_load_game_of_data_base() {
		// given
		Game testGame = new Game();
		for (int i = 0; i < 20; i++) {
			testGame.roll(1);
		}

		// when
		int id = templateGameRepository.save(testGame);
		Game gameOfRepository = templateGameRepository.load(id);

		// then
		int score = gameOfRepository.score();
		Assert.assertEquals(20, score);
	}
	
	@Test
	public void should_have_the_same_id_after_save() {
		// given
		Game testGame = new Game(1);
		for (int i = 0; i < 20; i++) {
			testGame.roll(1);
		}

		// when
		templateGameRepository.save(testGame);
		Game gameOfRepo = templateGameRepository.load(testGame.getId());

		// then
		Assert.assertEquals(testGame.getId(), gameOfRepo.getId());
	}

	@Test
	public void should_save_part_game_to_data_base() {
		// given
		Game testGame = new Game(6);
		for (int i = 0; i < 10; i++) {
			testGame.roll(2);
		}
		templateGameRepository.save(testGame);

		for (int i = 0; i < 10; i++) {
			testGame.roll(1);
		}
		templateGameRepository.save(testGame);
		// when

		Game gameOfRepo = templateGameRepository.load(testGame.getId());

		// then
		Assert.assertEquals(30, gameOfRepo.score());
	}
	
	
}
