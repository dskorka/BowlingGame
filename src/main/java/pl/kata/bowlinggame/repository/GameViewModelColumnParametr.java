package pl.kata.bowlinggame.repository;

public enum SortGameViewModelByColumnParameter {
	
	ID(GameDbConst.ID, 1),
	DATE(GameDbConst.INSERT_TIME, 3);
	
	String columnName;
	int columnNumber;
	
	private SortGameViewModelByColumnParameter(String columnName, int columnNumber){
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
		for(SortGameViewModelByColumnParameter sort: SortGameViewModelByColumnParameter.values()){
			if(sort.getColumnName().equals(tag)){
				return sort.getColumnNumber();
			}
		}
		throw new RuntimeException("nie mozna sortowac po wskazanym parametrze");
	}
	
}
