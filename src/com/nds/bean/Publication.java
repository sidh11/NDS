package com.nds.bean;

import java.io.Serializable;

/**
 * 
 * @author Siddharth Patel
 *
 *	Publication Entity class
 */
public class Publication implements Serializable{
	
	private int pub_id;
	private String Pname;
	private int numOfStock;
	private String price;
	
	public Publication() {
		super();
		// TODO Auto-generated constructor stub
		
	}
	
	public Publication(int pub_id, String pname, int numOfStock, String price) {
		super();
		this.pub_id = pub_id;
		Pname = pname;
		this.numOfStock = numOfStock;
		this.price = price;
	}



	/*
	 * getter and setter
	 */
	public int getPub_id() {
		return pub_id;
	}

	public void setPub_id(int pub_id) {
		this.pub_id = pub_id;
	}

	public String getPname() {
		return Pname;
	}
	public void setPname(String pname) {
		Pname = pname;
	}
	public int getNumOfStock() {
		return numOfStock;
	}
	public void setNumOfStock(int numOfStock) {
		this.numOfStock = numOfStock;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Publication [pub_id=" + pub_id + ", Pname=" + Pname + ", numOfStock=" + numOfStock + ", price=" + price
				+ "]";
	}

}
