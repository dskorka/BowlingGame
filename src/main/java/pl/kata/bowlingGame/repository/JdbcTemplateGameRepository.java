package pl.kata.bowlinggame.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
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
	public void save(Game game) {
		if (isNotExist(game)) {
			writeGame(game);
		} else {
			updateGame(game);
		}
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
		Object[] listObject = new Object[24];
		
		listObject[0] = game.getId();

		int[] rolls = game.getRolls();
		for (int i = 1; i < 22; i++) {
			listObject[i] = rolls[i - 1];
		}
		listObject[22] = game.score();
		listObject[23] = game.getTimeGame().toString();
		
		jdbcTemplate.update(GameDbConst.SAVE_GAME_SCORE, listObject);
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
