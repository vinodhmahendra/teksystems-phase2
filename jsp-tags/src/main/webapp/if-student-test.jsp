<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="java.util.*, org.simplilearn.workshop.*" %>

<%
	List<Student> data = new ArrayList<>();
	data.add(new Student("vinodh","mahendra",false));
	data.add(new Student("maxwell","johnson",false));
	data.add(new Student("mary","public",true));
	
	pageContext.setAttribute("myStudents", data);
%>

<html>
<body>

	<table border="1">
	<tr>
		<th>First Name</th>
		<th>Last Name </th>
		<th>Gold Customer</th>
	</tr>
	<c:forEach var="tempStudent" items="${myStudents}">
		<tr>
		<td>${tempStudent.firstName}</td>
		<td>  ${tempStudent.lastName}</td>
		<td>
			<c:if test="${tempStudent.goldCustomer }">
				special discount
			</c:if>
			
			<c:if test="${not tempStudent.goldCustomer }">
				-
			</c:if>
		</td>
		</tr>
	
	</c:forEach>
	</table>
</body>
</html>