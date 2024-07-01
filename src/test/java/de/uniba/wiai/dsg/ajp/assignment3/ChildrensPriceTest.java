package de.uniba.wiai.dsg.ajp.assignment3;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class ChildrensPriceTest {
	private ChildrensPrice cp = new ChildrensPrice();

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
	void getChargeTest() {
		assertEquals(1.5, cp.getCharge(3));
		assertEquals(3, cp.getCharge(4));
		assertEquals(4.5, cp.getCharge(5));
	}

	@Test
	void getPriceCodeTest() {
		assertEquals(Movie.CHILDRENS, cp.getPriceCode());
	}
}