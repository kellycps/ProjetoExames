package com.soctest.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.soctest.dao.Medico;
import com.soctest.dao.Paciente;
import com.soctest.dao.TipoExame;

public class ExameBean {

	private int id, paciente_id, medico_id, tipo_exame_id;
	private String data_realizacao, data_vencimento, observacao, ds_apto, nome_paciente, nome_medico, nome_tipo_exame;
	private Boolean apto;
	private TipoExameBean tipoExameBean;
	private PacienteBean pacienteBean;
	private MedicoBean medicoBean;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getPaciente_id() {
		return paciente_id;
	}
	
	public void setPaciente_id(int paciente_id) throws SQLException, Exception {
		Paciente paciente = new Paciente();
		ResultSet rs = paciente.consultar(paciente_id);
		rs.next();
		
		PacienteBean bean = new PacienteBean();
		bean.setId(rs.getInt("id"));
		bean.setNome(rs.getString("nome"));
		
		this.setPacienteBean(bean);
		this.setNome_paciente(rs.getString("nome"));
		
		this.paciente_id = paciente_id;
	}
	
	public int getMedico_id() {
		return medico_id;
	}
	
	public void setMedico_id(int medico_id) throws SQLException, Exception {
		Medico medico = new Medico();
		ResultSet rs = medico.consultar(medico_id);
		rs.next();
		
		MedicoBean bean = new MedicoBean();
		bean.setId(rs.getInt("id"));
		bean.setNome(rs.getString("nome"));
		
		this.setMedicoBean(bean);
		this.setNome_medico(rs.getString("nome"));
		
		this.medico_id = medico_id;
	}
	
	public int getTipo_exame_id() {
		return tipo_exame_id;
	}
	
	public void setTipo_exame_id(int tipo_exame_id) throws SQLException, Exception {
		TipoExame tipoExame = new TipoExame();
		ResultSet rs = tipoExame.consultar(tipo_exame_id);
		rs.next();
		
		TipoExameBean bean = new TipoExameBean();
		bean.setId(rs.getInt("id"));
		bean.setNome(rs.getString("nome"));
		
		this.setTipoExameBean(bean);
		this.setNome_tipo_exame(rs.getString("nome"));
		
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
	
	public TipoExameBean getTipoExameBean() {
		return tipoExameBean;
	}

	public void setTipoExameBean(TipoExameBean tipoExameBean) {
		this.tipoExameBean = tipoExameBean;
	}

	public PacienteBean getPacienteBean() {
		return pacienteBean;
	}

	public void setPacienteBean(PacienteBean pacienteBean) {
		this.pacienteBean = pacienteBean;
	}

	public MedicoBean getMedicoBean() {
		return medicoBean;
	}

	public void setMedicoBean(MedicoBean medicoBean) {
		this.medicoBean = medicoBean;
	}

	public String getNome_paciente() {
		return nome_paciente;
	}

	public void setNome_paciente(String nome_paciente) {
		this.nome_paciente = nome_paciente;
	}

	public String getNome_medico() {
		return nome_medico;
	}

	public void setNome_medico(String nome_medico) {
		this.nome_medico = nome_medico;
	}

	public String getNome_tipo_exame() {
		return nome_tipo_exame;
	}

	public void setNome_tipo_exame(String nome_tipo_exame) {
		this.nome_tipo_exame = nome_tipo_exame;
	}
	
}
