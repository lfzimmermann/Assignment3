package de.uniba.wiai.dsg.ajp.assignment3;

/**
 * Represents a movie available for rental.
 *
 * <p>
 * 		A movie is identified by its title and has a pricing category, which determines
 * 		the rental charge and frequent renter points earned.
 * </p>
 */
public class Movie {

	public static final int REGULAR = 0;
	public static final int NEW_RELEASE = 1;
	public static final int CHILDRENS = 2;

	private Price price;

	private String title;

	/**
	 * Constructs a new movie with the specified title and price code.
	 *
	 * @param title      the title of the movie
	 * @param priceCode  the price code of the movie, which determines its rental
	 *                   charge and frequent renter points
	 * @throws IllegalArgumentException if the title is null or empty)
	 */
	public Movie(String title, int priceCode) {
		if (title != null && !title.isEmpty()) {
			this.title = title;
			this.setPriceCode(priceCode);
			return;
		}
		throw new IllegalArgumentException("Invalid movie title");
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		if (title != null && !title.isEmpty()) {
			this.title = title;
			return;
		}
		throw new IllegalArgumentException("Invalid movie title");
	}

	/**
	 * Calculates the charge for renting this movie for the specified number of days.
	 *
	 * <p>
	 * 		The charge is determined by the movie's {@link Price} object, which
	 * 		encapsulates the specific pricing logic for its category.
	 * </p>
	 *
	 * @param daysRented the number of days the movie is rented
	 * @return the rental charge
	 */
	double getCharge(int daysRented) {
		return price.getCharge(daysRented);
	}

	public int getPriceCode() {
		return price.getPriceCode();
	}

	/**
	 * Sets the price code for this movie, which determines its pricing category.
	 *
	 * <p>
	 * 		Valid price codes are:
	 * </p>
	 * 		<ul>
	 * 		<li>{@link #REGULAR}</li>
	 * 		<li>{@link #CHILDRENS}</li>
	 * 		<li>{@link #NEW_RELEASE}</li>
	 * 		</ul>
	 *
	 * <p>
	 * 		This method updates the movie's {@link Price} object to reflect the new price
	 * 		code.
	 * </p>
	 *
	 * @param priceCode the new price code for the movie
	 * @throws IllegalArgumentException if the price code is invalid
	 */
	public void setPriceCode(int priceCode) {
		switch (priceCode) {
		case REGULAR:
			price = new RegularPrice();
			break;
		case CHILDRENS:
			price = new ChildrensPrice();
			break;
		case NEW_RELEASE:
			price = new NewReleasePrice();
			break;
		default:
			throw new IllegalArgumentException("Incorrect Price Code");
		}
	}

	/**
	 * Calculates the frequent renter points earned for renting this movie for the
	 * specified number of days.
	 *
	 * <p>
	 * 		The points are determined by the movie's {@link Price} object, which
	 * 		encapsulates the specific point-earning logic for its category.
	 * </p>
	 *
	 * @param daysRented the number of days the movie is rented
	 * @return the number of frequent renter points earned
	 */
	public int getFrequentRenterPoints(int daysRented) {
		return price.getFrequentRenterPoints(daysRented);
	}

}
