package com.lionani07.demo_jdbc_dao.model.dao;

import com.lionani07.demo_jdbc_dao.db.DB;
import com.lionani07.demo_jdbc_dao.model.impl.SellerDaoJDBC;

public class DaoFactory {
	
	public static SellerDao createSellerDao() {
		return new SellerDaoJDBC(DB.getConnection());
	}
	
	

}
