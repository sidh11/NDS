package com.nds.test;

import junit.framework.TestCase;

import com.nds.gui.VerifyCustomerDetails;

public class VerifyCustomerDetailsTest extends TestCase {

	// Test case id: 1
	// Test case objective: verify first name is in range [a-zA-Z]{3,15}
	// Test case input (invalid lower boundary): Jr
	// Test case Excepted output: false
	public void testVerifyfirstName1() {
		assertEquals(false, VerifyCustomerDetails.verifyfirstName("Jr"));
	}
	
	// Test case id: 2
	// Test case objective: verify first name is in range [a-zA-Z]{3,15}
	// Test case input (valid lower boundary): Gem
	// Test case Excepted output: true
	public void testVerifyfirstName2() {
		assertEquals(true, VerifyCustomerDetails.verifyfirstName("Gem"));
	}
	
	// Test case id: 3
	// Test case objective: verify first name is in range [a-zA-Z]{3,15}
	// Test case input (invalid upper boundary): allocoprophagous
	// Test case Excepted output: false
	public void testVerifyfirstName3() {
		assertEquals(false, VerifyCustomerDetails.verifyfirstName("allocoprophagous"));
	}
	
	// Test case id: 4
	// Test case objective: verify first name is in range [a-zA-Z]{3,15}
	// Test case input (valid upper boundary): Gabrielmichael
	// Test case Excepted output: true
	public void testVerifyfirstName4() {
		assertEquals(true, VerifyCustomerDetails.verifyfirstName("Gabrielmichael"));
	}
	
	// Test case id: 5
	// Test case objective: verify last name is in range [a-zA-Z]{3,15}
	// Test case input (valid lower boundary): Fox
	// Test case Excepted output: true
	public void testVerifylastName1() {
		assertEquals(true, VerifyCustomerDetails.verifylastName("Fox"));
	}
	
	// Test case id: 6
	// Test case objective: verify last name is in range [a-zA-Z]{3,15}
	// Test case input (invalid lower boundary): Jo
	// Test case Excepted output: false
	public void testVerifylastName2() {
		assertEquals(false, VerifyCustomerDetails.verifylastName("Jo"));
	}
	
	// Test case id: 7
	// Test case objective: verify last name is in range [a-zA-Z]{3,15}
	// Test case input (invalid upper boundary): VANDROOGENBROECK
	// Test case Excepted output: false
	public void testVerifylastName3() {
		assertEquals(false, VerifyCustomerDetails.verifylastName("VANDROOGENBROECK"));
	}
	
	// Test case id: 8
	// Test case objective: verify last name is in range [a-zA-Z]{3,15}
	// Test case input (valid upper boundary): SCHWINGHAMMER
	// Test case Excepted output: true
	public void testVerifylastName4() {
		assertEquals(true, VerifyCustomerDetails.verifylastName("SCHWINGHAMMER"));
	}
	
	// Test case id: 9
	// Test case objective: verify address is in range [0-9a-zA-Z\\s+]{10,150}
	// Test case input: 25, HeatherView, Athlone
	// Test case Excepted output: true
	public void testVerifyAddress() {
		assertEquals(true, VerifyCustomerDetails.verifyAddress("25, HeatherView, Athlone"));
	}

	// Test case id: 9
	// Test case objective: verify contact no. is in range [0-9]{10}
	// Test case input: 0895432657
	// Test case Excepted output: true
	public void testVerifyContactno() {
		assertEquals(true, VerifyCustomerDetails.verifyContactno("0895432657"));
	}

}
