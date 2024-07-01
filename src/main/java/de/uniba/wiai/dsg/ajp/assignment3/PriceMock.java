package de.uniba.wiai.dsg.ajp.assignment3;

public class PriceMock extends Price{

	@Override
	double getCharge(int daysRented) {
		return 0; // Not implemented in this mock
	}

	@Override
	int getPriceCode() {
		return 0; // Not implemented in this mock
	}
}
