package pl.kata.bowlinggame.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.kata.bowlinggame.game.GameViewModel;
import pl.kata.bowlinggame.repository.GameFinder;
import pl.kata.bowlinggame.repository.SortParameter;

@Controller
public class DashboardController {

	GameFinder gameFinder;
	
	@Autowired
	public DashboardController(GameFinder gameFinder) {
		this.gameFinder = gameFinder;
	}
	
	@RequestMapping("/")
	public String game(Model model) {
		
		final List<GameViewModel> games = gameFinder.findAll(1);
		model.addAttribute("gameBasicData", games);
		
		return "dashboard";
	}
	
	
}
