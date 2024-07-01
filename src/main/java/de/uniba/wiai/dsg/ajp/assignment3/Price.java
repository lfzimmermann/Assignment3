package de.uniba.wiai.dsg.ajp.assignment3;

/**
 * Represents the pricing model for movie rentals.
 *
 * <p>
 * 		This abstract class serves as a base for different pricing strategies, such as
 * 		regular, new release, and children's movies. It defines a common method for
 * 		calculating frequent renter points, and provides an abstract
 * 		method for retrieving the price code and the overall charge.
 * </p>
 *
 * <p>
 * 		Concrete subclasses must implement the {@link #getCharge(int)} and
 * 		{@link #getPriceCode()} methods to define their specific pricing rules.
 * </p>
 */
public abstract class Price {

	abstract double getCharge(int daysRented);

	/**
	 * Calculates the frequent renter points earned for a rental based on the number
	 * of days rented.
	 *
	 * <p>
	 * 		This implementation provides a default behavior where one frequent renter
	 * 		point is earned per rental, regardless of the rental duration. Subclasses may
	 * 		override this method to implement different point-earning rules.
	 * </p>
	 *
	 * @param daysRented the number of days the movie was rented
	 * @return the number of frequent renter points earned
	 */
	int getFrequentRenterPoints(int daysRented) {
		return 1;
	}

	abstract int getPriceCode();

}
