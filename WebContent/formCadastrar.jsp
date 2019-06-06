<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Projeto Exames - Cadastrar</title>
</head>
<body>
	<s:form action="inserirExame">
		<s:select label="Tipo de exame" list="#{'1':'Admissional','2':'Peri�dico'}" name="tipo_exame_id" headerKey="" headerValue="Selecione"></s:select>
		<s:select label="Paciente" list="pacienteList" name="paciente_id"></s:select>
		<s:select label="M�dico" list="medicoList" name="medico_id"></s:select>	
		<s:textfield label="Data de Realiza��o" name="data_realizacao" />
		<s:textfield label="Data de Vencimento" name="data_vencimento" />
		<s:select label="Apto" list="#{'0':'N�o','1':'Sim'}" name="apto"></s:select>
		<s:textarea label="Avalia��o" name="avaliacao" cols="40" rows="5"></s:textarea>
		<s:submit value="Cadastrar"/>
	</s:form>
</body>
</html>