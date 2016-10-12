package pl.kata.bowlinggame.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import pl.kata.bowlinggame.game.Game;
import pl.kata.bowlinggame.repository.GameRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = GameRestControllerTest.ContextConfiguration.class)
public class GameRestControllerTest {

	@Autowired
	private WebApplicationContext webAppContext;

	private MockGameRepository mockGameRepo;

	private MockMvc mockMvc;

	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webAppContext).dispatchOptions(true).build();
		mockGameRepo = new MockGameRepository();
	}

	@Ignore
	@Test
	public void should_get_game_with_api() throws Exception {
		this.mockMvc.perform(get("/games/api/1").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$.id").value(1));
	}

	public class MockGameRepository implements GameRepository {

		private List<Game> gameList;

		private MockGameRepository() {
			gameList = new ArrayList<>();
			gameList.add(initializeGame());
		}

		private Game initializeGame() {
			Game game = new Game(1);
			for (int i = 0; i < 20; i++) {
				game.roll(1);
			}
			return game;
		}

		@Override
		public int save(Game game) {
			return 0;
		}

		@Override
		public Game load(int idGame) {
			return gameList.get(idGame);
		}

	}

	@Configuration
	@EnableWebMvc
	@ComponentScan(basePackages = "pl.kata.bowlinggame")
	static class ContextConfiguration {
	}

}
