package com.nds.bean;

public class Customer {
	private String firstName;
	private String lastName;
	private String address;
	private String contactno;
	private int cusid;
	
	public Customer(int cusid, String firstName,String lastName,String address,String contactno) {
		// TODO Auto-generated constructor stub
		super();
		this.cusid = cusid;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.contactno = contactno;
	}

	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setContactno(String contactno) {
		this.contactno = contactno;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getContactno() {
		return contactno;
	}
	
	public int getCusid() {
		return cusid;
	}
	
	public int setCusid(int cusid) {
		return this.cusid = cusid;
	}
}
