package com.nds.test;

public class VerifyPublication {
	public boolean ValidateFields(String Pid, String Pname, String price, String stock) {

		return (Pid.equals("") || Pname.equals("") || price.equals("") || stock.equals("") ? true : false);

	}

	public boolean validateid(String id) {
		String regex = "^[0-9]{1,2}$";
		return id.matches(regex);
	}

	public boolean validatename(String pname) {
		String regex = "[a-zA-Z ]{5,20}";
		return pname.matches(regex);

	}

	public boolean validateprice(String price) {
		String regex = "[0-9]{1,10}";
		return price.matches(regex);
	}

	public boolean validateStock(String stock) {
		String regex = "[0-9]{1,10}";
		return stock.matches(regex);
	}

	public boolean CheckAllValidate(String id, String name, String price, String stock) {
		return (validateid(id) && validatename(name) && validateprice(price) && validateStock(stock));
	}
}
