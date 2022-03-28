package com.nds.bean;
import java.io.Serializable;
public class Delivery implements Serializable {
	
	private int Dpid;
	private String Dpname;
	private int DpContactNo;
	public Delivery(int dpid, String dpname, int dpContactNo) {
		super();
		this.Dpid= dpid;
		this.Dpname=dpname;
		this.DpContactNo=dpContactNo;
		
		
		// TODO Auto-generated constructor stub
	}
     public Delivery() {
		// TODO Auto-generated constructor stub
	}
	public int getDpid() {
		return Dpid;
	}
	public void setDpid(int dpid) {
		this.Dpid = dpid;
	}
	public String getDpname() {
		return Dpname;
	}
	public void setDpname(String dpname) {
		this.Dpname = dpname;
	}
	public int getDpContactNo() {
		return DpContactNo;
	}
	public void setDpContactNo(int dpContactNo) {
		this.DpContactNo = dpContactNo;
	}
	
	public String toString() {
		
		return "Delivery[dp_id= "+ Dpid +" , dpname="+Dpname+",doContactNo="+DpContactNo+"]";
	}
	
	

}
