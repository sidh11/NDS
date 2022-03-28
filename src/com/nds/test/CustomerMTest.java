package com.nds.test;

import com.nds.bean.Customer;
import com.nds.dao.impl.CustomerDaoImpl;
import junit.framework.Assert;
import junit.framework.TestCase;

public class CustomerMTest extends TestCase {

	CustomerDaoImpl cm = new CustomerDaoImpl();
	
	// Test case id: 1
	// Test case objective:add customer details
	// Test case input:"John","Wick","25,Heather View",0897654563
	// Test case Excepted output:true
	public void testAddCustomer() {
		boolean flag = true;
		Customer cd1 = new Customer(0, "John","Wick","25,Heather View","0897654563");
		if(cm.AddCustomer(cd1)!=1) {
			flag = false;
		}
		Assert.assertEquals(true, flag);
	}

	public void testViewCustomer() {
		fail("Not yet implemented"); // TODO
	}

	//Test case id:2
	//Test case Objective: delete customer details
	//Test case input:"id"
	//Test case Expected output:true
	public void testDeleteCustomer() {
		boolean flag = true;
		int id = 0;
		if(cm.DeleteCustomer(id)!=1) {
			flag = false;
		}
		Assert.assertEquals(true, flag);
	}

	//Test case id:3
	//Test case Objective: modify customer details
	//Test case input:"id"
	//Test case Expected output:true
	public void testModifyCustomer() {
		Customer cd1 = new Customer(0, "John","Wick","25,Heather View","0897654563");
		int count = cm.ModifyCustomer(cd1);
		Assert.assertEquals(1, count);
	}

}
