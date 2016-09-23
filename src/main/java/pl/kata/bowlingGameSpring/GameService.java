package pl.kata.bowlingGameSpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.kata.bowlingGame.repository.GameRepository;

@Component
public class GameService {
	
	@Autowired
	GameRepository gameRepository;

	
	public GameService(GameRepository gameRepository) {
		this.gameRepository = gameRepository;
	}
}
