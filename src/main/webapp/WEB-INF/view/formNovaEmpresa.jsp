<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/entrada?acao=NovaEmpresa" var="linkNovaEmpresa" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<div style="text-align: right; background-color: whitesmoke">
		<hr>
		<b style="margin-right: 50%">Nova Empresa | <a
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
				<form action="${linkNovaEmpresa}" method="post"
					style="margin:5%">
					<div class="input-group">
						<label for="nome"> Nome: </label> <input type="text" name="nome"
							class="form-control" id="nome" />
					</div>
					<br>
					<div class="input-group">
						<label for="data"> Data Abertura: </label> <input type="text"
							class="form-control" name="data" id="data" />
					</div>
					<div class="footer">
						<hr>
						<button class="btn btn-sm btn-success"  type="submit">Cadastrar</button>
					</div>
				</form>
			</div>

			<div class="col-sm-2"></div>
		</div>
	</div>
</body>
</html>