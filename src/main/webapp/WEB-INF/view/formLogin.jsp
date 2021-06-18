<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/entrada?acao=Login" var="linkNovaEmpresa" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="form-group">
		<b>Login</b>
		<hr>
		<div align="center">
			<form action="${linkNovaEmpresa}" method="post"
				style="border: 1px solid lightgray; width: 30%;">
				<div class="input-group">
					<label for="login"> Login: </label> 
					<input type="text" name="login" id="login" />
				</div>
				<div class="input-group">
					<label for="senha"> Senha: </label> 
					<input type="password" name="senha" id="senha" />
				</div>
				<div class="footer">
					<hr>
					<button type="submit">Acessar</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>