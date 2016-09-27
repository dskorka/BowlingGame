package pl.kata.bowlingGame;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import pl.kata.bowlingGame.game.Game;

public class GameRowMapper implements RowMapper<Game> {

	@Override
	public Game mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		int id = rs.getInt("id");
		
		int[] resultScore = new int[21];

		resultScore[0] = rs.getInt("first_roll");
		resultScore[1] = rs.getInt("second_roll");
		resultScore[2] = rs.getInt("third_roll");
		resultScore[3] = rs.getInt("fourth_roll");
		resultScore[4] = rs.getInt("fifth_roll");
		resultScore[5] = rs.getInt("sixth_roll");
		resultScore[6] = rs.getInt("seventh_roll");
		resultScore[7] = rs.getInt("eighth_roll");
		resultScore[8] = rs.getInt("ninth_roll");
		resultScore[9] = rs.getInt("tenth_roll");
		resultScore[10] = rs.getInt("eleventh_roll");
		resultScore[11] = rs.getInt("twelfth_roll");
		resultScore[12] = rs.getInt("thirteenth_roll");
		resultScore[13] = rs.getInt("fourteenth_roll");
		resultScore[14] = rs.getInt("fifteenth_roll");
		resultScore[15] = rs.getInt("sixteenth_roll");
		resultScore[16] = rs.getInt("seventeenth_roll");
		resultScore[17] = rs.getInt("eighteenth_roll");
		resultScore[18] = rs.getInt("nineteenth_roll");
		resultScore[19] = rs.getInt("twentyth_roll");
		resultScore[20] = rs.getInt("twenty_first_roll");

		return new Game(id, resultScore);
	}
}
