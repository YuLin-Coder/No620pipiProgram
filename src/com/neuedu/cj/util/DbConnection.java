package com.neuedu.cj.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//��ȡ���ݿ�����
public class DbConnection {

	private String url="jdbc:mysql://127.0.0.1/mydata_cj";
	private String driver="com.mysql.jdbc.Driver";
	private String user="root";
	private String password="root";
	private Connection conn=null;
public	DbConnection(){
		try {
			Class.forName(driver);
			try {
				conn=DriverManager.getConnection(url, user, password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Connection getConnection(){
		return conn;
	}
	
}
