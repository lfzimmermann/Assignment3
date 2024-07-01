package de.uniba.wiai.dsg.ajp.assignment3;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class NewReleasePriceTest {

	private static NewReleasePrice nrp = new NewReleasePrice();;

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

	@Test
	void getChargeTest() {
		assertEquals(15, nrp.getCharge(5));
	}

	@Test
	void getFrequentRenterPointsTest() {
		assertEquals(2, nrp.getFrequentRenterPoints(5));
		assertEquals(1, nrp.getFrequentRenterPoints(0));

	}

	@Test
	void getPriceCodeTest() {
		assertEquals(nrp.getPriceCode(), Movie.NEW_RELEASE);
	}
}