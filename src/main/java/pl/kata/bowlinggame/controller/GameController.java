package pl.kata.bowlinggame.controller;

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
import pl.kata.bowlinggame.game.GameService;
import pl.kata.bowlinggame.repository.GameRepository;

@Controller
public class GameController {

	private final GameRepository gameRepository;
	private final GameService gameService;

	@Autowired
	public GameController(GameRepository gameRepository, GameService gameService) {
		this.gameRepository = gameRepository;
		this.gameService = gameService;
	}

	@RequestMapping("/games/{id}")
	public String getGameDetails(@PathVariable("id") int id, Model model) {
		
		Game searchGame = gameRepository.load(id);

		model.addAttribute("id", searchGame.getId());
		model.addAttribute("rolls", gameService.prepareFramesWithScores(searchGame.getRolls()));
		model.addAttribute("score", searchGame.score());

		return "/games/list";
	}

	@RequestMapping("/games/add")
	public String addNewGame(Model model) {
		model.addAttribute(new GameRolls());
		return "/games/add";
	}

	@RequestMapping(value = "/games/add", method = RequestMethod.POST)
	public String addNewGamePost(@ModelAttribute @Valid GameRolls gameRolls, BindingResult bindingResult) {
	
		if (bindingResult.hasErrors()) {
			return "/games/add";
		} else {

			final Game game = new Game(gameRolls.getRolls());
			
			final int id = gameRepository.save(game);
			
			return "redirect:/games/" + id;
		}
	}
}
