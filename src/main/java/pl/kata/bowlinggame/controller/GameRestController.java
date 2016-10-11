package pl.kata.bowlinggame.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.kata.bowlinggame.finder.GameViewModel;
import pl.kata.bowlinggame.game.Game;
import pl.kata.bowlinggame.repository.GameRepository;

@RestController
public class GameRestController {
	
	private final GameRepository gameRepository;
	
	@Autowired
	public GameRestController(GameRepository gameRepository){
		this.gameRepository = gameRepository;
	}
	
	
	@RequestMapping("/games/api/{id}")
	public GameViewModel getGameViewModel(@PathVariable int id){
		
		Game searchGame = gameRepository.load(id);
		
		return new GameViewModel(searchGame.getId(), searchGame.score(), searchGame.getTimeGame());
	}

}
