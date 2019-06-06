package com.soctest.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Paciente {

	public static Connection getConnection() throws Exception {
		try {
			// Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver.class");
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			return(DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;databaseName=soctest","sa","bd123"));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}		
	
	public ResultSet listar() throws SQLException, Exception {
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM dbo.paciente";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			rs = ps.executeQuery();
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (getConnection() != null) {
				getConnection().close();
			}
		}
	}
	
	public ResultSet consultar(int id) throws SQLException, Exception {
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM dbo.paciente WHERE id = " + id;
			PreparedStatement ps = getConnection().prepareStatement(sql);
			rs = ps.executeQuery();
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (getConnection() != null) {
				getConnection().close();
			}
		}
	}
	
}
