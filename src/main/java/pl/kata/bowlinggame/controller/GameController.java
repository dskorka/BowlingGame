package pl.kata.bowlinggame.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.kata.bowlinggame.game.Game;
import pl.kata.bowlinggame.game.GameServiceDefault;

@Controller
public class GameController {
	
	@Autowired
	GameServiceDefault gameService;
	
	@RequestMapping("/")
	public String game(){
		return "dashboard";
	}

	@RequestMapping("/playGame")
	public String game(Model model) {

		Game game = new Game(1);
		for (int i = 0; i < 2; i++) {
			game.roll(1);
			game.roll(2);
			game.roll(3);
			game.roll(4);
			game.roll(5);
			game.roll(6);
			game.roll(7);
			game.roll(8);
			game.roll(9);
			game.roll(9);
		}

		model.addAttribute("id", game.getId());
		model.addAttribute("rolls", gameService.prepareFramesWithScores(game.getRolls()));
		model.addAttribute("score", game.score());
		return "game";
	}
	
	
}
