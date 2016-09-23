package pl.kata.bowlingGameSpring;

import org.springframework.stereotype.Component;

import pl.kata.bowlingGame.Game;
import pl.kata.bowlingGame.repository.GameRepository;
@Component
public class BeanGameRepository implements GameRepository {

	@Override
	public void save(Game game) {
		// TODO Auto-generated method stub

	}

	@Override
	public Game load(int idGame) {
		// TODO Auto-generated method stub
		return null;
	}

}
