package pl.kata.bowlinggame.finder;

public enum SortParameter {

	ID(1),
	TIME_GAME(3);
	
	String columnName;
	int columnNumber;
	
	private SortParameter(int columnNumber){
		this.columnNumber = columnNumber;
	}
	
	public String getColumnName(){
		return columnName;
	}
	
	public int getColumnNumber(){
		return columnNumber;
	}
	

	
}
