package pl.kata.bowlinggame.repository;

import java.util.List;

import pl.kata.bowlinggame.game.GameViewModel;

public interface GameFinder {
	List<GameViewModel> findAll();
}
