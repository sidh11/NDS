package com.nds.test;
import com.nds.bean.*;
import com.nds.dao.impl.*;
import junit.framework.*;

import org.junit.jupiter.api.Test;

public class DeliveryDaoImplTest extends TestCase {
	DeliveryDaoImpl d = new DeliveryDaoImpl();
	//Test case id:1
	//Test case objective:get DeliveryPerson info by id
	//Test case input:1
	//Test case expected output: DeliveryPerson[dpid=1, dpName=Steven, dpContactNumber=880254111]

	@Test
	public void testFindById_001() {
		Delivery d1 = d.findById(1);
		String expected = "DeliveryPerson[dpid=1, dpName=Steven, dpContactNumber=880254111]";
		assertEquals(expected, d1.toString());
	}
	//Test case id:2
	//Test case objective:get DeliveryPerson info by Name
	//Test case input:"Steven"
	//Test case expected output: DeliveryPerson[dpid=1, dpName=Steven, dpContactNumber=880254111]

	@SuppressWarnings("deprecation")
	@Test
	public void testFindByName_002() {
		Delivery d1 = d.findByName("Steven");
		String expected = "DeliveryPerson[dpid=1, dpContactNumber=880254111]";
		Assert.assertEquals(expected, d1.toString());
	}
	//Test case id:3
	//Test case objective:test function for adding,findAll,delete by Id or Name
	//Test case input:"1, steven , 880245111"
	//Test case expected output: true

	@SuppressWarnings("deprecation")
	@Test
	public void testAll_003() {
		boolean flag = true;
		@SuppressWarnings("unused")
		int count;
		Delivery d1 = new Delivery(1,"setven",880245111);
		
		if(d.addDP(d1)!=1) {
			flag=false;
		}
		if(d.delDPById(1)!=1) {
			flag=false;
		}
		if(d.addDP(d1)!=1) {
			flag=false;
		}
		if(d.delDPByName("Steven")!=1){
			flag=false;
		}
		Assert.assertEquals(true, flag);
	}
	//Test case id:4
		//Test case objective:update DeliveryPerson info by id
		//Test case input:"Steven"
		//Test case expected output: DeliveryPerson[dpid=1, dpName=Steven, dpContactNumber=880254111]

		@SuppressWarnings("deprecation")
		@Test
		public void testUpdate004() {
			Delivery d1 = new Delivery(2,"thomas",894911443);			int count = d.update(d1);
			Assert.assertEquals(1, count);
		}
	
	
	
	
	
}
