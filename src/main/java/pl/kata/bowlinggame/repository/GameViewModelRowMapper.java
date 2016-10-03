package pl.kata.bowlinggame.repository;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import org.springframework.jdbc.core.RowMapper;

import pl.kata.bowlinggame.game.GameViewModel;

public class GameViewModelRowMapper implements RowMapper<GameViewModel> {

	@Override
	public GameViewModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		int id = rs.getInt(GameDbConst.ID);
		int score = rs.getInt(GameDbConst.SCORE);
		LocalDate insert_date = rs.getDate(GameDbConst.INSERT_TIME).toLocalDate();
	
		return new GameViewModel(id, score, insert_date);
	}
}
