<%-- 
    Document   : showbooks
    Created on : 15 Dec, 2017, 1:52:26 AM
    Author     : HARSHIT
--%>
<%@page import="java.util.*,dto.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Books List</title>
    </head>
    <body>
        <%if ((Boolean) request.getAttribute("all")) {
        %>
    <h<h3>List of Books</h3>
        <table border="1">
            <tr>
                <th>Book ID</th>
                <th>Book Name</th>
                <th>Book Price</th>
                <th>Subject</th>
            </tr>
            <%
                ArrayList<MyBooksDTO> booksList = (ArrayList) request.getAttribute("booksList");
                for (MyBooksDTO book : booksList) {
                    out.println("<tr>");
                    out.println("<td>" + book.getBookID() + "</td>");
                    out.println("<td>" + book.getBookName() + "</td>");
                    out.println("<td>" + book.getBookPrice() + "</td>");
                    out.println("<td>" + book.getSubject() + "</td>");
                    out.println("<tr>");
                }
            %>
        </table>        
        <% } else {
        %>
        <h3>List of Books for Subject <%=request.getAttribute("subject")%>  </h3>
        <table border="1">
            <tr>
                <th>Book Name</th>
                <th>Book Price</th>
            </tr>
            <%
                ArrayList<MyBooksDTO> booksList = (ArrayList) request.getAttribute("booksList");
                for (MyBooksDTO book : booksList) {
                    out.println("<tr>");
                    out.println("<td>" + book.getBookName() + "</td>");
                    out.println("<td>" + book.getBookPrice() + "</td>");
                    out.println("<tr>");
                }

            %> 
        </table>
        <h4><a href="searchbook.html">Search Again</a></h4> 
        <% }%>

        <h3><a href="index.html">Home</a></h3>
    </body>
</html>
