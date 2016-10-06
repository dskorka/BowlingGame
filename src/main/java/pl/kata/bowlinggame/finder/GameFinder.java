package pl.kata.bowlinggame.finder;

import java.util.List;

public interface GameFinder {
	List<GameViewModel> findAll(SortParameter sortParameter);
}
