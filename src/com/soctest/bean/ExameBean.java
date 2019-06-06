package com.soctest.bean;

public class ExameBean {

	private int id, paciente_id, medico_id, tipo_exame_id;
	private String data_realizacao, data_vencimento, observacao, ds_apto;
	private Boolean apto;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
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
	
	public int getTipo_exame_id() {
		return tipo_exame_id;
	}
	
	public void setTipo_exame_id(int tipo_exame_id) {
		this.tipo_exame_id = tipo_exame_id;
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
	
	public String getObservacao() {
		return observacao;
	}
	
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
	public Boolean getApto() {
		return apto;
	}
	
	public void setApto(Boolean apto) {
		this.setDs_apto(apto ? "Sim" : "Não");
		this.apto = apto;
	}

	public String getDs_apto() {
		return ds_apto;
	}

	public void setDs_apto(String ds_apto) {
		this.ds_apto = ds_apto;
	}
	
}
