package pl.kata.bowlinggame.repository;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Test;

public class SetSortParameterTest {

	@Test
	public void should_get_id_column() {
		// given
		String searchTable = "id";
		// when
		int numberColumn = SortGameViewModelByColumnParameter.getColumnNumber(searchTable);
		//then
		Assert.assertEquals(1, numberColumn);
	}
	
	@Test
	public void should_not_find_uncorect_column_name(){
		// given
		String searchTable = "uncorectName";
		// when
		try{
			SortGameViewModelByColumnParameter.getColumnNumber(searchTable);
			fail();
		} catch (RuntimeException ex){
			// then
			Assert.assertEquals("nie mozna sortowac po wskazanym parametrze", ex.getMessage());
			assertTrue(true);
		}
	}
}
