package de.uniba.wiai.dsg.ajp.assignment3;

import org.junit.jupiter.api.*;

import static de.uniba.wiai.dsg.ajp.assignment3.Movie.REGULAR;
import static org.junit.jupiter.api.Assertions.*;

class RentalTest {
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
	void getAndSetMovie() {
		Rental rental = new Rental();
		Movie movie = new Movie("Stopper61", REGULAR);
		rental.setMovie(movie);
		assertEquals(movie, rental.getMovie());
	}

	@Test
	void getAndSetDaysRented() {
		Rental rental = new Rental();
		rental.setDaysRented(10);
		assertEquals(10, rental.getDaysRented());
	}

	@Test
	void getCharge() {
		Movie movie = new Movie("American Psycho", REGULAR);
		assertEquals(2, movie.getCharge(1));
	}

	@Test
	void getFrequentRenterPoints() {
		Movie movie = new Movie("The Wolf of Wallstreet", REGULAR);
		assertEquals(1, movie.getFrequentRenterPoints(1));
		assertEquals(1, movie.getFrequentRenterPoints(50));
	}
}