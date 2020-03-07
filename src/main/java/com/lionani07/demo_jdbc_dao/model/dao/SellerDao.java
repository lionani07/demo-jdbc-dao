package com.lionani07.demo_jdbc_dao.model.dao;

import java.util.List;

import com.lionani07.demo_jdbc_dao.model.entities.Seller;

public interface SellerDao {
	
	void insert(Seller seller);
	void delete(Integer id);
	void update(Seller seller);
	Seller findById(Integer id);
	List<Seller> findAll();

}
