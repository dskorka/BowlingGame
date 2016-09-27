package pl.kata.bowlinggame.conf;

import org.springframework.stereotype.Component;

import pl.kata.bowlinggame.game.Game;
import pl.kata.bowlinggame.repository.GameRepository;

@Component
public class GameRepositoryImpl implements GameRepository {

	@Override
	public void save(Game game) {
		System.out.println("Saving.....");

	}

	@Override
	public Game load(int idGame) {
		// TODO Auto-generated method stub
		return null;
	}

}
