package de.uniba.wiai.dsg.ajp.assignment3;

import org.junit.jupiter.api.*;

import java.util.ArrayList;

import static de.uniba.wiai.dsg.ajp.assignment3.Movie.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CustomerTest {

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
	void getNameTest() {
		Customer customer = new Customer("Elias");
		assertEquals("Elias", customer.getName());
	}

	@Test
	void setName() {
		Customer customer = new Customer("Christian Bale");

		customer.setName("Brad Pitt");
		assertEquals("Brad Pitt", customer.getName());

		assertThrows(IllegalArgumentException.class,()->customer.setName(null));
		assertThrows(IllegalArgumentException.class,()->customer.setName(""));
	}

	@Test
	void getRentals() {
		ArrayList<Rental> rl = new ArrayList<>();
		Customer customer = new Customer("Jakob H");
		Rental mR = mock(Rental.class);

		rl.add(mR);
		customer.setRentals(rl);

		assertEquals(rl, customer.getRentals());
	}

	@Test
	void setRentals() {
		Customer customer = new Customer("Fabian S");
		ArrayList<Rental> rentals = new ArrayList<>();
		Rental mockRental = mock(Rental.class);

		rentals.add(mockRental);
		customer.setRentals(rentals);
		assertEquals(rentals,customer.getRentals());

		rentals.clear();
		assertThrows(IllegalArgumentException.class,()->customer.setRentals(null));
		assertThrows(IllegalArgumentException.class, ()->customer.setRentals(rentals));
	}

	@Test
	void statement() {
		Customer emptyCustomer = new Customer("Simon S");
		assertEquals(emptyCustomer.statement(), "Rental Record for Simon S\nAmount owed is 0.0\nYou earned 0 frequent renter points");

		Customer customer = new Customer("Tom S");
		Rental rental = new Rental();
		Movie movie = new Movie("My Neighbor Totoro", CHILDRENS);
		rental.setMovie(movie);
		rental.setDaysRented(5);
		ArrayList<Rental> rentalList = new ArrayList<>();

		for (int i = 0; i < 5; i++){
			rentalList.add(rental);
		}

		customer.setRentals(rentalList);

		assertEquals(customer.statement(), "Rental Record for Tom S\n\tMy Neighbor Totoro\t4.5\n\tMy Neighbor Totoro\t4.5\n\tMy Neighbor Totoro\t4.5\n\tMy Neighbor Totoro\t4.5\n\tMy Neighbor Totoro\t4.5\nAmount owed is 22.5\nYou earned 5 frequent renter points");
	}

	@Test
	void htmlStatement() {
		ArrayList<Rental> rentalList = new ArrayList<Rental>();
		Rental rental = new Rental();

		Customer emptyCustomer = new Customer("Linus S");
		assertEquals(emptyCustomer.htmlStatement(), """
<h1>Rentals for <em>Linus S</em></h1>
<p></p>
<p>You owe <em>0.0</em></p>
<p>On this rental you earned <em>0</em> frequent renter points</p>""");


		Customer customer = new Customer("Ellen M");
		Movie movie = new Movie("Spirited Away", Movie.REGULAR);
		rental.setMovie(movie);
		rental.setDaysRented(5);

		for (int i = 0; i < 5; i++){
			rentalList.add(rental);
		}

		customer.setRentals(rentalList);

		assertEquals(customer.htmlStatement(), """
<h1>Rentals for <em>Ellen M</em></h1>
<p>Spirited Away: 6.5<br>
Spirited Away: 6.5<br>
Spirited Away: 6.5<br>
Spirited Away: 6.5<br>
Spirited Away: 6.5<br>
</p>
<p>You owe <em>32.5</em></p>
<p>On this rental you earned <em>5</em> frequent renter points</p>""");
	}


}