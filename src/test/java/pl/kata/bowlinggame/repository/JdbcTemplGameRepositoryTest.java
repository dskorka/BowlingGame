package pl.kata.bowlinggame.repository;

import javax.sql.DataSource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.kata.bowlinggame.game.Game;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = JdbcTemplGameRepositoryTest.Conf.class)
public class JdbcTemplGameRepositoryTest {
	
	//@Autowired
	//GameRepository gameRepository;
	
	
	/*public JdbcTemplGameRepositoryTest(GameRepository gameRepository) {
		this.gameRepository = gameRepository;
	}*/
	
	
	@Test
	public void should_init_jdbc_template_game_repository(){
		//Assert.assertNotNull(gameRepository);
	}
	/*
	@Test
	public void should_save_and_load_game_of_data_base() {
		// given
		Game testGame = new Game(1);
		for (int i = 0; i < 20; i++) {
			testGame.roll(1);
		}

		// when
		gameRepository.save(testGame);
		Game gameOfRepository = gameRepository.load(testGame.getId());

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
		gameRepository.save(testGame);
		Game gameOfRepo = gameRepository.load(testGame.getId());

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
		gameRepository.save(testGame);

		for (int i = 0; i < 10; i++) {
			testGame.roll(1);
		}
		gameRepository.save(testGame);
		// when

		Game gameOfRepo = gameRepository.load(testGame.getId());

		// then
		Assert.assertEquals(30, gameOfRepo.score());
	}*/
	
	@Configuration
	class Conf {

		/*@Bean
		public EmbeddedDatabase dataSource() {
			EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
			return builder
					.setType(EmbeddedDatabaseType.H2)
					.setName("ds").addScript("classpath:db/create_table.sql")
					.build();
		}

		@Bean
		public JdbcOperations jdbcTemplate(DataSource dataSource) {
			return new JdbcTemplate(dataSource);
		}*/

	}
}
