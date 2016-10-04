package pl.kata.bowlinggame.finder;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcGameFinder implements GameFinder {
	

	private static final String SELECT_ALL_GAMES = "select id , score , time_game from game_rolls order by = ?";
	
	private final JdbcOperations jdbc;
	
	@Autowired
	public JdbcGameFinder(JdbcOperations jdbc) {
		this.jdbc = jdbc;
	}

	@Override
	public List<GameViewModel> findAll(int columnNumberSort) {
		return jdbc.query(SELECT_ALL_GAMES ,new Object[] { columnNumberSort }, new GameViewModelRowMapper());
	}

}
