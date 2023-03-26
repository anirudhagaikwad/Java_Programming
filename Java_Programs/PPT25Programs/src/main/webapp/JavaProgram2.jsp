<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%-- JSP program to show the System date and time. --%>
<%@page import="java.util.Date"%>
<%!
    Date date; 
%>
<% 
    date = new Date();
%>
<b>System date and time: </b> <%= date %>


</body>
</html>