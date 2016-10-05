package pl.kata.bowlinggame.controller;

import java.util.Random;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.kata.bowlinggame.game.Game;
import pl.kata.bowlinggame.game.GameRolls;
import pl.kata.bowlinggame.game.GameService;
import pl.kata.bowlinggame.repository.GameRepository;

@Controller
public class GameController {

	GameRepository gameRepository;
	GameService gameService;

	@Autowired
	public GameController(GameRepository gameRepository, GameService gameService) {
		this.gameRepository = gameRepository;
		this.gameService = gameService;
	}

	@RequestMapping("/playGame")
	public String game(Model model) {
		
		Random rd = new Random();
		Game game = new Game(rd.nextInt(100));

		for (int i = 0; i < 20; i++) {
			game.roll(rd.nextInt(10));
		}

		gameRepository.save(game);

		Game gamesOfRepo = gameRepository.load(game.getId());

		model.addAttribute("id", gamesOfRepo.getId());
		model.addAttribute("rolls", gameService.prepareFramesWithScores(gamesOfRepo.getRolls()));
		model.addAttribute("score", gamesOfRepo.score());

		return "game";
	}
	
	@RequestMapping("/gameDetails/{id}")
	public String getGameDetails(@PathVariable("id") int id, Model model){
		Game searchGame = gameRepository.load(id);
		
		model.addAttribute("id", searchGame.getId());
		model.addAttribute("rolls", gameService.prepareFramesWithScores(searchGame.getRolls()));
		model.addAttribute("score", searchGame.score());
		
		return "game";
	}
	
	
	@RequestMapping("/add")
	public String addNewGame(@ModelAttribute GameRolls gameRolls){
		return "newGame";
	}
	
	@RequestMapping(value = "/add", method= RequestMethod.POST)
	public String addNewGamePost(Model model, @ModelAttribute @Valid GameRolls gameRolls,
			BindingResult bindingResult){
		
		if(bindingResult.hasErrors()){
			return "newGame";
		} else {
			
		}

		return "dashboard";
	}
}
