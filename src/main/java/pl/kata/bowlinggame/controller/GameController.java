package pl.kata.bowlinggame.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.kata.bowlinggame.game.Game;
import pl.kata.bowlinggame.game.GameService;
import pl.kata.bowlinggame.repository.GameRepository;

@Controller
public class GameController {

	GameRepository gameRepository;
	GameService gameService;

	@Autowired
	public GameController(GameRepository gameRepository, GameService gameService){
		this.gameRepository = gameRepository;
		this.gameService = gameService;
	}

	@RequestMapping("/playGame")
	public String game(Model model) {
		
		Game game = new Game(1);
		
		for (int i = 0; i < 4; i++) {
			game.roll(2);
			game.roll(5);
			game.roll(7);
			game.roll(8);
			game.roll(9);
		}
		
		gameRepository.save(game);
		
		Game gamesOfRepo = gameRepository.load(game.getId());
		
		model.addAttribute("id", gamesOfRepo.getId());
		model.addAttribute("rolls", gameService.prepareFramesWithScores(gamesOfRepo.getRolls()));
		model.addAttribute("score", gamesOfRepo.score());
		
		return "game";
	}
}
