<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

 <%-- <h3>All Department Name : ${requestScope.dept_list}</h3> --%>
<form action="" method="post">
<table style="background-color: skyblue; font-size: 20px; padding: 15px" align="center">
	<caption>All Dept Name </caption>
	<tr>
		<td>
			Choose Department Name : 
		</td>
		<td>
			<select name="dept_name">
				<c:forEach var="d" items="${requestScope.dept_list}">
					<option value="${d}">${d}</option>
				</c:forEach>
			</select>
		</td>
	</tr>
	<tr>
		<td>
			<input type="submit" value="Choose Department">
		</td>
		</tr>
</table>





</form>

</body>
</html>