package de.uniba.wiai.dsg.ajp.assignment3;
/**
 * 	The rental class represents a customer renting a movie.
 *
 * 	<p>
 * 		Represents how long and what movie is being rented.
 * 	</p>
 */
public class Rental {

	private int daysRented;
	private Movie movie;

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		if (movie != null) {
			this.movie = movie;
			return;
		}
		throw new IllegalArgumentException("movie is null");
	}

	public int getDaysRented() {
		return daysRented;
	}

	public void setDaysRented(int daysRented) {
		if (daysRented >= 0){
			this.daysRented = daysRented;
			return;
		}
		throw new IllegalArgumentException("daysRented is negative");
	}

	public double getCharge() {
		return movie.getCharge(daysRented);
	}

	/**
	 * Calculates the frequent renter points earned for this rental based on the
	 * movie's pricing category and the rental duration.
	 *
	 * @return the number of frequent renter points earned
	 */
	public int getFrequentRenterPoints() {
		return movie.getFrequentRenterPoints(daysRented);
	}

}
