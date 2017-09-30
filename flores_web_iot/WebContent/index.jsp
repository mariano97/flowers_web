<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</head>
<body style="margin-top: 50px">
	<div class="container">
		<c:if test="${datos_tabla==null }">
			
			<jsp:forward page="/tabla"></jsp:forward>
			
		</c:if>
		
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Sepal Length</th>
					<th>Sepal Width</th>
					<th>Petal Length</th>
					<th>Petal Width</th>
					<th>Categoria</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${datos_tabla }" var="item">
					
					<tr>
						<td>
							<c:out value="${item.sl }"></c:out>
						</td>
						<td>
							<c:out value="${item.sw }"></c:out>
						</td>
						<td>
							<c:out value="${item.pl }"></c:out>
						</td>
						<td>
							<c:out value="${item.pw }"></c:out>
						</td>
						<td>
							<c:out value="${item.categoria }"></c:out>
						</td>
					</tr>
					
				</c:forEach>
				<c:if test="${datos_tabla.size()==0 }">
					<tr>
						<td rowspan="5">
							No hay Datos
						</td>
					</tr>
				</c:if>
			</tbody>
		</table>
	</div>
</body>
</html>