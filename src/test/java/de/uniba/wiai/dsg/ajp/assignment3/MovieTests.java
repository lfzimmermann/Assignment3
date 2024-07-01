package de.uniba.wiai.dsg.ajp.assignment3;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class MovieTests {

	private Movie movieTest;

	@BeforeEach
	void setUp() {
		movieTest = new Movie("Test", 0);
	}

	@AfterEach
	void tearDown(TestInfo testInfo) {
		movieTest = null;
		System.out.println("[AE] finished test " + testInfo.getDisplayName());
	}

	@BeforeAll
	static void setUpBeforeClass(TestInfo testInfo) throws Exception {
		System.out.println("[BA] starting test suite: " + testInfo.getDisplayName());
	}

	@AfterAll
	static void tearDownAfterClass(TestInfo testInfo) throws Exception {
		System.out.println("[AA] finished test suite: " + testInfo.getDisplayName()  + "\n");
	}

	@Test
	public void getTitleTest() throws Exception {
		assertEquals("Test", movieTest.getTitle());
	}

	@Test
	public void setTitleTest() throws Exception {
		movieTest.setTitle("new title");
		assertEquals("new title", movieTest.getTitle());

		assertThrows(IllegalArgumentException.class, () -> movieTest.setTitle(""));
		assertThrows(IllegalArgumentException.class, () -> movieTest.setTitle(null));
	}

	@Test
	public void getPriceCodeTest() throws Exception {
		assertEquals(0, movieTest.getPriceCode());
	}

	@Test
	public void setPriceCodeTest() throws Exception {
		movieTest.setPriceCode(2);
		assertEquals(2, movieTest.getPriceCode());
	}

	@ParameterizedTest
	@ValueSource(ints = {0, 5, 10})
	public void getChargeTest(int daysRented) throws Exception {
		Movie movieRegular = new Movie("title", 0);
		Movie movieNewReleased = new Movie("title", 1);
		Movie movieChild = new Movie("title", 2);

		switch(daysRented){
			case 0:
				assertEquals(movieRegular.getCharge(daysRented), 2.0);
				assertEquals(movieChild.getCharge(daysRented), 1.5);
				break;
			case 5:
				assertEquals(movieRegular.getCharge(daysRented), 6.5);
				assertEquals(movieChild.getCharge(daysRented), 4.5);
				break;
			case 10:
				assertEquals(movieRegular.getCharge(daysRented), 14);
				assertEquals(movieChild.getCharge(daysRented), 12.0);
				break;

		}
		assertEquals(movieNewReleased.getCharge(daysRented), daysRented*3);
	}

	@ParameterizedTest
	@ValueSource(ints = {0, 5, 10})
	public void getFrequentRenterPointsTest(int daysRented) throws Exception {
		Movie movieRegular = new Movie("title", 0);
		Movie movieNewReleased = new Movie("title", 1);
		Movie movieChild = new Movie("title", 2);

		assertEquals(daysRented > 1 ? 2 : 1, movieNewReleased.getFrequentRenterPoints(daysRented));
		assertEquals(1, movieRegular.getFrequentRenterPoints(daysRented));
		assertEquals(1, movieChild.getFrequentRenterPoints(daysRented));
	}
}