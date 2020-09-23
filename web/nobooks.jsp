<%-- 
    Document   : nobooks
    Created on : 15 Dec, 2017, 1:43:50 AM
    Author     : HARSHIT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>No books found</title>
    </head>
    <body>
        <%if ((Boolean) request.getAttribute("all")) {
        %>
        <h3>Sorry! No books found. </h3>
        <%} else {
        %>
        <h3>Sorry! No books found for subject <%= request.getAttribute("subject")%> </h3>
        <%}%>
        <h4><a href="searchbook.html">Try Again!</a></h4>
        <h3><a href="index.html">Home</a></h3>
    </body>
</html>
