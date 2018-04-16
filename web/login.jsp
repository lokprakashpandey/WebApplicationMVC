<%-- 
    Document   : login
    Created on : Apr 26, 2017, 10:22:59 AM
    Author     : lokpr
--%>

<%@page import="com.lok.model.RegisterModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LogIn Page</title>
    </head>
    
        <% 
            RegisterModel rm = (RegisterModel)request.getAttribute("user"); 
            
        %>
        <h2>Welcome</h2><h1><%= rm.getName() %></h1>
        <p>If you want to update your info, click <a href="showall.jsp?name=<%= rm.getName()%>
                                                                      &email=<%= rm.getEmail()%>
                                                                      &pass=<%= rm.getPassword()%>
                                                                      &gender=<%= rm.getGender()%>
                                                                      &qual=<%= rm.getQualification()%>
                                                                      &hobby=<%= rm.getHobby()%>
                                                                      &comment=<%= rm.getComment()%>
                                                                      ">here</a> </p>
    
                                                                      
                                                                      
                                                                      
</html>
