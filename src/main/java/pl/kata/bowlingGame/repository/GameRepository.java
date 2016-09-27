package pl.kata.bowlingGame.repository;

import pl.kata.bowlingGame.game.Game;


public interface GameRepository {
	void save(Game game);
	Game load(int idGame);
}
