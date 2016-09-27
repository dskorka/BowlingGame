package pl.kata.bowlinggame.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.kata.bowlinggame.repository.GameRepository;

@Component
public class GameService {
	
	private final GameRepository gameRepository;

	@Autowired
	public GameService(GameRepository gameRepository) {
		this.gameRepository = gameRepository;
	}
}
