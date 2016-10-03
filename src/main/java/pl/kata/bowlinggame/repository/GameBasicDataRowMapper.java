package pl.kata.bowlinggame.repository;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import pl.kata.bowlinggame.game.GameBasicView;

public class GameBasicDataRowMapper implements RowMapper<GameBasicView> {

	@Override
	public GameBasicView mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		int id = rs.getInt(GameDbConst.ID);
		
		int score = rs.getInt(GameDbConst.FIRST_ROLL) +
				rs.getInt(GameDbConst.SECOND_ROLL) +
				rs.getInt(GameDbConst.THIRD_ROLL) + 
				rs.getInt(GameDbConst.FOURTH_ROLL) + 
				rs.getInt(GameDbConst.FIFTH_ROLL) + 
				rs.getInt(GameDbConst.SIXTH_ROLL) + 
				rs.getInt(GameDbConst.SEVENTH_ROLL) + 
				rs.getInt(GameDbConst.EIGHTH_ROLL) + 
				rs.getInt(GameDbConst.NINTH_ROLL) + 
				rs.getInt(GameDbConst.TENTH_ROLL) + 
				rs.getInt(GameDbConst.ELEVENTH_ROLL) + 
				rs.getInt(GameDbConst.TWELFTH_ROLL) + 
				rs.getInt(GameDbConst.THIRTEENTH_ROLL) + 
				rs.getInt(GameDbConst.FOURTEENTH_ROLL) +
				rs.getInt(GameDbConst.FIFTEENTH_ROLL) +
				rs.getInt(GameDbConst.SIXTEENTH_ROLL) + 
				rs.getInt(GameDbConst.SEVENTEENTH_ROLL) + 
				rs.getInt(GameDbConst.EIGHTEENTH_ROLL) + 
				rs.getInt(GameDbConst.NINETEENTH_ROLL) + 
				rs.getInt(GameDbConst.TWELFTH_ROLL) + 
				rs.getInt(GameDbConst.TWENTH_FIRST_ROLL);
		
		String insert_date = rs.getString(GameDbConst.INSERT_DATE);
		
		return new GameBasicView(id, score, insert_date);
	}
}
