package com.nds.test;

import java.util.List;

import com.nds.bean.Publication;
import com.nds.dao.impl.PublicationDaoImpl;

import junit.framework.Assert;
import junit.framework.TestCase;

public class PublicationDaoImplTest extends TestCase {

	PublicationDaoImpl p = new PublicationDaoImpl();

	// Test case id: 1
	// Test case objective:get publication info by id
	// Test case input: 1
	// Test case Excepted output:Publication [pub_id=1, Pname=times_of_India,
	// numOfStock=15, price=5]
	public void testFindById_001() {
		Publication p1 = p.findById(1);
		String excepted = "Publication [pub_id=1, Pname=times_of_India, numOfStock=15, price=5]";
		Assert.assertEquals(excepted, p1.toString());
	}

	// Test case id: 2
	// Test case objective:get publication info by name
	// Test case input: "times_of_India"
	// Test case Excepted output:Publication [pub_id=1, Pname=times_of_India,
	// numOfStock=15, price=5]
	public void testFindByName_002() {
		Publication p1 = p.findByName("times_of_India");
		String excepted = "Publication [pub_id=1, Pname=times_of_India, numOfStock=15, price=5]";
		Assert.assertEquals(excepted, p1.toString());
	}

	//Test case id:3
	//Test case Objective: test function for adding,findAll,delete by Id or Name
	//Test case input:3, "National Geographic", 100, "4.5"
	//Test case Expected output:true
	public void testMix_003() {
		boolean flag = true;
		int count ;
		Publication p1 = new Publication(3, "National Geographic", 100, "4.5");
		 
		if(p.addPub(p1)!=1) {
			flag = false;
		}
		if(p.delPubById(3)!=1) {
			flag=false;
		}
		if(p.addPub(p1)!=1) {
			flag = false;
		}
		if(p.delPubByName("National Geographic")!=1) {
			flag = false;
		}
		List<Publication> list = p.findAll();
		if(list.size()!=2) {
			flag = false;
		}
		Assert.assertEquals(true, flag);
		
	}
	
	
	
	

	// Test case id:4
	// Test case objective:update inform for publication by id
	// Test case input:2,"TIME",55,"4.5"
	// Test case Excepted output:1
	// When you test this, you need to comment test case 05
	public void testUpdate_004() {
		Publication p1 = new Publication(2, "TIME", 55, "4.5");
		int count = p.update(p1);
		Assert.assertEquals(1, count);

	}

	// Test case id:5
	// Test case objective:update stock of publication by id
	// Test case input:2, 60
	// Test case Excepted output:1
	// When you test this, you need to comment test case 04
	public void testUpdateStock_005() {
		int count = p.updateStock(2, 60);
		Assert.assertEquals(1, count);
	}

	
}
