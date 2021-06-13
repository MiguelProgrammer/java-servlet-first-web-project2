<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta>
<title>Minha Primeira JSP</title>
</head>
<body>
	<h2>
		<c:if test="${not empty nomeEmpresa }">
			Empresa ${nomeEmpresa} - <fmt:formatDate value="${dataAbertura}" pattern="dd/MM/yyyy"/> cadastrada com sucesso!
		</c:if>
		<c:if test="${empty nomeEmpresa }">
			Nenhuma empresa cadastrada!
		</c:if>
	</h2>
</body>
</html>