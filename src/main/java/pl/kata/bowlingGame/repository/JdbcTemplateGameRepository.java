package pl.kata.bowlingGame.repository;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import pl.kata.bowlingGame.Game;
import pl.kata.bowlingGame.GameRowMapper;

public class JdbcTemplateGameRepository implements GameRepository {
	
	private JdbcTemplate jdbcTemplate;
	
	private static final String TABLE_NAME = "game_rolls";
	
	private static final String ID = "id";
	private static final String FIRST_ROLL = "first_roll";
	private static final String SECOND_ROLL = "second_roll";
	private static final String THIRD_ROLL = "third_roll";
	private static final String FOURTH_ROLL = "fourth_roll";
	private static final String FIFTH_ROLL = "fifth_roll";
	private static final String SIXTH_ROLL = "sixth_roll";
	private static final String SEVENTH_ROLL = "seventh_roll";
	private static final String EIGHTH_ROLL = "eighth_roll";
	private static final String NINTH_ROLL = "ninth_roll";
	private static final String TENTH_ROLL = "tenth_roll";
	private static final String ELEVENTH_ROLL = "eleventh_roll";
	private static final String TWELFTH_ROLL = "twelfth_roll";
	private static final String THIRTEENTH_ROLL = "thirteenth_roll";
	private static final String FOURTEENTH_ROLL = "fourteenth_roll";
	private static final String FIFTEENTH_ROLL = "fifteenth_roll";
	private static final String SIXTEENTH_ROLL = "sixteenth_roll";
	private static final String SEVENTEENTH_ROLL = "seventeenth_roll";
	private static final String EIGHTEENTH_ROLL = "eighteenth_roll";
	private static final String NINETEENTH_ROLL = "nineteenth_roll";
	private static final String TWENTYTH_ROLL = "twentyth_roll";
	private static final String TWENTH_FIRST_ROLL = "twenty_first_roll";

	private static final String SAVE_GAME_SCORE = " insert into " + TABLE_NAME 
			+ " ( " + ID + " , " + FIRST_ROLL + " , " + SECOND_ROLL + " , " + THIRD_ROLL + " , " +
			FOURTH_ROLL + " , " + FIFTH_ROLL + " , " + SIXTH_ROLL + " , " + SEVENTH_ROLL + " , " +
			EIGHTH_ROLL + " , " + NINTH_ROLL + " , " + TENTH_ROLL + " , " + ELEVENTH_ROLL + " , " +
			TWELFTH_ROLL + " , " + THIRTEENTH_ROLL + " , " + FOURTEENTH_ROLL + " , " + 
			FIFTEENTH_ROLL + " , " + SIXTEENTH_ROLL + " , " + SEVENTEENTH_ROLL + " , " +
			EIGHTEENTH_ROLL + " , " + NINETEENTH_ROLL + " , " + TWENTYTH_ROLL + " , " +
			TWENTH_FIRST_ROLL	+ " ) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)" ;
	
	private static final String UPDATE_GAME_SCORE = "update " + TABLE_NAME + 
			" set " + 
			FIRST_ROLL + " = ?," + SECOND_ROLL + " = ?," +
			THIRD_ROLL + " = ?," + FOURTH_ROLL + " = ?," +
			FIFTH_ROLL + " = ?," + SIXTH_ROLL + " = ?," +
			SEVENTH_ROLL + " = ?," + EIGHTH_ROLL + " = ?," +
			NINTH_ROLL + " = ?," + TENTH_ROLL + " = ?," +
			ELEVENTH_ROLL + " = ?," + TWELFTH_ROLL + " = ?," +
			THIRTEENTH_ROLL + " = ?," + FOURTEENTH_ROLL + " = ?," +
			FIFTEENTH_ROLL + " = ?," + SIXTEENTH_ROLL + " = ?," +
			SEVENTEENTH_ROLL + " = ?," + EIGHTEENTH_ROLL + " = ?," +
			NINETEENTH_ROLL + " = ?," + TWENTYTH_ROLL + " = ?," +
			TWENTH_FIRST_ROLL + " = ?"+
			 " where " + ID + " = ?";
	
	private static final String GET_COUNT_BY_ID_GAME = "select count(*) from " 
								+ TABLE_NAME + " where " + ID + " = ?";
	
	private static final String SEARCH_GAME_BY_ID = "select * from " 
								+ TABLE_NAME + " where " + ID + " = ?";
	
	
	public JdbcTemplateGameRepository(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	

	
	
	@Override
	public void save(Game game) {
		if (isNotExist(game)) {
			writeResultToDataBase(game);
		} else {
			updateGameScore(game);
		}
	}
	
	@Override
	public Game load(int idGame) {
		Game game = jdbcTemplate.queryForObject(SEARCH_GAME_BY_ID, new Object[]{idGame}, new GameRowMapper());
		return game;
	}
	
	private boolean isNotExist(Game game) {
		return getCountById(game.getId()) == 0;
	}

	private int getCountById(int id) {
		int rowCount = jdbcTemplate.queryForObject(GET_COUNT_BY_ID_GAME, Integer.class, id);
		return rowCount;
	}
	
	private void writeResultToDataBase(Game game) {
		Object[] listObject = new Object[22];
		int[] roll = game.getRolls();
		
		listObject[0] = game.getId();

		for (int i = 1; i < 22; i++) {
			listObject[i] = roll[i - 1];
		}

		jdbcTemplate.update(SAVE_GAME_SCORE, listObject);
	}

	private void updateGameScore(Game game) {
		
		Object[] listObject = new Object[22];
		int[] roll = game.getRolls();
		
		for (int i = 0; i < 21; i++) {
			listObject[i] = roll[i];
		}
		listObject[21] = game.getId();

		jdbcTemplate.update(UPDATE_GAME_SCORE, listObject);
	}
}
