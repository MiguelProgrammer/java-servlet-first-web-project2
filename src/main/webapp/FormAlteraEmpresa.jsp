<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:url value="/alteraEmpresa" var="linkAlterarEmpresa" />

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="${linkAlterarEmpresa}" method="post">
		<label for="nome"> 
		Nome: <input type="text" name="nome" id="nome" value="${empresa.nome}" />
		</label>
		<label for="data"> 
			Data Abertura: <input type="text" name="data" id="data" value="<fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy" />" />
		</label>
		<input type="hidden" name="idEmpresa" value="${empresa.id}">
		<button type="submit">Atualizar</button>
	</form>
</body>
</html>