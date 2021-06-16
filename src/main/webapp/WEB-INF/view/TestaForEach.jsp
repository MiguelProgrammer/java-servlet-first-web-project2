<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Testando ForEach</title>
</head>
<body>
	<c:forEach var="i" begin="1" end="10" step="2">
		<p>${i}</p>
	</c:forEach>
</body>
</html>