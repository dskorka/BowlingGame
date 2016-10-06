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
	
	@Autowired
	DataSource dataSource;
	
	private final JdbcOperations jdbcTemplate;	

	@Autowired
	public JdbcTemplateGameRepository(JdbcOperations jdbcTemplate){
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public int save(Game game) {
		//writeGame(game);
		/*
		if (isNotExist(game)) {
		
		} else {
			updateGame(game);
		}*/
		
		GeneratedKeyHolder holder = new GeneratedKeyHolder();
		//jdbcTemplate.update(createPreparedStatement(game),holder);
		
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				 PreparedStatement ps = con.prepareStatement(GameDbConst.SAVE_GAME_SCORE);
				 int[] rolls = game.getRolls();
					for (int i = 0; i <= 20; i++) {
						ps.setInt(i+1, rolls[i]);
					}
					ps.setInt(22,game.score());
					ps.setString(23, game.getTimeGame().toString());
					return ps;
			}
		},holder);
		
		return holder.getKey().intValue();
	}
	
	@Override
	public Game load(int idGame) {
		Game game = jdbcTemplate.queryForObject(GameDbConst.SEARCH_GAME_BY_ID, new Object[]{idGame}, new GameRowMapper());
		return game;
	}
	
	private boolean isNotExist(Game game) {
		return getCountById(game.getId()) == 0;
	}

	private int getCountById(int id) {
		int rowCount = jdbcTemplate.queryForObject(GameDbConst.GET_COUNT_BY_ID_GAME, Integer.class, id);
		return rowCount;
	}
	
	private void writeGame(Game game) {
		/*Object[] listObject = new Object[23];

		int[] rolls = game.getRolls();
		for (int i = 0; i <= 20; i++) {
			listObject[i] = rolls[i];
		}
		listObject[21] = game.score();
		listObject[22] = game.getTimeGame().toString();*/
		GeneratedKeyHolder holder = new GeneratedKeyHolder();
		//jdbcTemplate.update(createPreparedStatement(game),holder);
		
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				 PreparedStatement ps = con.prepareStatement(GameDbConst.SAVE_GAME_SCORE);
				 int[] rolls = game.getRolls();
					for (int i = 0; i <= 20; i++) {
						ps.setInt(i+1, rolls[i]);
					}
					ps.setInt(22,game.score());
					ps.setString(23, game.getTimeGame().toString());
					return ps;
			}
		},holder);
		int primaryKey = holder.getKey().intValue();
	}
	
	public PreparedStatementCreator createPreparedStatement(Game game){
		try(PreparedStatement ps = dataSource.getConnection().prepareStatement(GameDbConst.SAVE_GAME_SCORE)) {
		int[] rolls = game.getRolls();
			for (int i = 0; i <= 20; i++) {
				ps.setInt(i+1, rolls[i]);
			}
			ps.setInt(21,game.score());
			ps.setString(22, game.getTimeGame().toString());
			
			return null;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	

	private void updateGame(Game game) {
		
		Object[] listObject = new Object[23];
		int[] rolls = game.getRolls();
		
		for (int i = 0; i < 21; i++) {
			listObject[i] = rolls[i];
		}
		listObject[21] = game.score();
		listObject[22] = game.getId();

		jdbcTemplate.update(GameDbConst.UPDATE_GAME_SCORE, listObject);
	}
}
