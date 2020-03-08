package com.lionani07.demo_jdbc_dao.model.dao;

import java.util.List;

import com.lionani07.demo_jdbc_dao.model.entities.Department;

public interface DepartmentDao {
	
	void insert(Department seller);
	void delete(Integer id);
	void update(Department seller);
	Department findById(Integer id);
	List<Department> findAll();

}
