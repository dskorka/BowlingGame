package pl.kata.bowlinggame.finder;

public enum SortParameter {

	ID(1),
	TIME_GAME(3);
	
	int columnNumber;
	
	private SortParameter(int columnNumber){
		this.columnNumber = columnNumber;
	}
	
	public int getColumnNumber(){
		return columnNumber;
	}
}
