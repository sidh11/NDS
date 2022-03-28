package com.nds.test;

import junit.framework.TestCase;

public class publicationtest extends TestCase {
	VerifyPublication vp = new VerifyPublication();
	public void testEmptyCheck() {
		assertEquals(false, !vp.ValidateFields("", "", "", ""));
	}

	public void testNotEmpty() {
		assertEquals(true, !vp.ValidateFields("32", "svkj", "123", "123"));
	}

	public void testone() {
		assertEquals(false, vp.CheckAllValidate("-1", "Viv", "1", "1"));
	}

	public void testtwo() {
		assertEquals(true, vp.CheckAllValidate("1", "abcde", "12345", "12345"));
	}

	public void testthree() {
		assertEquals(true, vp.CheckAllValidate("12", "abcde m", "123456789", "123456"));
	}

	public void testfour() {
		assertEquals(true, vp.CheckAllValidate("1000", "siddharth Patelabcha", "1234567890", "1234567890"));
	}

	public void testfive() {
		assertEquals(false, vp.CheckAllValidate("10001", "siddharth Patelabchaslk", "123456789012", "123456789012"));
	}
	
	public void testsix() {
		assertEquals(false, vp.validateid("A11"));
	}
	
	public void testseven() {
		assertEquals(false, vp.validatename("Sidd! Patel"));
	}

	public void testeight() {
		assertEquals(false, vp.validateprice("123456789dk"));
	}
	public void testnine() {
		assertEquals(false, vp.validateStock("123456789012"));
	}


}
