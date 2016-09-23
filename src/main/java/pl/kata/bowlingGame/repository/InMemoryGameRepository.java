package pl.kata.bowlingGame.repository;

import java.util.HashMap;
import java.util.Map;

import pl.kata.bowlingGame.Game;


public class InMemoryGameRepository implements GameRepository {
	Map<Integer, String> gameRepository = new HashMap<Integer, String>();

	
	@Override
	public void save(Game game) {
		String gameAsString = toString(game);
		gameRepository.put(game.getId(), gameAsString);
	}
	
	@Override
	public Game load(int id) {
		String gameAsString = gameRepository.get(id);
		Game game = fromString(gameAsString);
		return game; 
	}
	
	private Game fromString(String gameAsString) {
		int [] numberTableRolls = convertStringToIntTable(gameAsString);
		int idGame = numberTableRolls[0]; 			
		return new Game(idGame, numberTableRolls);
	}
	

	private String toString(Game game) {
		StringBuilder gameString = new StringBuilder();
		int[] numbersRoll = game.getRolls();
		
		gameString.append(game.getId());
		for(int number: numbersRoll){
			gameString.append(",");
			gameString.append(number);	
		}
		return gameString.toString();
	}

	private int[] convertStringToIntTable(String gameStringRollById) {
		String[] stringGameTable = gameStringRollById.split(",");
		int[] numbersTableRoll = new int[stringGameTable.length];
		for (int i = 0; i < stringGameTable.length; i++) {
			numbersTableRoll[i] = Integer.parseInt(stringGameTable[i]);
		}
		return numbersTableRoll;
	}
}