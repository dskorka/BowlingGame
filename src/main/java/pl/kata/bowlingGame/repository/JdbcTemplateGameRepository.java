package pl.kata.bowlinggame.repository;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import pl.kata.bowlinggame.game.Game;


class JdbcTemplateGameRepository implements GameRepository {
	
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplateGameRepository(DataSource dataSource){
		this.jdbcTemplate = new JdbcTemplate(dataSource);
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
		Game game = jdbcTemplate.queryForObject(StructureDataBase.SEARCH_GAME_BY_ID, new Object[]{idGame}, new GameRowMapper());
		return game;
	}
	
	private boolean isNotExist(Game game) {
		return getCountById(game.getId()) == 0;
	}

	private int getCountById(int id) {
		int rowCount = jdbcTemplate.queryForObject(StructureDataBase.GET_COUNT_BY_ID_GAME, Integer.class, id);
		return rowCount;
	}
	
	private void writeGame(Game game) {
		Object[] listObject = new Object[22];
		
		listObject[0] = game.getId();

		int[] rolls = game.getRolls();
		for (int i = 1; i < 22; i++) {
			listObject[i] = rolls[i - 1];
		}

		jdbcTemplate.update(StructureDataBase.SAVE_GAME_SCORE, listObject);
	}

	private void updateGame(Game game) {
		
		Object[] listObject = new Object[22];
		int[] rolls = game.getRolls();
		
		for (int i = 0; i < 21; i++) {
			listObject[i] = rolls[i];
		}
		listObject[21] = game.getId();

		jdbcTemplate.update(StructureDataBase.UPDATE_GAME_SCORE, listObject);
	}
}
