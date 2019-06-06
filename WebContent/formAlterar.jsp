<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Projeto Exames - Alterar</title>
<link rel="stylesheet" type="text/css" href="css/style.css"/>
</head>
<body>
	<s:form action="alterarExame">
		<s:hidden name="id" value="%{id}" />
		<s:select label="Tipo de exame" list="tipoExameList" listKey="id" listValue="nome" name="tipo_exame_id" value='tipo_exame_id'></s:select>
		<s:select label="Paciente" list="pacienteList" listKey="id" listValue="nome" name="paciente_id" value='paciente_id'></s:select>
		<s:select label="Médico" list="medicoList" listKey="id" listValue="nome" name="medico_id" value='medico_id'></s:select>	
		<s:textfield label="Data de Realização" name="data_realizacao" value='%{data_realizacao}' />
		<s:textfield label="Data de Vencimento" name="data_vencimento" value='%{data_vencimento}' />
		<s:select label="Apto" list="#{'nao':'Não', 'sim':'Sim'}" name="apto" value='%{apto}'></s:select>
		<s:textarea label="Avaliação" name="avaliacao" cols="40" rows="5" value='%{observacao}'></s:textarea>
		<s:submit value="Alterar"/>
	</s:form>
</body>
</html>