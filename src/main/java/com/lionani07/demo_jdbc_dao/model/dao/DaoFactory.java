package com.lionani07.demo_jdbc_dao.model.dao;

import com.lionani07.demo_jdbc_dao.model.impl.SellerDaoJDBC;

public class DaoFactory {
	
	public SellerDao createSellerDao() {
		return new SellerDaoJDBC();
	}

}
