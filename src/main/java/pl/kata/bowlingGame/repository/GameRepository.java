package pl.kata.bowlinggame.repository;

import pl.kata.bowlinggame.game.Game;

 
public interface GameRepository {
	int save(Game game);
	Game load(int idGame);
}
