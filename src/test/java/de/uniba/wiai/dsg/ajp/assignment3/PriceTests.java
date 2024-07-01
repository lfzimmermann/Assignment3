package de.uniba.wiai.dsg.ajp.assignment3;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PriceTests {

	@BeforeAll
	static void setUpBeforeClass(TestInfo testInfo) throws Exception {
		System.out.println("[BA] starting test suite: " + testInfo.getDisplayName());
	}

	@AfterEach
	void tearDown(TestInfo testInfo) {
		System.out.println("[AE] finished test " + testInfo.getDisplayName());
	}

	@AfterAll
	static void tearDownAfterClass(TestInfo testInfo) throws Exception {
		System.out.println("[AA] finished test suite: " + testInfo.getDisplayName() + "\n");
	}



	@ParameterizedTest
	@ValueSource(ints = {1, 3, 5, 7})
	void getFrequentRenterPointsTest(int daysRented) {
		Price p = new PriceMock();
		assertEquals(1, p.getFrequentRenterPoints(daysRented));
	}
}