package com.lionani07.demo_jdbc_dao;

import com.lionani07.demo_jdbc_dao.model.dao.DaoFactory;
import com.lionani07.demo_jdbc_dao.model.dao.SellerDao;
import com.lionani07.demo_jdbc_dao.model.entities.Seller;

public class App 
{
    public static void main( String[] args )
    {
    	SellerDao sellerDao = DaoFactory.createSellerDao();
    	Seller seller = sellerDao.findById(2);
    	System.out.println(seller);
       
    }
}
