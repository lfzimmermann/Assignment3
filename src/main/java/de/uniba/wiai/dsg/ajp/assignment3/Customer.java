package de.uniba.wiai.dsg.ajp.assignment3;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * Represents a customer who rents movies.
 *
 * <p>
 * 		A customer is identified by their name and maintains a list of their movie
 * 		rentals.
 * </p>
 */
public class Customer {

	private String name;

	private List<Rental> rentals = new LinkedList<Rental>();

	/**
	 * Constructs a new customer with the specified name.
	 *
	 * @param name the name of the customer
	 * @throws IllegalArgumentException if the name is null or empty
	 */
	public Customer(String name) {
		super();
		if (name != null && !name.isEmpty()){
			this.name = name;
			return;
		}
		throw new IllegalArgumentException("Invalid Customer name!");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name != null && !name.isEmpty()){
			this.name = name;
			return;
		}
		throw new IllegalArgumentException("Invalid Customer name!");
	}

	public List<Rental> getRentals() {
		return rentals;
	}

	public void setRentals(List<Rental> rentals) {
		if (rentals != null && rentals.stream().noneMatch(Objects::isNull)) {
			if (rentals.isEmpty()){
				throw new IllegalArgumentException("Invalid Customer rentals!");
			}

			this.rentals = rentals;
			return;
		}
		throw new IllegalArgumentException("Invalid Customer rentals!");

	}

	/**
	 * Generates a plain text statement of the customer's rentals and total charges.
	 *
	 * <p>
	 * 		The statement includes the movie title and charge for each rental, as well as
	 * 		the total amount owed and the total frequent renter points earned.
	 * </p>
	 *
	 * @return the rental statement as a string
	 */
	public String statement() {
		String result = "Rental Record for " + getName() + "\n";

		for (Rental each : this.rentals) {
			if (each != null) {
				// show figures for this rental
				result += "\t" + each.getMovie().getTitle() + "\t"
						+ String.valueOf(each.getCharge()) + "\n";
			}
		}

		// add footer lines
		result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
		result += "You earned " + String.valueOf(getTotalFrequentRenterPoints())
				+ " frequent renter points";
		return result;
	}

	/**
	 * Generates an HTML statement of the customer's rentals and total charges.
	 *
	 * <p>
	 * 		The statement includes the movie title and charge for each rental, as well as
	 * 		the total amount owed and the total frequent renter points earned.
	 * </p>
	 *
	 * @return the rental statement as an HTML string
	 */
	public String htmlStatement() {
		String result = "<h1>Rentals for <em>" + getName() + "</em></h1>\n<p>";

		for (Rental each : this.rentals) {
			if (each != null) {
				// show figures for each rental
				result += each.getMovie().getTitle() + ": "
						+ String.valueOf(each.getCharge()) + "<br>\n";
			}
		}

		result += "</p>\n";

		// add footer lines
		result += "<p>You owe <em>" + String.valueOf(getTotalCharge())
				+ "</em></p>\n";
		result += "<p>On this rental you earned <em>"
				+ String.valueOf(getTotalFrequentRenterPoints())
				+ "</em> frequent renter points</p>";
		return result;
	}

	double getTotalCharge() {
		double result = 0;

		for (Rental each : rentals) {
			if (each != null) {
				result += each.getCharge();
			}
		}

		return result;
	}

	int getTotalFrequentRenterPoints() {
		int result = 0;

		for (Rental each : rentals) {
			if (each != null) {
				result += each.getFrequentRenterPoints();
			}
		}

		return result;
	}

}
