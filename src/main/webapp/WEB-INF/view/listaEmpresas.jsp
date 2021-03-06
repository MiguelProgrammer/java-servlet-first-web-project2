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

	<div style="text-align: right; background-color: whitesmoke">
		<hr>
		<b style="margin-right: 54%">Lista de Empresas | <a
			href="${unicoLink}?acao=NovaEmpresaForm">+ Nova Empresa</a>
		</b> <b style="margin: 2%"> Usu?rio logado: ${usuarioLogado.login} <c:import
				url="logout-parcial.jsp" />
		</b>
		<hr>
	</div>

	<div class="form-group row">
		<div class="col-sm-2"></div>
		<div align="center" class="col-sm-8">
			<table class="table table-bordered">
				<thead class="table-light">
					<tr>
						<th>ID</th>
						<th>NOME EMPRESA</th>
						<th>DATA DE ABERTURA</th>
						<th>A??O</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${nomeEmpresas}" var="emp">
						<tr>
							<td>${emp.id}</td>
							<td>${emp.nome}</td>
							<td><fmt:formatDate value="${emp.dataAbertura}"
									pattern="dd/MM/yyyy" /></td>
							<td><a id="editar"
								href="${unicoLink}?acao=MostraEmpresa&idEmpresa=${emp.id}">
									Editar</a> <a id="remover"
								href="${unicoLink}?acao=RemoveEmpresa&idEmpresa=${emp.id}">
									Remover</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="col-sm-2"></div>
	</div>
</body>
</html>