package pl.kata.bowlingGame.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import pl.kata.bowlingGame.Game;


public class DataBaseGameRepository implements GameRepository {

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
			
	private static final String SELECT_GAME_BY_ID = "select count(*) from " + TABLE_NAME + " where id = ?";
	
	private static final String SELECT_ALL_COLUMN_BY_ID ="select * from " + TABLE_NAME + " where id = ?";
	
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

	private final DataSource dataSource;
	
    public DataBaseGameRepository(DataSource dataSource){
    	this.dataSource = dataSource;
    }
	
    public void save(Game game) {
		if (isNotExistGame(game)) {
			writeResultToDataBase(game);
		} else {
			updateGameScore(game);
		}
	}
    
    public Game load(int idGame) {
		Game game = searchRoundGame(idGame);
		return game;
	}
	

	private void writeResultToDataBase(Game game) {

		try (Connection connection = dataSource.getConnection();
				PreparedStatement prepatedStatement = connection.prepareStatement(SAVE_GAME_SCORE)) {

			prepatedStatement.setInt(1, game.getId());
			int[] gameRolls = game.getRolls();

			for (int i = 0; i < gameRolls.length; i++) {
				prepatedStatement.setInt(i + 2, gameRolls[i]);
			}
			prepatedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	private int searchRoundGameEx(int idGame) {
		int isExist = 0;
		try (Connection connection = dataSource.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_GAME_BY_ID)
			) {
			preparedStatement.setInt(1, idGame);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				isExist = resultSet.getInt(1);
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new RuntimeException();
		}
		return isExist;
	}
	
	private Game searchRoundGame(int id) {
		Game roundGame = null;

		try (Connection connection = dataSource.getConnection();
				PreparedStatement prepatedStatement = connection.prepareStatement(SELECT_ALL_COLUMN_BY_ID);) {
			prepatedStatement.setInt(1, id);

			ResultSet rs = prepatedStatement.executeQuery();
			int[] resultScore = new int[21];

			while (rs.next()) {

				int idGa = rs.getInt(ID);
				resultScore[0] = Integer.parseInt(rs.getString(FIRST_ROLL));
				resultScore[1] = Integer.parseInt(rs.getString(SECOND_ROLL));
				resultScore[2] = Integer.parseInt(rs.getString(THIRD_ROLL));
				resultScore[3] = Integer.parseInt(rs.getString(FOURTH_ROLL));
				resultScore[4] = Integer.parseInt(rs.getString(FIFTH_ROLL));
				resultScore[5] = Integer.parseInt(rs.getString(SIXTH_ROLL));
				resultScore[6] = Integer.parseInt(rs.getString(SEVENTH_ROLL));
				resultScore[7] = Integer.parseInt(rs.getString(EIGHTH_ROLL));
				resultScore[8] = Integer.parseInt(rs.getString(NINTH_ROLL));
				resultScore[9] = Integer.parseInt(rs.getString(TENTH_ROLL));
				resultScore[10] = Integer.parseInt(rs.getString(ELEVENTH_ROLL));
				resultScore[11] = Integer.parseInt(rs.getString(TWELFTH_ROLL));
				resultScore[12] = Integer.parseInt(rs.getString(THIRTEENTH_ROLL));
				resultScore[13] = Integer.parseInt(rs.getString(FOURTEENTH_ROLL));
				resultScore[14] = Integer.parseInt(rs.getString(FIFTEENTH_ROLL));
				resultScore[15] = Integer.parseInt(rs.getString(SIXTEENTH_ROLL));
				resultScore[16] = Integer.parseInt(rs.getString(SEVENTEENTH_ROLL));
				resultScore[17] = Integer.parseInt(rs.getString(EIGHTEENTH_ROLL));
				resultScore[18] = Integer.parseInt(rs.getString(NINETEENTH_ROLL));
				resultScore[19] = Integer.parseInt(rs.getString(TWENTYTH_ROLL));
				resultScore[20] = Integer.parseInt(rs.getString(TWENTH_FIRST_ROLL));

				roundGame = new Game(idGa, resultScore);
			}

		} catch (SQLException ex) {
			throw new RuntimeException();
		}
		return roundGame;
	}
	
	private void updateGameScore(Game game) {

		try (Connection conn = dataSource.getConnection();
				PreparedStatement prepatedStatement = conn.prepareStatement(UPDATE_GAME_SCORE)
			) {

			int[] gameRolls = game.getRolls();
		
			for (int i = 0; i < gameRolls.length; i++) {
				prepatedStatement.setInt(i + 1, gameRolls[i]);
			}
			
			int id = game.getId();
			prepatedStatement.setInt(22, id);
			prepatedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	private boolean isNotExistGame(Game game) {
		return searchRoundGameEx(game.getId()) == 0;
	}
}
