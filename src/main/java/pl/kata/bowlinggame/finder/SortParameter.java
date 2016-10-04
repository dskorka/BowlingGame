package pl.kata.bowlinggame.finder;

public enum SortParameter {
	ID("id", 1),
	DATE("time_game", 3);
	
	String columnName;
	int columnNumber;
	
	private SortParameter(String columnName, int columnNumber){
		this.columnName = columnName;
		this.columnNumber = columnNumber;
	}
	
	public String getColumnName(){
		return columnName;
	}
	
	public int getColumnNumber(){
		return columnNumber;
	}
	
	public static int getColumnNumber(String tag){
		if(tag == null){
			return ID.columnNumber;
		}
		for(SortParameter sort: SortParameter.values()){
			if(sort.getColumnName().equals(tag)){
				return sort.getColumnNumber();
			}
		}
		throw new RuntimeException("nie mozna sortowac po tym parametrze");
	}
	
}
