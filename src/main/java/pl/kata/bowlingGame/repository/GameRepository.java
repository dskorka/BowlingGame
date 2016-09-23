package pl.kata.bowlingGame.repository;

import pl.kata.bowlingGame.Game;


public interface GameRepository {
	void save(Game game);
	Game load(int idGame);
}
