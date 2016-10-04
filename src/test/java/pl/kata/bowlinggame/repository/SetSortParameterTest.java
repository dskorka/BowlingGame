package pl.kata.bowlinggame.repository;

import org.junit.Assert;
import org.junit.Test;

public class SetSortParameterTest {

	@Test
	public void should_compare_parameter() {
		String searchTable = "id";
		int numberColumn = SortParameter.getColumnNumber(searchTable);

		Assert.assertEquals(1, numberColumn);
	}
}
