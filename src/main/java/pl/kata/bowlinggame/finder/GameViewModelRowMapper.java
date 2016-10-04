package pl.kata.bowlinggame.finder;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import org.springframework.jdbc.core.RowMapper;

class GameViewModelRowMapper implements RowMapper<GameViewModel> {

	@Override
	public GameViewModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		int id = rs.getInt("id");
		int score = rs.getInt("score");
		LocalDateTime dateGame = rs.getTimestamp("time_game").toLocalDateTime();
	
		return new GameViewModel(id, score, dateGame);
	}
}
