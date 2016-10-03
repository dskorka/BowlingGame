package pl.kata.bowlinggame.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;

import pl.kata.bowlinggame.game.GameBasicView;

@Repository
public class DefaultGameFinder implements GameFinder {
	
	private final JdbcOperations jdbc;
	
	@Autowired
	public DefaultGameFinder(JdbcOperations jdbc) {
		this.jdbc = jdbc;
	}

	@Override
	public List<GameBasicView> findAll() {
		return jdbc.query(GameDbConst.SELECT_ALL_GAMES, new GameBasicDataRowMapper());
	}

}