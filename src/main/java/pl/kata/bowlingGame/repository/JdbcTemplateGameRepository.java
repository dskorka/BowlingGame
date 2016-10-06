package pl.kata.bowlinggame.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import pl.kata.bowlinggame.game.Game;


@Repository
class JdbcTemplateGameRepository implements GameRepository {
	
	private final JdbcOperations jdbcTemplate;	

	@Autowired
	public JdbcTemplateGameRepository(JdbcOperations jdbcTemplate){
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public int save(Game game) {
		int id = writeGame(game);
		return id;
	}
	
	@Override
	public Game load(int idGame) {
		Game game = jdbcTemplate.queryForObject(GameDbConst.SEARCH_GAME_BY_ID, new Object[]{idGame}, new GameRowMapper());
		return game;
	}
	
	private int writeGame(Game game) {
	
		GeneratedKeyHolder idGame = new GeneratedKeyHolder();

		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				 PreparedStatement ps = connection.prepareStatement(GameDbConst.SAVE_GAME_SCORE);
				 	int[] rolls = game.getRolls();
					
				 	for (int i = 0; i <= 20; i++) {
						ps.setInt(i+1, rolls[i]);
					}
					
				 	ps.setInt(22,game.score());
					ps.setString(23, game.getTimeGame().toString());
					
					return ps;
			}
		},idGame);
		
		return idGame.getKey().intValue();
	}
}
