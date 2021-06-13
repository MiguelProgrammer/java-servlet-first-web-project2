<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="br.com.estudando.gerenciador.servlet.*,java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:url value="/removeEmpresa" var="removerEmpresa" />
<c:url value="/mostraEmpresa" var="editarEmpresa" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Java Standard Taglib</title>
</head>
<body>
	<div class="form-group">
		<hr>
		<c:if test="${not empty nomeEmpresa }">
			Empresa ${nomeEmpresa} - <fmt:formatDate value="${dataAbertura}"
				pattern="dd/MM/yyyy" /> cadastrada com sucesso!
		</c:if>
		<hr>
		<p>Lista de Empresas</p>
		<hr>
		<ul>
			<c:forEach items="${nomeEmpresas}" var="emp">
				<li>${emp.id} : ${emp.nome} - <fmt:formatDate value="${emp.dataAbertura}"
						pattern="dd/MM/yyyy" />
						<a href="${editarEmpresa}?idEmpresa=${emp.id}"> Editar</a>
						<a href="${removerEmpresa}?idEmpresa=${emp.id}"> Remover</a>
				</li>
			</c:forEach>
		</ul>
	</div>
</body>
</html>