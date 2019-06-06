<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Projeto Exames - Buscar</title>
<link rel="stylesheet" type="text/css" href="css/style.css"/>
</head>
<body>
	<h2>Buscar exames</h2>
	<s:form action="buscarExame">
		<s:select label="Tipo de exame" list="tipoExameList" listKey="id" listValue="nome" name="tipo_exame_id" headerKey="0" headerValue="Todos"></s:select>
		<s:select label="Paciente" list="pacienteList" listKey="id" listValue="nome" name="paciente_id" headerKey="0" headerValue="Todos"></s:select>
		<s:select label="Médico" list="medicoList" listKey="id" listValue="nome" name="medico_id" headerKey="0" headerValue="Todos"></s:select>	
		<s:textfield label="Início período realização" name="data_inicio_realizacao" />
		<s:textfield label="Fim período" name="data_fim_realizacao" />
		<s:textfield label="Início período vencimento" name="data_inicio_vencimento" />
		<s:textfield label="Fim período" name="data_fim_vencimento" />
		<s:select label="Apto" list="#{'0':'Não','1':'Sim'}" name="apto"></s:select>
		<s:submit value="Buscar"/>
	</s:form>
</body>
</html>