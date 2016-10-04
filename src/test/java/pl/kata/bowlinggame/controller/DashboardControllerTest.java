package pl.kata.bowlinggame.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import pl.kata.bowlinggame.finder.GameFinder;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class DashboardControllerTest {
	
	MockMvc mockMvc;
	private GameFinder gameFinder = Mockito.mock(GameFinder.class);
	
	@Before
	public void setUp(){
		mockMvc = MockMvcBuilders
				.standaloneSetup(new DashboardController(gameFinder))
				.build();
	}

	@Test
	public void should_show_dashboard() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders
				.get("/"))
				.andExpect(MockMvcResultMatchers
						.status()
						.isOk());
	}
	
}
