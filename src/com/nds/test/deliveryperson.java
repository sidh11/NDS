package com.nds.test;

import junit.framework.TestCase;

public class deliveryperson extends TestCase {

	VerifyDeliveryperson vd = new VerifyDeliveryperson();

	public void testEmptyCheck() {
		assertEquals(false, !vd.ValidateFields("", "", ""));
	}

	public void testNotEmpty() {
		assertEquals(true, !vd.ValidateFields("32", "svkj", "sdv"));
	}

	public void testone() {
		assertEquals(false, vd.CheckAllValidate("-1", "Viv", "12333"));
	}

	public void testtwo() {
		assertEquals(true, vd.CheckAllValidate("1", "abcde", "123456789"));
	}

	public void testthree() {
		assertEquals(true, vd.CheckAllValidate("12", "abcde m", "123456789"));
	}

	public void testfour() {
		assertEquals(true, vd.CheckAllValidate("1000", "siddharth Patelabcha", "1234567890"));
	}

	public void testfive() {
		assertEquals(false, vd.CheckAllValidate("10001", "siddharth Patelabchaslk", "123456789012"));
	}
	
	public void testsix() {
		assertEquals(false, vd.ValidateId("A11"));
	}
	
	public void testseven() {
		assertEquals(false, vd.ValidateName("Sidd! Patel"));
	}

	public void testeight() {
		assertEquals(false, vd.ValidateNumber("123456789dk"));
	}
}
