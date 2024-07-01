package de.uniba.wiai.dsg.ajp.assignment3;

/**
 * Represents a regular movie rental price.
 *
 * <p>
 * 		This class extends the {@link Price} abstract class and provides an
 * 		implementation for calculating the rental charge and retrieving the price code for
 * 		regular movies.
 * </p>
 */
public class RegularPrice extends Price {

	/**
	 * Calculates the rental charge for a regular movie based on the number of days
	 * rented.
	 *
	 * <p>
	 * The charge is a flat fee of 2 for the first 2 days and an additional 1.5 per
	 * day for each additional day.
	 * </p>
	 *
	 * @param daysRented the number of days the movie was rented
	 * @return the rental charge
	 */
	@Override
	double getCharge(int daysRented) {
		double result = 2;
		if (daysRented > 2) {
			result += (daysRented - 2) * 1.5;
		}
		return result;
	}

	@Override
	int getPriceCode() {
		return Movie.REGULAR;
	}

}
