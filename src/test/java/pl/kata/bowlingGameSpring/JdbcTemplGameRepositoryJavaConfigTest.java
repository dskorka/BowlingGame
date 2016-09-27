package pl.kata.bowlingGameSpring;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.kata.bowlingGame.game.Game;
import pl.kata.bowlingGame.repository.GameRepository;
import pl.kata.bowlingGame.repository.JdbcTemplateGameRepository;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = DataSourceConfig.class)
@ContextConfiguration(classes = JdbcTemplGameRepositoryJavaConfigTest.Config.class)
public class JdbcTemplGameRepositoryJavaConfigTest {
	
	
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
	
	@Configuration
	static class Config{
		@Bean
		public EmbeddedDatabase dataSource() {
			EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
			return builder
					.setType(EmbeddedDatabaseType.H2)
					.setName("ds")
					.addScript("classpath:db/create_table.sql")
					.build();
		}
		
		@Bean
		public GameRepository jdbcTemplateGameRepository(){
			return new JdbcTemplateGameRepository(dataSource());
		}
	}
}
