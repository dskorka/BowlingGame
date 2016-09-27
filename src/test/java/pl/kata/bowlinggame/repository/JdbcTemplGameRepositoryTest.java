package pl.kata.bowlinggame.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.kata.bowlinggame.game.Game;
import pl.kata.bowlinggame.repository.JdbcTemplateGameRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DataSourceTestConfiguration.class)
public class JdbcTemplGameRepositoryTest {
	
	
	@Autowired
	JdbcTemplateGameRepository jdbcTemplateGameRepository;
	
	
	@Test
	public void should_init_jdbc_template_game_repository(){
		Assert.assertNotNull(jdbcTemplateGameRepository);
	}
	
	@Test
	public void should_save_and_load_game_of_data_base() {
		// given
		Game testGame = new Game(1);
		for (int i = 0; i < 20; i++) {
			testGame.roll(1);
		}

		// when
		jdbcTemplateGameRepository.save(testGame);
		Game gameOfRepository = jdbcTemplateGameRepository.load(testGame.getId());

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
		jdbcTemplateGameRepository.save(testGame);
		Game gameOfRepo = jdbcTemplateGameRepository.load(testGame.getId());

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
		jdbcTemplateGameRepository.save(testGame);

		for (int i = 0; i < 10; i++) {
			testGame.roll(1);
		}
		jdbcTemplateGameRepository.save(testGame);
		// when

		Game gameOfRepo = jdbcTemplateGameRepository.load(testGame.getId());

		// then
		Assert.assertEquals(30, gameOfRepo.score());
	}
}
