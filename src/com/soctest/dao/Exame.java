package com.soctest.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Exame {

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

	public int inserir(int tipo_exame_id, int paciente_id, int medico_id, String data_realizacao, String data_vencimento, String observacao, Boolean apto) throws Exception {
		int i = 0;
		try {
			
			String sql = "INSERT INTO dbo.exame "
					+ "(tipo_exame_id, paciente_id, medico_id, data_realizacao, data_vencimento, observacao, apto) "
					+ "VALUES (?,?,?,?,?,?,?)";
			
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setInt(1, tipo_exame_id);
			ps.setInt(2, paciente_id);
			ps.setInt(3, medico_id);
			ps.setString(4, data_realizacao);
			ps.setString(5, data_vencimento);
			ps.setString(6, observacao);
			ps.setBoolean(7, apto);
			
			i = ps.executeUpdate();
			return i;
			
		} catch (Exception e) {
			
			e.printStackTrace();
			return i;
			
		} finally {
			
			if (getConnection() != null) {
				getConnection().close();
			}
			
		}
	}
	
	public ResultSet buscar(int tipo_exame_id, int paciente_id, int medico_id, String data_inicio_realizacao, String data_fim_realizacao, String data_inicio_vencimento, String data_fim_vencimento, int apto) throws SQLException, Exception {

		ResultSet rs = null;
		try {
			String sql = "SELECT id, tipo_exame_id, paciente_id, medico_id, data_realizacao, data_vencimento, apto "
							+ "FROM dbo.exame "
							+ "WHERE id > 0 ";
			
			if (tipo_exame_id != 0)
				sql += "AND tipo_exame_id = " + tipo_exame_id + " ";
			
			if (paciente_id != 0)
				sql += "AND paciente_id = " + paciente_id + " ";
			
			if (medico_id != 0)
				sql += "AND medico_id = " + medico_id + " ";

			if (!data_inicio_realizacao.isEmpty())
				sql += "AND data_realizacao >= " + data_inicio_realizacao + " ";
			
			if (!data_fim_realizacao.isEmpty())
				sql += "AND data_realizacao <= " + data_fim_realizacao + " ";
			
			if (!data_inicio_vencimento.isEmpty())
				sql += "AND data_vencimento >= " + data_inicio_vencimento + " ";
			
			if (!data_fim_vencimento.isEmpty())
				sql += "AND data_vencimento <= " + data_fim_vencimento + " ";
			
			sql += "AND apto = " + apto;
			
			PreparedStatement ps = getConnection().prepareStatement(sql);
			/*
			 * ps.setInt(1, tipo_exame_id);
			ps.setInt(2, paciente_id);
			ps.setInt(3, medico_id);
			ps.setString(4, data_inicio_realizacao);
			ps.setString(5, data_fim_realizacao);
			ps.setString(6, data_inicio_vencimento);
			ps.setString(7, data_fim_vencimento);
			ps.setInt(8, apto);
			*/
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
	
	public int deletar(int id) throws SQLException, Exception {
		getConnection().setAutoCommit(false);
		int i = 0;
		try {
			String sql = "DELETE FROM dbo.exame WHERE id = ?";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setInt(1, id);
			i = ps.executeUpdate();
			return i;
		} catch (Exception e) {
			e.printStackTrace();
			getConnection().rollback();
			return 0;
		} finally {
			if (getConnection() != null) {
				getConnection().close();
			}
		}
	}
	
	public ResultSet consultar(int id) throws SQLException, Exception {
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM dbo.exame WHERE id = ?";
			
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setInt(1, id);
			
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

	public int alterar(int id, int tipo_exame_id, int paciente_id, int medico_id, String data_realizacao, String data_vencimento, String observacao, Boolean apto)
			throws SQLException, Exception {
		getConnection().setAutoCommit(false);
		int i = 0;
		try {
			
			String sql = "UPDATE dbo.exame SET "
							+ "tipo_exame_id = ?, "
							+ "paciente_id = ?, "
							+ "medico_id = ?, "
							+ "data_realizacao = ?, "
							+ "data_vencimento = ?, "
							+ "observacao = ?, "
							+ "apto = ? "
							+ "WHERE id = ?";
			
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setInt(1, tipo_exame_id);
			ps.setInt(2, paciente_id);
			ps.setInt(3, medico_id);
			ps.setString(4, data_realizacao);
			ps.setString(5, data_vencimento);
			ps.setString(6, observacao);
			ps.setBoolean(7, apto);
			
			i = ps.executeUpdate();
			return i;
			
		} catch (Exception e) {
			
			e.printStackTrace();
			getConnection().rollback();
			return 0;
			
		} finally {
			
			if (getConnection() != null) {
				getConnection().close();
			}
			
		}
	}
	
}
