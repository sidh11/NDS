package com.nds.test;
import junit.framework.TestCase;

public class LoginTest extends TestCase {
	
	
		// Test One : All fields are empty.
		// Objective: Invalid Boundary Value : "" "".
		// Expected Output : false
	public void test01() {
		LogInValidate vs = new LogInValidate();
		assertEquals(false, vs.validate("", ""));
	}

		// Test two : All fields are not empty.
		// Objective: valid Boundary Value : "Sam" "Pune".
		// Expected Output : true
	public void test02() {
		LogInValidate vs = new LogInValidate();
		assertEquals(true,vs.validate("Sam", "Pune"));
	}
	
		// Test three : All fields are not in range.
		// Objective: invalid Boundary Value : "SamS" "Assm".
		// Expected Output : false
	public void test03() {
		LogInValidate vs = new LogInValidate();
		assertEquals(false, vs.ValidateV("SamS", "Assm"));
	}
	
		// Test four : All fields are in range .
		// Objective: valid in lower Boundary Value : "SamShirish" "AssamPune".
		// Expected Output : true
	public void test04() {
		LogInValidate vs = new LogInValidate();
		assertEquals(true, vs.ValidateV("SamShirish", "AssamPune"));
		
		// Test five : All fields are out of range.
		// Objective: valid in middle Boundary Value : "SamShirishMeshramkar" "AssamPuneIreland".
		// Expected Output : true
	}
	public void test05() {
		LogInValidate vs = new LogInValidate();
		assertEquals(false, vs.ValidateV("SamShirishMeshramkar", "AssamPuneIreland"));
		
	}
	
}
