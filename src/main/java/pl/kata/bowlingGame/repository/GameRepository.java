package pl.kata.bowlinggame.repository;

import pl.kata.bowlinggame.game.Game;


public interface GameRepository {
	void save(Game game);
	Game load(int idGame);
}
