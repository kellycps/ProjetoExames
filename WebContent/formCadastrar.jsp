<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Projeto Exames - Cadastrar</title>
<link rel="stylesheet" type="text/css" href="css/style.css"/>
</head>
<body>
	<h2>Cadastro de Exames</h2>
	<s:form action="inserirExame">
		<s:select label="Tipo de exame" list="tipoExameList" listKey="id" listValue="nome" name="tipo_exame_id"></s:select>
		<s:select label="Paciente" list="pacienteList" listKey="id" listValue="nome" name="paciente_id"></s:select>
		<s:select label="Médico" list="medicoList" listKey="id" listValue="nome" name="medico_id"></s:select>	
		<s:textfield label="Data de Realização" name="data_realizacao" />
		<s:textfield label="Data de Vencimento" name="data_vencimento" />
		<s:select label="Apto" list="#{'nao':'Não','sim':'Sim'}" name="apto"></s:select>
		<s:textarea label="Avaliação" name="avaliacao" cols="40" rows="5"></s:textarea>
		<s:submit value="Cadastrar"/>
	</s:form>
</body>
</html>