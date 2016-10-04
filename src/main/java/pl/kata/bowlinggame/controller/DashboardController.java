package pl.kata.bowlinggame.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pl.kata.bowlinggame.game.GameViewModel;
import pl.kata.bowlinggame.repository.GameFinder;
import pl.kata.bowlinggame.repository.GameViewModelColumnParametr;

@Controller
public class DashboardController {

	GameFinder gameFinder;
	
	@Autowired
	public DashboardController(GameFinder gameFinder) {
		this.gameFinder = gameFinder;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String game(@RequestParam(value = "sortValue", required = false, defaultValue = "id")
						String sortValue, Model model) {
		
		int searchTableNumber = GameViewModelColumnParametr.getColumnNumber(sortValue);
		List<GameViewModel> games = gameFinder.findAll(searchTableNumber);
		
		model.addAttribute("gameBasicData", games);
		
		return "dashboard";
	}
}
