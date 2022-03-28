package com.nds.gui;

public class VerifyCustomerDetails {

	public static boolean verifyfirstName(String fname) {
		String valfn="[a-zA-Z]{3,15}";
		return fname.matches(valfn);
	}
	
	public static boolean verifylastName(String lname) {
		String valln="[a-zA-Z]{3,15}";
		return lname.matches(valln);
	}
	
	public static boolean verifyAddress(String address) {
		//letters, numbers and spaces 
		String valadd="[0-9a-zA-Z\\s+]{10,150}";
		return address.matches(valadd);
	}
	
	public static boolean verifyContactno(String contactno) {
		// 10 digits phone number
		String valcn = "[0-9]{10}";
		return contactno.matches(valcn);
	}
}
