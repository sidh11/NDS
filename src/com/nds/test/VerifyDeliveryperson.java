package com.nds.test;

public class VerifyDeliveryperson {
	public boolean ValidateFields(String dpid, String Dpname, String ContactNo) {
		return (dpid.equals("") || Dpname.equals("") || ContactNo.equals("") ? true : false);
	}

	public boolean ValidateId(String id) {
		String regex = "^[0-9]{1,2}$";
		return id.matches(regex);
	}

	public boolean ValidateName(String name) {
		String regex = "[a-zA-z ]{5,20}";
		return name.matches(regex);
	}

	public boolean ValidateNumber(String number) {
		String regex = "[0-9]{9,10}";
		return number.matches(regex);
	}

	public boolean CheckAllValidate(String id, String name, String number) {
		return (ValidateId(id) || ValidateName(name) || ValidateNumber(number));
	}

	public boolean ValidateFields(String text, String text2) {
		// TODO Auto-generated method stub
		return false;
	}

//	public boolean ValidateFields(String text) {
//		String regex = "[0-9]{1,1000}";
//		return text.matches(regex);
//		
//	}	

}
