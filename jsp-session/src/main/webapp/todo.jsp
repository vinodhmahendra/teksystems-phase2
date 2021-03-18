<%@ page import="java.util.*" %>
<html>
<body>

<!-- step 1 : create HTML form -->
<form action="todo.jsp">
	Add new item : <input type="text" name="theItem"/>
	
	<input type="submit" value="Submit">
</form>

<br/>


<!-- step 2 : Add new item to "To Do" list -->
<%
	// get the TODO items from the session
	List<String> items = (List<String>) session.getAttribute("myToDoList");
	
	//if the TODO items doesn't exist, then create a new one
	if (items == null){
		items = new ArrayList<String>();
		session.setAttribute("myToDoList", items);
	}
	
	//see if there is form data to add
	String theItem = request.getParameter("theItem");
	
	boolean isItemNotEmpty = theItem != null && theItem.trim().length() > 0 ;
	boolean isItemNotDuplicate = theItem != null && !items.contains(theItem.trim());
		
	
	if(isItemNotEmpty && isItemNotDuplicate){
		items.add(theItem.trim());
	}
%>

<!-- step 3: Display all "To do" item from session -->

<hr>
<b>To List Items :</b> <br/>

<ol>

<%
	for (String temp : items){
		out.println("<li>" + temp + "</li>");
	}
%>

</ol>
</body>

</html>