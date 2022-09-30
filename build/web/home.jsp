<%-- 
    Document   : home
    Created on : 11 Feb, 2022, 9:21:25 AM
    Author     : Admin
--%>

<%@page import="dto.UserDTO"%>
<%@page import="dao.UserDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String username=(String)session.getAttribute("username");
            String category=(String)session.getAttribute("category");
            UserDAO user=new UserDAO(); 
            UserDTO udto=user.getUserData(username, category);
        %>
        <h1>Hello <%udto.getUsername();%>! You are <%udto.getCategory();%></h1>
    </body>
</html>
