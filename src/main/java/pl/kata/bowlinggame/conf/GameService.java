package pl.kata.bowlinggame.conf;

import org.springframework.beans.factory.annotation.Autowired;

public class GameService {
	
	GameRepositoryImpl gameRepository;
	
	@Autowired
	public GameService(GameRepositoryImpl gameRepository){
		this.gameRepository = gameRepository;
	}
	
}
