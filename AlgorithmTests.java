import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

public class AlgorithmTests {

	@Test
	public void testSet1() {
		int[] stockPrices = { 6, 8, 7, 3, 5, 4 };
		int[] days = { 1, 2, 4 };
		int[] expectedArr = { 4, 1, -1 };
		int[] result = Algorithm.examineStockPrices(stockPrices, days);
		assertTrue(Arrays.equals(expectedArr, result));
	}

	@Test
	public void testSet2() {
		int[] stockPrices = { 6, 5, 4, 3, 8, 1 };
		int[] days = { 2, 4, 5 };
		int[] expectedArr = { 3, 6, 6 };
		int[] result = Algorithm.examineStockPrices(stockPrices, days);
		assertTrue(Arrays.equals(expectedArr, result));
	}
}

