<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:url value="/entrada?acao=EditarEmpresa" var="linkAlterarEmpresa" />

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div style="text-align: right;background-color: whitesmoke">
	<hr>
	<b style="margin-right:50%">Altera Empresa  
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
			<form action="${linkAlterarEmpresa}" method="post"
				style="border: 1px solid lightgray; width: 30%;">
				<div class="input-group">
					<label for="nome"> Nome: </label> <input type="text" name="nome"
						id="nome" value="${empresa.nome}" />
				</div>
				<div class="input-group">
					<label for="data"> Data Abertura: </label> <input type="text"
						name="data" id="data"
						value="<fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy" />" />
				</div>
				<div class="footer">
					<hr>
					<input type="hidden" name="idEmpresa" value="${empresa.id}">
					<button type="submit">Atualizar</button>
				</div>
			</form>
		</div>
	</div>


</body>
</html>