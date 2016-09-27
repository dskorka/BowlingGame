package pl.kata.bowlinggame.repository;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import pl.kata.bowlinggame.game.Game;

class FileGameRepository implements GameRepository {
	
	private File filePathToGame;
	
	public FileGameRepository(File filePathToTheGame) {
		this.filePathToGame = filePathToTheGame;
	}

	@Override
	public void save(Game game) {

		List<RoundGame> gameResults = readFromFile();
		List<RoundGame> gameResultsBleble = optionalRemove(gameResults, game.getId());
		gameResultsBleble.add(new RoundGame(game.getId(), game.getRolls()));
		writeResultsToFile(gameResultsBleble);
	}

	@Override
	public Game load(int id) {
		RoundGame gameAsRoundGame = searchGameById(id);
		Game game = new Game(gameAsRoundGame.getId(), gameAsRoundGame.getRolls());
		return game;
	}
	
	private List<RoundGame> optionalRemove(List<RoundGame> gameResultsFromFile, int id) {
		List<RoundGame> gameResultsRoundGame = gameResultsFromFile;
		for (int i=0; i<gameResultsRoundGame.size(); i++) {
			if (gameResultsRoundGame.get(i).getId() == id) {
				gameResultsRoundGame.remove(i);
			}
		}
		return gameResultsRoundGame;
	}

	private void writeResultsToFile(List<RoundGame> gameResults) {
		try (FileWriter fileWriter = new FileWriter(filePathToGame)) {
			for (RoundGame gameScore : gameResults) {
				
				String gameRolls = toString(gameScore.getRolls());
				fileWriter.append(gameScore.getId() + "," + gameRolls);
				fileWriter.write(System.lineSeparator());
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	private List<RoundGame> readFromFile() {
		List<RoundGame> gameResults = new LinkedList<>();
	
		try (FileReader fileReader = new FileReader(filePathToGame);
				BufferedReader bufferedRreader = new BufferedReader(fileReader)
			) {
			String gameAsString = null;
			
			while ((gameAsString = bufferedRreader.readLine()) != null) {
				
				RoundGame roundGame = extractRoundGame(gameAsString);
				gameResults.add(roundGame);
				
			}			
		} catch (IOException iOExcept) {
			throw new RuntimeException(iOExcept);
		}
		return gameResults;
	}

	private RoundGame extractRoundGame(String gameAsString) {
		int[] divideStringItem = extractItems(gameAsString);
		int idGame = divideStringItem[0];
		int[] gameRolls = new int[divideStringItem.length - 1];

		for (int i = 1; i < gameRolls.length; i++) {
			gameRolls[i - 1] = divideStringItem[i];
		}
		return new RoundGame(idGame, gameRolls);
	}

	private RoundGame searchGameById(int idSearchGame) {

		try (FileReader fileReader = new FileReader(filePathToGame);
			 BufferedReader bufferedRreader = new BufferedReader(fileReader)
		) {
			String gameRoundScore = null;
			
			while ( (gameRoundScore = bufferedRreader.readLine()) != null) {
				
				RoundGame roundGame = extractRoundGame(gameRoundScore);
				
				if (idSearchGame == roundGame.getId()) {
					
					return roundGame;
				}
			}
		} catch (IOException iOExcept) {
			throw new RuntimeException(iOExcept);
		}
		
		return null;
	}

	private String toString(int[] gameRolls) {
		StringBuilder gameResult = new StringBuilder();
		
		for (int number : gameRolls) {
			gameResult.append(number);
			gameResult.append(",");
		}
		return gameResult.toString();
	}

	private int[] extractItems(String gameAsString) {
		
		String[] gameRoundResult = gameAsString.split(",");
		int[] itemsTable = new int[gameRoundResult.length];
		
		for (int i = 0; i < gameRoundResult.length; i++) {
			itemsTable[i] = Integer.parseInt(gameRoundResult[i]);
		}
		
		return itemsTable;
	}
	
	private static class RoundGame {
		private final int id;
		private final int[] rolls;
		
		public RoundGame(int id, int[] rolls) {
			this.id = id;
			this.rolls = rolls;
		}

		public int getId() {
			return id;
		}

		public int[] getRolls() {
			return rolls;
		}
	}
}