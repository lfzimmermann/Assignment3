package de.uniba.wiai.dsg.ajp.assignment3;

/**
 * Represents the pricing model for new release movie rentals.
 *
 * <p>
 * 		This class extends the {@link Price} abstract class and provides an
 * 		implementation for calculating the rental charge and frequent renter points for
 * 		new release movies.
 * </p>
 */
public class NewReleasePrice extends Price{

	/**
	 * Calculates the rental charge for a new release movie based on the number of
	 * days rented.
	 *
	 * <p>
	 * 		The charge is a flat fee of 3 per day.
	 * </p>
	 *
	 * @param daysRented the number of days the movie was rented
	 * @return the rental charge
	 */
	@Override
	double getCharge(int daysRented) {
		return daysRented * 3;
	}

	/**
	 * Calculates the frequent renter points earned for a new release movie rental.
	 *
	 * <p>
	 * 		If the movie is rented for more than one day, two frequent renter points are
	 * 		earned, otherwise, one point is earned.
	 * </p>
	 *
	 * @param daysRented the number of days the movie was rented
	 * @return the number of frequent renter points earned
	 */
	@Override
	int getFrequentRenterPoints(int daysRented) {
		if(daysRented > 1) {
			return 2;
		} else {
			return 1;
		}
	}

	@Override
	int getPriceCode() {
		return Movie.NEW_RELEASE;
	}
	
}
