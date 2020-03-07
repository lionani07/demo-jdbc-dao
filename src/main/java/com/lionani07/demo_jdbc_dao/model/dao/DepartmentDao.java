package com.lionani07.demo_jdbc_dao.model.dao;

import java.util.List;

import com.lionani07.demo_jdbc_dao.model.entities.Department;
import com.lionani07.demo_jdbc_dao.model.entities.Seller;

public interface DepartmentDao {
	
	void insert(Department seller);
	void delete(Integer id);
	void update(Department seller);
	Seller findById(Integer id);
	List<Department> findAll();

}
