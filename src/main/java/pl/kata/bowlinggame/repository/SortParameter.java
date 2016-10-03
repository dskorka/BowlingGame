package pl.kata.bowlinggame.repository;

public enum SortParameter {
	ID(1),
	DATE(2);
	
	int columnNumber;
	
	private SortParameter(int columnNumber){
		this.columnNumber = columnNumber;
	}
	
	public int getName(){
		return columnNumber;
	}
	
}
