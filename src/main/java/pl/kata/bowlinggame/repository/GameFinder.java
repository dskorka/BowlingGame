package pl.kata.bowlinggame.repository;

import java.util.List;

import pl.kata.bowlinggame.game.GameBasicView;

public interface GameFinder {
	List<GameBasicView> findAll();
}
