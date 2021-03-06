package com.lionani07.demo_jdbc_dao.model.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lionani07.demo_jdbc_dao.db.DB;
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
				Department department = instantiateDepartment(rs);
				Seller seller = instantiateSeller(rs, department);
				return seller;
			}
			
		} catch (SQLException e) {
			throw new DBException(e.getMessage());
		}finally {
			DB.closeResulset(rs);
			DB.closeStatement(pst);
		}
		
		return null;
	}

	private Seller instantiateSeller(ResultSet rs, Department department) throws SQLException {
		Seller seller = new Seller();
		seller.setId(rs.getInt("Id"));
		seller.setName(rs.getString("Name"));
		seller.setEmail(rs.getString("Email"));
		seller.setBirthDate(rs.getDate("BirthDate"));
		seller.setBaseSalary(rs.getDouble("BaseSalary"));
		seller.setDepartment(department);
		return seller;
	}

	private Department instantiateDepartment(ResultSet rs) throws SQLException {
		return new Department(rs.getInt("DepartmentId"), rs.getString("depName"));
	}

	@Override
	public List<Seller> findAll() {
		List<Seller> sellers = new ArrayList<>();
		sql = "SELECT seller.*, department.Name AS depName FROM seller "
			  + "INNER JOIN department " 
			  + "ON seller.DepartmentId = department.Id";
			 
		try {
			pst = con.prepareStatement(sql);			
			rs = pst.executeQuery();
			
			Map<Integer, Department> mapDep = new HashMap<>();
			while(rs.next()) {
				Department dep = mapDep.get(rs.getInt("DepartmentId"));
				if(dep==null) {
					dep = instantiateDepartment(rs);
					mapDep.put(dep.getId(), dep);
				}				
				sellers.add(instantiateSeller(rs, dep));
			}
		} catch (SQLException e) {
			throw new DBException(e.getMessage());
		}finally {
			DB.closeResulset(rs);
			DB.closeStatement(pst);
		}
		return sellers;
	}

	@Override
	public List<Seller> findAllByDepartment(Department department) {
		List<Seller> sellers = new ArrayList<>();
		sql = "SELECT seller.*, department.Name AS depName FROM seller "
			  + "INNER JOIN department " 
			  + "ON seller.DepartmentId = department.Id "
			  + "WHERE department.Id = ?";
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, department.getId());
			rs = pst.executeQuery();
			
			Department dep = null;			
			while(rs.next()) {
				if(dep==null) {
					dep = instantiateDepartment(rs);
				}
				sellers.add(instantiateSeller(rs, dep));
			}
		} catch (SQLException e) {
			throw new DBException(e.getMessage());
		}finally {
			DB.closeResulset(rs);
			DB.closeStatement(pst);
		}
		return sellers;
		
	}

}
