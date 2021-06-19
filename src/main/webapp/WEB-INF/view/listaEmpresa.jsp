<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="br.com.estudando.gerenciador.servlet.*,java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:url value="/entrada" var="unicoLink" />
<!DOCTYPE html>
<html>
<head>
<style>
table {
	border: 1px solid lightgray;
	border-radius: 3px;
}

th, td {
	border: 1px solid lightgray;
}

#editar {
	background-color: blue;
}

#remover {
	background-color: red;
}

#editar, #remover {
	color: white;
}
</style>
<meta charset="ISO-8859-1">
<title>Java Standard Taglib</title>
</head>
<body>

	<div style="text-align: right;background-color: whitesmoke">
	<hr>
	<b style="margin-right:50%">Empresas
		| <a href="${unicoLink}?acao=NovaEmpresaForm">+ Nova Empresa</a>
		| <a href="${unicoLink}?acao=ListaEmpresas">* Listar Empresas</a>
	</b>
	<b style="margin:2%">
		Usuário logado: ${usuarioLogado.login}
		<c:import url="logout-parcial.jsp"/>
	</b>
	<hr>
	</div>
	<div class="form-group">
		<div align="center">
			<table>
				<thead>
					<tr>
						<th>ID</th>
						<th>NOME EMPRESA</th>
						<th>DATA DE ABERTURA</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>${novaEmpresa.id}</td>
						<td>${novaEmpresa.nome}</td>
						<td><fmt:formatDate value="${novaEmpresa.dataAbertura}"
								pattern="dd/MM/yyyy" /></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>