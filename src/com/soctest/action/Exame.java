package com.soctest.action;

import com.soctest.bean.TipoExameBean;
import com.soctest.bean.PacienteBean;
import com.soctest.bean.MedicoBean;

import com.soctest.dao.TipoExame;
import com.soctest.dao.Paciente;
import com.soctest.dao.Medico;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

public class Exame extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int tipo_exame_id;
	private int paciente_id;
	private int medico_id;
	private Boolean apto;
	private String data_realizacao;
	private String data_vencimento;
	private String avaliacao;
	private List<TipoExameBean> tipoExameList = new ArrayList<TipoExameBean>();
	private List<PacienteBean> pacienteList = new ArrayList<PacienteBean>();
	private List<MedicoBean> medicoList = new ArrayList<MedicoBean>();
	private TipoExameBean tipoExameBean = null;
	private PacienteBean pacienteBean = null;
	private MedicoBean medicoBean = null;
	
	public Exame() throws SQLException, Exception {
		
		TipoExame tipoExame = new TipoExame();
		ResultSet rs = tipoExame.listar();
		
		int i = 0;
		if (rs != null) {
			while (rs.next()) {
				i++;
				tipoExameBean = new TipoExameBean();
				tipoExameBean.setId(rs.getInt("id"));
				tipoExameBean.setNome(rs.getString("nome"));
				tipoExameList.add(tipoExameBean);
			}
		}
		
		Paciente paciente = new Paciente();
		rs = paciente.listar();
		
		i = 0;
		if (rs != null) {
			while (rs.next()) {
				i++;
				pacienteBean = new PacienteBean();
				pacienteBean.setId(rs.getInt("id"));
				pacienteBean.setNome(rs.getString("nome"));
				pacienteList.add(pacienteBean);
			}
		}
		
		Medico medico = new Medico();
		rs = medico.listar();
		
		i = 0;
		if (rs != null) {
			while (rs.next()) {
				i++;
				medicoBean = new MedicoBean();
				medicoBean.setId(rs.getInt("id"));
				medicoBean.setNome(rs.getString("nome"));
				medicoList.add(medicoBean);
			}
		}
		
	}
	
	public List<PacienteBean> getPacienteList() {
		return pacienteList;
	}

	public void setPacienteList(List<PacienteBean> pacienteList) {
		this.pacienteList = pacienteList;
	}

	public List<MedicoBean> getMedicoList() {
		return medicoList;
	}

	public void setMedicoList(List<MedicoBean> medicoList) {
		this.medicoList = medicoList;
	}
	
	public List<TipoExameBean> getTipoExameList() {
		return tipoExameList;
	}

	public void setTipoExameList(List<TipoExameBean> tipoExameList) {
		this.tipoExameList = tipoExameList;
	}

	public int getTipo_exame_id() {
		return tipo_exame_id;
	}
	
	public void setTipo_exame_id(int tipo_exame_id) {
		this.tipo_exame_id = tipo_exame_id;
	}
	
	public int getPaciente_id() {
		return paciente_id;
	}
	
	public void setPaciente_id(int paciente_id) {
		this.paciente_id = paciente_id;
	}
	
	public int getMedico_id() {
		return medico_id;
	}
	
	public void setMedico_id(int medico_id) {
		this.medico_id = medico_id;
	}
	
	public String getData_realizacao() {
		return data_realizacao;
	}
	
	public void setData_realizacao(String data_realizacao) {
		this.data_realizacao = data_realizacao;
	}
	
	public String getData_vencimento() {
		return data_vencimento;
	}
	
	public void setData_vencimento(String data_vencimento) {
		this.data_vencimento = data_vencimento;
	}
	
	public String getAvaliacao() {
		return avaliacao;
	}
	
	public void setAvaliacao(String avaliacao) {
		this.avaliacao = avaliacao;
	}

	public Boolean getApto() {
		return apto;
	}

	public void setApto(Boolean apto) {
		this.apto = apto;
	}
}
