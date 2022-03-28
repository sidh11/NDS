package com.nds.dao;

import java.util.List;

import com.nds.bean.Publication;

public interface PublicationDao {
	//abstract method--find publication by id
	Publication findById(int id);
	//abstract method--find publication by name
	Publication findByName(String Pname);
	//abstract method--find all
	List<Publication> findAll();
	
	//abstract method--update publication information
	int update(Publication publication);
	//abstract method--update stock
	int updateStock(int pub_id, int stock);
	
	//abstract method--add publication
	int addPub(Publication publication);
	
	//abstract method--delete publication by id
	int delPubById(int id);
	//abstract method--delete publication by name
	int delPubByName(String Pname);
	
}
