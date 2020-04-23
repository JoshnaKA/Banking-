<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>


<body>
	<%String id=(String)request.getAttribute("id");%>
	<%String status=(String)request.getAttribute("status");%>


	<label class="control-label">Transaction id :<%= request.getAttribute("id") %></label>
	<label class="control-label">Status :<%= request.getAttribute("status") %></label>
	<%--  <%response.sendRedirect("http://localhost:8080/BankExample/redirect?id= 
               <jsp:forward page="http://localhost:8080/BankExample/redirect">
              <jsp:param name="id" value="id"/>
                <jsp:param name="status" value="status"/> 
               </jsp:forward> --%>

	<% response.sendRedirect("http://din51002653.corp.capgemini.com:8181/PaymentGateway/result?txId="+id+"&status="+status);%>
</body>
</html>