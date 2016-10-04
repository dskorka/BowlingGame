package pl.kata.bowlinggame.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import pl.kata.bowlinggame.game.Game;

public class SimpleJdbcGameRepository implements GameRepository {

	private final DataSource dataSource;

	@Autowired
	public SimpleJdbcGameRepository(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void save(Game game) {
		if (isNotExistGame(game)) {
			writeGame(game);
		} else {
			updateGame(game);
		}
	}

	public Game load(int idGame) {
		Game game = searchGame(idGame);
		return game;
	}

	private void writeGame(Game game) {
		
		try (Connection connection = dataSource.getConnection();
				PreparedStatement prepatedStatement = connection.prepareStatement(GameDbConst.SAVE_GAME_SCORE)
			) {

			prepatedStatement.setInt(1, game.getId());
			int[] gameRolls = game.getRolls();

			for (int i = 0; i < gameRolls.length; i++) {
				prepatedStatement.setInt(i + 2, gameRolls[i]);
			}
			prepatedStatement.setInt(23, game.score());

			prepatedStatement.setTimestamp(24, Timestamp.valueOf(game.getTimeGame()));
			
			prepatedStatement.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	private PreparedStatement createPreparedStatement(Connection con, int idGame, String slq) throws SQLException {
		PreparedStatement ps = con.prepareStatement(slq);
		ps.setInt(1, idGame);
		return ps;
	}

	private int getCountOfGames(int idGame) {
		int countOfGames = 0;
		try (Connection connection = dataSource.getConnection();
				PreparedStatement preparedStatement = createPreparedStatement(connection, idGame, GameDbConst.GET_COUNT_BY_ID_GAME);
				ResultSet resultSet = preparedStatement.executeQuery()
			) {

			if (resultSet.next()) {
				countOfGames = resultSet.getInt(1);
			}

		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		}
		return countOfGames;
	}

	private Game searchGame(int id) {
		
		try (Connection connection = dataSource.getConnection();
				PreparedStatement prepatedStatement = createPreparedStatement(connection, id, GameDbConst.SEARCH_GAME_BY_ID);
				ResultSet rs = prepatedStatement.executeQuery()
			) {

			if (rs.next()) {
				int[] resultScore = new int[21];
				
				resultScore[0] = Integer.parseInt(rs.getString(GameDbConst.FIRST_ROLL));
				resultScore[1] = Integer.parseInt(rs.getString(GameDbConst.SECOND_ROLL));
				resultScore[2] = Integer.parseInt(rs.getString(GameDbConst.THIRD_ROLL));
				resultScore[3] = Integer.parseInt(rs.getString(GameDbConst.FOURTH_ROLL));
				resultScore[4] = Integer.parseInt(rs.getString(GameDbConst.FIFTH_ROLL));
				resultScore[5] = Integer.parseInt(rs.getString(GameDbConst.SIXTH_ROLL));
				resultScore[6] = Integer.parseInt(rs.getString(GameDbConst.SEVENTH_ROLL));
				resultScore[7] = Integer.parseInt(rs.getString(GameDbConst.EIGHTH_ROLL));
				resultScore[8] = Integer.parseInt(rs.getString(GameDbConst.NINTH_ROLL));
				resultScore[9] = Integer.parseInt(rs.getString(GameDbConst.TENTH_ROLL));
				resultScore[10] = Integer.parseInt(rs.getString(GameDbConst.ELEVENTH_ROLL));
				resultScore[11] = Integer.parseInt(rs.getString(GameDbConst.TWELFTH_ROLL));
				resultScore[12] = Integer.parseInt(rs.getString(GameDbConst.THIRTEENTH_ROLL));
				resultScore[13] = Integer.parseInt(rs.getString(GameDbConst.FOURTEENTH_ROLL));
				resultScore[14] = Integer.parseInt(rs.getString(GameDbConst.FIFTEENTH_ROLL));
				resultScore[15] = Integer.parseInt(rs.getString(GameDbConst.SIXTEENTH_ROLL));
				resultScore[16] = Integer.parseInt(rs.getString(GameDbConst.SEVENTEENTH_ROLL));
				resultScore[17] = Integer.parseInt(rs.getString(GameDbConst.EIGHTEENTH_ROLL));
				resultScore[18] = Integer.parseInt(rs.getString(GameDbConst.NINETEENTH_ROLL));
				resultScore[19] = Integer.parseInt(rs.getString(GameDbConst.TWENTYTH_ROLL));
				resultScore[20] = Integer.parseInt(rs.getString(GameDbConst.TWENTH_FIRST_ROLL));
				
				int idGa = rs.getInt(GameDbConst.ID);
				Game roundGame = new Game(idGa, resultScore);
				return roundGame;
			}

		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		}
		return null;
	}

	private void updateGame(Game game) {

		try (Connection conn = dataSource.getConnection();
				PreparedStatement prepatedStatement = conn.prepareStatement(GameDbConst.UPDATE_GAME_SCORE)
			) {

			int[] gameRolls = game.getRolls();

			for (int i = 0; i < gameRolls.length; i++) {
				prepatedStatement.setInt(i + 1, gameRolls[i]);
			}

			int id = game.getId();
			prepatedStatement.setInt(22, game.score());
			prepatedStatement.setInt(23, id);
			prepatedStatement.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	private boolean isNotExistGame(Game game) {
		return getCountOfGames(game.getId()) == 0;
	}
}
