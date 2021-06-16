<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/entrada?acao=NovaEmpresa" var="linkNovaEmpresa" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="form-group">
		<b>Nova Empresa | 
			<a href="${unicoLink}?acao=ListaEmpresas">* Listar Empresas</a></b>
		<hr>
		<div align="center">
			<form action="${linkNovaEmpresa}" method="post"
				style="border: 1px solid lightgray; width: 30%;">
				<div class="input-group">
					<label for="nome"> Nome: </label> <input type="text" name="nome"
						id="nome" />
				</div>
				<div class="input-group">
					<label for="data"> Data Abertura: </label> <input type="text"
						name="data" id="data" />
				</div>
				<div class="footer">
					<hr>
					<button type="submit">Cadastrar</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>