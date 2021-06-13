<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/novaEmpresa" var="novaEmpresa" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="${novaEmpresa}" method="post">
		<label for="nome"> Nome: <input type="text" name="nome" id="nome" />
		</label>
		<label for="data"> Data Abertura: <input type="text" name="data" id="data" />
			<button type="submit">Cadastrar</button>
		</label>
	</form>
</body>
</html>