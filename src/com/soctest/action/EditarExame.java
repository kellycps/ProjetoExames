package com.soctest.action;

import com.soctest.dao.Exame;
import com.soctest.dao.Medico;
import com.soctest.dao.Paciente;
import com.soctest.dao.TipoExame;
import com.soctest.bean.MedicoBean;
import com.soctest.bean.PacienteBean;
import com.soctest.bean.TipoExameBean;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

public class EditarExame extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private int id, tipo_exame_id, paciente_id, medico_id;
	private String data_realizacao, data_vencimento, observacao;
	private Exame exame = new Exame();
	private ResultSet rs = null;
	private Boolean apto;
	private List<TipoExameBean> tipoExameList = new ArrayList<TipoExameBean>();
	private List<PacienteBean> pacienteList = new ArrayList<PacienteBean>();
	private List<MedicoBean> medicoList = new ArrayList<MedicoBean>();
	private TipoExameBean tipoExameBean = null;
	private PacienteBean pacienteBean = null;
	private MedicoBean medicoBean = null;

	@Override
	public String execute() throws Exception {
		try {
			rs = exame.consultar(id);

			if (rs != null) {
				rs.next();
					
				DateTimeFormatter formatoBr = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				String data_realizacao = formatoBr.format(LocalDate.parse(rs.getString("data_realizacao"), formato));
				String data_vencimento = formatoBr.format(LocalDate.parse(rs.getString("data_vencimento"), formato));
				
				this.setTipo_exame_id(rs.getInt("tipo_exame_id"));
				this.setPaciente_id(rs.getInt("paciente_id"));
				this.setMedico_id(rs.getInt("medico_id"));
				this.setData_realizacao(data_realizacao);
				this.setData_vencimento(data_vencimento);
				this.setApto(rs.getBoolean("apto"));
				this.setObservacao(rs.getString("observacao"));

			}
			
			TipoExame tipoExame = new TipoExame();
			ResultSet rs = tipoExame.listar();
			
			if (rs != null) {
				while (rs.next()) {
					tipoExameBean = new TipoExameBean();
					tipoExameBean.setId(rs.getInt("id"));
					tipoExameBean.setNome(rs.getString("nome"));
					tipoExameList.add(tipoExameBean);
				}
			}
			
			Paciente paciente = new Paciente();
			rs = paciente.listar();
			
			if (rs != null) {
				while (rs.next()) {
					pacienteBean = new PacienteBean();
					pacienteBean.setId(rs.getInt("id"));
					pacienteBean.setNome(rs.getString("nome"));
					pacienteList.add(pacienteBean);
				}
			}
			
			Medico medico = new Medico();
			rs = medico.listar();
			
			if (rs != null) {
				while (rs.next()) {
					medicoBean = new MedicoBean();
					medicoBean.setId(rs.getInt("id"));
					medicoBean.setNome(rs.getString("nome"));
					medicoList.add(medicoBean);
				}
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		return "SUCCESS";
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

	public List<TipoExameBean> getTipoExameList() {
		return tipoExameList;
	}

	public void setTipoExameList(List<TipoExameBean> tipoExameList) {
		this.tipoExameList = tipoExameList;
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
	
}
