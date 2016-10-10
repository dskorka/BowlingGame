package pl.kata.bowlinggame.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pl.kata.bowlinggame.finder.GameFinder;
import pl.kata.bowlinggame.finder.GameViewModel;
import pl.kata.bowlinggame.finder.SortParameter;


@Controller
public class DashboardController {

	GameFinder gameFinder;
	
	@Autowired
	public DashboardController(GameFinder gameFinder) {
		this.gameFinder = gameFinder;
	}
	
	@RequestMapping(value = {"/", "/games"}, method = RequestMethod.GET)
	public String games(@RequestParam (value = "sortValue", required = false, defaultValue = "ID")
						SortParameter sortValue, Model model) {
		
		List<GameViewModel> games = gameFinder.findAll(sortValue);
		
		model.addAttribute("gameBasicData", games);
		
		return "/games/dashboard";
	}

}
