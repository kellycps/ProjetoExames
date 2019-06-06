package com.soctest.action;

import com.soctest.dao.Exame;
import com.soctest.bean.ExameBean;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

public class DeletarExame extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private int id;
	private String msg;
	private Exame dao = new Exame();

	@Override
	public String execute() throws Exception {
		try {
			
			int sucesso = dao.deletar(id);
			
			if (sucesso > 0) {
				msg = "O exame foi deletado com sucesso!";
			} else {
				msg = "Ocorreu um erro e não foi possível deletar.";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "SUCCESS";
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
