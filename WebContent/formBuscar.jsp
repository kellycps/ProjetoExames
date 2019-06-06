<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Projeto Exames - Buscar</title>
</head>
<body>
	<s:form action="buscarExame">
		<s:select label="Tipo de exame" list="tipoExameList" listKey="id" listValue="nome" name="tipo_exame_id" headerKey="0" headerValue="Todos"></s:select>
		<s:select label="Paciente" list="pacienteList" name="paciente_id" headerKey="0" headerValue="Todos"></s:select>
		<s:select label="Médico" list="medicoList" name="medico_id" headerKey="0" headerValue="Todos"></s:select>	
		<s:textfield label="Período realização" name="data_inicio_realizacao" />
		<s:textfield label="" name="data_fim_realizacao" />
		<s:textfield label="Exames a vencer" name="data_inicio_vencimento" />
		<s:textfield label="" name="data_fim_vencimento" />
		<s:select label="Apto" list="#{'0':'Não','1':'Sim'}" name="apto"></s:select>
		<s:submit value="Buscar"/>
	</s:form>
</body>
</html>