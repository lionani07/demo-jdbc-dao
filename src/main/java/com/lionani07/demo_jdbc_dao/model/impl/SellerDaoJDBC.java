package com.lionani07.demo_jdbc_dao.model.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.lionani07.demo_jdbc_dao.db.DBException;
import com.lionani07.demo_jdbc_dao.model.dao.SellerDao;
import com.lionani07.demo_jdbc_dao.model.entities.Department;
import com.lionani07.demo_jdbc_dao.model.entities.Seller;

public class SellerDaoJDBC implements SellerDao {
	
	private Connection con;
	private PreparedStatement pst;
	private String sql;
	private ResultSet rs;
	
	public SellerDaoJDBC(Connection con) {
		this.con = con;
	}

	@Override
	public void insert(Seller seller) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Seller seller) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Seller findById(Integer id) {
		sql = "SELECT seller.*, department.Name AS depName "
				+ "FROM seller INNER JOIN department "
				+ "ON seller.DepartmentId = department.Id "
				+" WHERE seller.Id = ?";
		try {
			pst = this.con.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			
			if(rs.next()) {
				Department department = new Department(rs.getInt("DepartmentId"), rs.getString("depName"));
				Seller seller = new Seller();
				seller.setId(id);
				seller.setName(rs.getString("Name"));
				seller.setEmail(rs.getString("Email"));
				seller.setBirthDate(rs.getDate("BirthDate"));
				seller.setBaseSalary(rs.getDouble("BaseSalary"));
				seller.setDepartment(department);
				return seller;
			}
			
		} catch (SQLException e) {
			throw new DBException(e.getMessage());
		}
		
		return null;
	}

	@Override
	public List<Seller> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
