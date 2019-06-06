<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Projeto Exames - Resultado</title>
</head>
<body>
	<div>
		<s:if test="noData==true">
			<table>
				<thead>
					<tr style="background-color: #E0E0E1;">
						<th>#</th>
						<th>Tipo Exame</th>
						<th>Paciente</th>
						<th>Médico</th>
						<th>Data Realização</th>
						<th>Data Vencimento</th>
						<th>Apto</th>
						<th></th>
					</tr>
				</thead>
				<s:iterator value="beanList">
					<tr>
						<td><s:property value="id" /></td>
						<td><s:property value="tipo_exame_id" /></td>
						<td><s:property value="paciente_id" /></td>
						<td><s:property value="medico_id" /></td>
						<td><s:property value="data_realizacao" /></td>
						<td><s:property value="data_vencimento" /></td>
						<td><s:property value="apto" /></td>
						<td>
							<!-- <a href="updatedetails.action?submitType=updatedata&uemail=<s:property value="id"/>">
								<button class="button-update">Alterar</button>
							</a> -->
							<a href="deletarExame.action?id=<s:property value="id"/>">
								<button class="button-delete">Excluir</button>
							</a>
						</td>
					</tr>
				</s:iterator>
			</table>
		</s:if>
		<s:else>
			<div style="color: red;">Nenhum registro encontrado.</div>
		</s:else>
	</div>
</body>
</html>