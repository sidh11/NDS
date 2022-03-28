package com.nds.test;

import junit.framework.TestCase;

public class SubscribeTest extends TestCase {

	SubscriptionValidate sv = new SubscriptionValidate();
	
//	Test Number: 1 
//	Test Objective: Checking Empty
//	Input(s): null
//	Expected Output(s): false
	
	public void testEmptyycheck() {
		assertEquals(false, !sv.ValSubfields("", "", "", ""));
	}
	
//	Test Number: 2 
//	Test Objective: Checking Not Empty
//	Input(s): 1,1,1,asd
//	Expected Output(s): true
	public void testNotEmpty() {
		assertEquals(true, !sv.ValSubfields("1", "1", "1", "asd"));
	}
	
//	Test Number: 3
//	Test Objective: Checking name in range
//	Input(s): 1,1,1,samarp
//	Expected Output(s): true
	public void testone() {
		assertEquals(true, sv.CheckAllValidate("1", "1", "1", "samarp"));
	}
	
//	Test Number: 4
//	Test Objective: Checking negative values
//	Input(s): -1,-1,-1,sam
//	Expected Output(s): false
	public void testtwo() {
		assertEquals(false, sv.CheckAllValidate("-1", "-1", "-1", "sam"));
	}
	
//	Test Number: 4
//	Test Objective: Checking negative values
//	Input(s): -1,-1,-1,sam
//	Expected Output(s): false
	
	public void test3() {
		assertEquals(true,sv.CheckAllValidate("500", "500", "500", "Samarpan is a musician"));
	}
	
//	Test Number: 5
//	Test Objective: Checking values range
//	Input(s): 1000 , 1000 ,  1000 , times of indiaforbes
//	Expected Output(s): true
	public void test4() {
		assertEquals(true,sv.CheckAllValidate("1000", "1000", "1000", "times of indiaforbes"));
	}
	
//	Test Number: 6
//	Test Objective: Checking exceeding values 
//	Input(s): 1001", "1001", "1001", "times of india forbes
//	Expected Output(s): false

	public void test5() {
		assertEquals(false,sv.CheckAllValidate("1001", "1001", "1001", "times of india forbes"));
	}
	
//	Test Number: 7
//	Test Objective: Checking Ascii charecters 
//	Input(s): !@, $%, &&, sid@
//	Expected Output(s): flase
	public void test6() {
		assertEquals(false,sv.CheckAllValidate("!@", "$%", "&&", "sid@"));
	}

}
