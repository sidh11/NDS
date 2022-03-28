package com.nds.dao;
import java.util.List;
import com.nds.bean.Delivery;
public interface DeliveryDao {

	Delivery findById(int dpid);
	Delivery findByName(String dpname);
	List<Delivery> findAll();
	int update(Delivery delivery);
	
	int addDP(Delivery delivery);
	int delDPById(int id);
	int delDPByName(String dpname);
	
}
