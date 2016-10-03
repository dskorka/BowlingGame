package pl.kata.bowlinggame.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.kata.bowlinggame.game.GameBasicView;
import pl.kata.bowlinggame.repository.GameFinder;
import pl.kata.bowlinggame.repository.GameRepository;

@Controller
public class DashboardController {

	GameRepository gameRepository;
	GameFinder gameFinder;
	
	@Autowired
	public DashboardController(GameRepository gameRepository,GameFinder gameFinder) {
		this.gameRepository = gameRepository;
		this.gameFinder = gameFinder;
	}
	
	@RequestMapping("/")
	public String game(Model model) {
		
		final List<GameBasicView> games = gameFinder.findAll();
		model.addAttribute("gameBasicData", games);
		
		return "dashboard";
	}
}
