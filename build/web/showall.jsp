<%-- 
    Document   : showall.jsp
    Created on : May 4, 2017, 8:06:27 AM
    Author     : lokpr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update form</title>
    </head>
    <body>
        <% String n = request.getParameter("name").trim(); 
           String e = request.getParameter("email").trim();
           String p = request.getParameter("pass").trim();
           String g = request.getParameter("gender").trim();
           String q = request.getParameter("qual").trim();
           String h = request.getParameter("hobby").trim();
           String c = request.getParameter("comment").trim();
        %> 
        
        <form method="post" action="DisplayServlet">
                    <fieldset>
                        <legend>Update Form</legend>
                        <table>
                            <tr><td>Name:</td><td><input type="text" name="fullname" value="<%= n%>"/></td></tr>
                            <tr><td>Email:</td><td><input type="email"  name="mail" value="<%= e%>" hidden="true" /></td></tr>
                            <tr><td>Password:</td><td><input type="password" name="pass" value="<%= p%>"/></td></tr>
                            <tr><td>Gender:</td>
                                            <td>
                                                <% if(g.equals("male")) { %>
                                                <input type="radio" name="gender" value="male" checked="true"/>Male
                                                <input type="radio" name="gender" value="female"/>Female
                                                <% } else { %>
                                                <input type="radio" name="gender" value="male" />Male
                                                <input type="radio" name="gender" value="female" checked="true"/>Female
                                                <% } %>
                                            </td>
                                        </tr>
                            <tr><td>Qualification:</td>
                                    <td><select name="qualification">
                                            <% if (q.equals("undergraduate")) { %>
                                            <option value="undergraduate" selected="true">Undergraduate</option>
                                            <option value="graduate">Graduate</option>
                                            <option value="postgraduate">Postgraduate</option>
                                            
                                            <% } else if (q.equals("graduate")) { %>
                                            <option value="undergraduate">Undergraduate</option>
                                            <option value="graduate" selected="true">Graduate</option>
                                            <option value="postgraduate">Postgraduate</option>
                                            
                                            <% } else { %>
                                            <option value="undergraduate">Undergraduate</option>
                                            <option value="graduate">Graduate</option>
                                            <option value="postgraduate"  selected="true">Postgraduate</option>
                                            <% } %>  
                                        </select></td></tr>
                            <tr><td>Hobbies:</td>
                                <td>
                                    <%  String hobby[] = h.split(" ");
                                        int l = hobby.length;
                                        if(l == 3) {
                                    %>
                                    <input type="checkbox" name="hobbies" value="playing" checked="true">Playing
                                    <input type="checkbox" name="hobbies" value="gardening" checked="true">Gardening
                                    <input type="checkbox" name="hobbies" value="singing" checked="true">Singing
                                    <%      }
                                        
                                        if(l == 2) {
                                            if(hobby[0].equals("playing")) {
                                                if(hobby[1].equals("gardening")) {
                                    %>
                                    <input type="checkbox" name="hobbies" value="playing" checked="true">Playing
                                    <input type="checkbox" name="hobbies" value="gardening" checked="true">Gardening
                                    <input type="checkbox" name="hobbies" value="singing">Singing
                                    
                                    <%     } else {
                                    
                                    %>
                                    <input type="checkbox" name="hobbies" value="playing" checked="true">Playing
                                    <input type="checkbox" name="hobbies" value="gardening">Gardening
                                    <input type="checkbox" name="hobbies" value="singing" checked="true">Singing
                                    
                                    <%
                                        } 
                                    }
                                    else {
                                    %>
                                    <input type="checkbox" name="hobbies" value="playing">Playing
                                    <input type="checkbox" name="hobbies" value="gardening" checked="true">Gardening
                                    <input type="checkbox" name="hobbies" value="singing" checked="true">Singing
                                    
                                    <% }
                                    }
                                    if(l == 1) {
                                        if(hobby[0].equals("playing")) {
                                    %>
                                    <input type="checkbox" name="hobbies" value="playing" checked="true">Playing
                                    <input type="checkbox" name="hobbies" value="gardening">Gardening
                                    <input type="checkbox" name="hobbies" value="singing">Singing
                                    <% } else if (hobby[0].equals("gardening")) { %>
                                    <input type="checkbox" name="hobbies" value="playing">Playing
                                    <input type="checkbox" name="hobbies" value="gardening" checked="true">Gardening
                                    <input type="checkbox" name="hobbies" value="singing">Singing
                                    <% } else { %>
                                    <input type="checkbox" name="hobbies" value="playing">Playing
                                    <input type="checkbox" name="hobbies" value="gardening">Gardening
                                    <input type="checkbox" name="hobbies" value="singing" checked="true">Singing
                                    <% } 
                                    }
                                    %>
                                    </td></tr>
                            <tr><td>Comments:</td>
                            
                                <td><textarea name="feedback" rows="10" cols="30"><%= c%></textarea></td></tr>
                            <tr><td colspan="2"><input type="submit" name="save" value="Save"></td></tr>
                        </table>
                    </fieldset>
                </form>
    </body>
</html>
