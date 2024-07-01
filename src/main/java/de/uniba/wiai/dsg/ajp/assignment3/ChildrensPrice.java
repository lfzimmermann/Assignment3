package de.uniba.wiai.dsg.ajp.assignment3;

/**
 * Represents the pricing model for children's movie rentals.
 *
 * <p>
 * 		This class extends the {@link Price} abstract class and provides an
 * 		implementation for calculating the rental charge for children's movies.
 * </p>
 */
public class ChildrensPrice extends Price {

	/**
	 * Calculates the rental charge for a children's movie based on the number of
	 * days rented.
	 *
	 * <p>
	 * 		The charge is a flat fee of 1.5 for the first 3 days and an additional 1.5
	 * 		per day for each additional day.
	 * </p>
	 *
	 * @param daysRented the number of days the movie was rented
	 * @return the rental charge
	 */
	@Override
	double getCharge(int daysRented) {
		double result = 1.5;
		if (daysRented > 3) {
			result += (daysRented - 3) * 1.5;
		}
		return result;
	}

	@Override
	int getPriceCode() {
		return Movie.CHILDRENS;
	}

}
