package com.lionani07.demo_jdbc_dao;

import java.util.List;

import com.lionani07.demo_jdbc_dao.model.dao.DaoFactory;
import com.lionani07.demo_jdbc_dao.model.dao.SellerDao;
import com.lionani07.demo_jdbc_dao.model.entities.Department;
import com.lionani07.demo_jdbc_dao.model.entities.Seller;

public class App 
{
    public static void main( String[] args )
    {
    	System.out.println("Test ===FindById====");
    	SellerDao sellerDao = DaoFactory.createSellerDao();
    	Seller seller = sellerDao.findById(2);
    	System.out.println(seller);
    	
    	System.out.println("Test ===FindAllByDepartment====");
    	
    	List<Seller> sellers = sellerDao.findAllByDepartment(new Department(1, "teste"));
    	for(Seller s : sellers) {
    		System.out.println(s);
    	}
       
    }
}
