<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>

<body>
	
	<c:set var="data" value="simplilearn" />
	
	Length of the string <b>${data }</b> : ${fn:length(data)}
	
	<br/><br/>
	
	Uppercase version of the string <b>${data} : ${fn:toUpperCase(data)}</b>
	
	<br/><br/>
	
	Does the string <b>${data}</b> start with <b>sim</b>?: ${fn:startsWith(data,"sim")}

</body>

</html>