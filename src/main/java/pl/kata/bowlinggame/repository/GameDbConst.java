package pl.kata.bowlinggame.repository;

class GameDbConst {
	
	static final String TABLE_NAME = "game_rolls";

	static final String ID = "id";
	static final String FIRST_ROLL = "first_roll";
	static final String SECOND_ROLL = "second_roll";
	static final String THIRD_ROLL = "third_roll";
	static final String FOURTH_ROLL = "fourth_roll";
	static final String FIFTH_ROLL = "fifth_roll";
	static final String SIXTH_ROLL = "sixth_roll";
	static final String SEVENTH_ROLL = "seventh_roll";
	static final String EIGHTH_ROLL = "eighth_roll";
	static final String NINTH_ROLL = "ninth_roll";
	static final String TENTH_ROLL = "tenth_roll";
	static final String ELEVENTH_ROLL = "eleventh_roll";
	static final String TWELFTH_ROLL = "twelfth_roll";
	static final String THIRTEENTH_ROLL = "thirteenth_roll";
	static final String FOURTEENTH_ROLL = "fourteenth_roll";
	static final String FIFTEENTH_ROLL = "fifteenth_roll";
	static final String SIXTEENTH_ROLL = "sixteenth_roll";
	static final String SEVENTEENTH_ROLL = "seventeenth_roll";
	static final String EIGHTEENTH_ROLL = "eighteenth_roll";
	static final String NINETEENTH_ROLL = "nineteenth_roll";
	static final String TWENTYTH_ROLL = "twentyth_roll";
	static final String TWENTH_FIRST_ROLL = "twenty_first_roll";
	static final String SCORE = "score";
	static final String TIME_GAME = "time_game";

	
	static final String SAVE_GAME_SCORE = " insert into " + TABLE_NAME +
			" ( " + FIRST_ROLL + " , "
			+ SECOND_ROLL + " , " + THIRD_ROLL + " , " 
			+ FOURTH_ROLL + " , " + FIFTH_ROLL + " , " 
			+ SIXTH_ROLL + " , "  + SEVENTH_ROLL + " , " 
			+ EIGHTH_ROLL + " , " + NINTH_ROLL + " , " 
			+ TENTH_ROLL + " , " + ELEVENTH_ROLL + " , " 
			+ TWELFTH_ROLL + " , " + THIRTEENTH_ROLL + " , " 
			+ FOURTEENTH_ROLL + " , " + FIFTEENTH_ROLL + " , "
			+ SIXTEENTH_ROLL + " , " + SEVENTEENTH_ROLL + " , " 
			+ EIGHTEENTH_ROLL + " , " + NINETEENTH_ROLL + " , "
			+ TWENTYTH_ROLL + " , " + TWENTH_FIRST_ROLL + " , "
			+ SCORE + " , " + TIME_GAME +
			" ) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	
	static final String SEARCH_GAME_BY_ID = "select * from " 
			+ TABLE_NAME + " where " + ID + " = ?";

}
