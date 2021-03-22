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
	<c:forEach var="tempStudent" items="${myStudents}">
		
		${tempStudent.firstName}  ${tempStudent.lastName} , ${tempStudent.goldCustomer}
		<br/>
	
	</c:forEach>
</body>
</html>