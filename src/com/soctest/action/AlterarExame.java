package com.soctest.action;

import com.soctest.dao.Exame;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.opensymphony.xwork2.ActionSupport;

public class AlterarExame extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private int id, tipo_exame_id, paciente_id, medico_id;
	private String data_realizacao, data_vencimento, avaliacao;
	private Boolean apto;
	private String msg = "";
	Exame exame = null;
	int sucesso = 0;

	@Override
	public String execute() throws Exception {
		exame = new Exame();

		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		data_realizacao = formato.format(LocalDate.parse(data_realizacao, formato));
		data_vencimento = formato.format(LocalDate.parse(data_vencimento, formato));
		
		try {
			sucesso = exame.alterar(id, tipo_exame_id, paciente_id, medico_id, data_realizacao, data_vencimento, avaliacao, apto);
			if (sucesso > 0) {
				msg = "Exame Alterado com sucesso!";
			} else {
				msg = "Ocorreu um erro";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
