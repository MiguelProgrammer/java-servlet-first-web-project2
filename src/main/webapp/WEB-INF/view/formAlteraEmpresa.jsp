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
	<div style="text-align: right; background-color: whitesmoke">
		<hr>
			<b style="margin-right: 50%">Altera Empresa | <a
			href="${unicoLink}?acao=NovaEmpresaForm">+ Nova Empresa</a> | <a
			href="${unicoLink}?acao=ListaEmpresas">* Listar Empresas</a>
		</b> <b style="margin: 1%"> Usuário logado: ${usuarioLogado.login} <c:import
				url="logout-parcial.jsp" />
		</b>
		<hr>
	</div>

	<div class="container">
		<div class="row">
			<div class="col-sm-2"></div>
			<div class="col-sm-8"
				style="border: 1px solid lightgray; border-radius: 7px;">
				<form action="${linkAlterarEmpresa}" method="post"
					style="margin: 5%">
					<div class="input-group">
						<label for="nome"> Nome: </label> <input type="text"
							class="form-control" name="nome" id="nome"
							value="${empresa.nome}" />
					</div>

					<div class="input-group">
						<label for="data" class="form-label"> Data Abertura: </label> <input
							type="text" name="data" id="data" class="form-control"
							value="<fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy" />" />
					</div>
					<div class="footer">
						<hr>
						<input type="hidden" name="idEmpresa" value="${empresa.id}">
						<button class="btn btn-sm btn-primary" type="submit">Atualizar</button>
					</div>
				</form>
			</div>
			<div class="col-sm-2"></div>
		</div>
	</div>


</body>
</html>