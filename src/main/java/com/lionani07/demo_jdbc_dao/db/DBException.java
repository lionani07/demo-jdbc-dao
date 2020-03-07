package com.lionani07.demo_jdbc_dao.db;

public class DBException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public DBException(String msg) {
		super(msg);
	}

}
