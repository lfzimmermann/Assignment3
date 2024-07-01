package de.uniba.wiai.dsg.ajp.assignment3;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class RegularPriceTest {
	RegularPrice rp = new RegularPrice();

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
		assertEquals(2,  rp.getCharge(1) );
		assertEquals(2,  rp.getCharge(2) );
		assertEquals(3.5,  rp.getCharge(3) );
	}

	@Test
	void getPriceCodeTest() {
		RegularPrice rp = new RegularPrice();
		assertEquals(0, rp.getPriceCode());
	}
}