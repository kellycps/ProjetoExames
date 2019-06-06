package com.soctest.action;

import com.soctest.dao.Exame;
import com.soctest.bean.ExameBean;

import java.sql.Date;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

public class BuscarExame extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private int tipo_exame_id, paciente_id, medico_id, apto;
	private String data_inicio_realizacao, data_fim_realizacao, data_inicio_vencimento, data_fim_vencimento;
	private ArrayList<ExameBean> beanList;
	private Exame exame = new Exame();
	private ResultSet rs = null;
	private ExameBean bean = null;
	private boolean noData = false;

	@Override
	public String execute() throws Exception {
		try {
			beanList = new ArrayList<ExameBean>();

			DateTimeFormatter formatoBr = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			data_inicio_realizacao = formatoBr.format(LocalDate.parse(data_inicio_realizacao, formatoBr));
			data_fim_realizacao = formatoBr.format(LocalDate.parse(data_fim_realizacao, formatoBr));
			data_inicio_vencimento = formatoBr.format(LocalDate.parse(data_inicio_vencimento, formatoBr));
			data_fim_vencimento = formatoBr.format(LocalDate.parse(data_fim_vencimento, formatoBr));
			
			rs = exame.buscar(tipo_exame_id, paciente_id, medico_id, data_inicio_realizacao, data_fim_realizacao, data_inicio_vencimento, data_fim_vencimento, apto);
			int i = 0;
			if (rs != null) {
				while (rs.next()) {
					
					String data_realizacao = formatoBr.format(LocalDate.parse(rs.getString("data_realizacao"), formato));
					String data_vencimento = formatoBr.format(LocalDate.parse(rs.getString("data_vencimento"), formato));
					
					i++;
					bean = new ExameBean();
					bean.setId(rs.getInt("id"));
					bean.setTipo_exame_id(rs.getInt("tipo_exame_id"));
					bean.setPaciente_id(rs.getInt("paciente_id"));
					bean.setMedico_id(rs.getInt("medico_id"));
					bean.setData_realizacao(data_realizacao);
					bean.setData_vencimento(data_vencimento);
					bean.setApto(rs.getBoolean("apto"));
					beanList.add(bean);
				}
			}
			
			noData = i != 0;
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		return "SUCCESS";
	}

	public boolean isNoData() {
		return noData;
	}

	public void setNoData(boolean noData) {
		this.noData = noData;
	}
	
	public ArrayList<ExameBean> getBeanList() {
		return beanList;
	}

	public void setBeanList(ArrayList<ExameBean> beanList) {
		this.beanList = beanList;
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

	public int getApto() {
		return apto;
	}

	public void setApto(int apto) {
		this.apto = apto;
	}

	public String getData_inicio_realizacao() {
		return data_inicio_realizacao;
	}

	public void setData_inicio_realizacao(String data_inicio_realizacao) {
		this.data_inicio_realizacao = data_inicio_realizacao;
	}

	public String getData_fim_realizacao() {
		return data_fim_realizacao;
	}

	public void setData_fim_realizacao(String data_fim_realizacao) {
		this.data_fim_realizacao = data_fim_realizacao;
	}

	public String getData_inicio_vencimento() {
		return data_inicio_vencimento;
	}

	public void setData_inicio_vencimento(String data_inicio_vencimento) {
		this.data_inicio_vencimento = data_inicio_vencimento;
	}

	public String getData_fim_vencimento() {
		return data_fim_vencimento;
	}

	public void setData_fim_vencimento(String data_fim_vencimento) {
		this.data_fim_vencimento = data_fim_vencimento;
	}
	
}
