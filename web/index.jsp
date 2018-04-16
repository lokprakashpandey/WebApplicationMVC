<%-- 
    Document   : index
    Created on : Apr 21, 2017, 10:10:14 AM
    Author     : lokpr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Java Web MVC</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="./newcss.css">
    </head>
    <body>
        <div id="container">
            <div class="signupform">
                <form method="post" action="DisplayServlet">
                    <fieldset>
                        <legend>Sign Up Form</legend>
                        <table>
                            <tr><td>Name:</td><td><input type="text" name="fullname"/></td></tr>
                            <tr><td>Email:</td><td><input type="email" name="mail"/></td></tr>
                            <tr><td>Password:</td><td><input type="password" name="pass"/></td></tr>
                            <tr><td>Gender:</td>
                                    <td><input type="radio" name="gender" value="male"/>Male
                                        <input type="radio" name="gender" value="female"/>Female</td></tr>
                            <tr><td>Qualification:</td>
                                    <td><select name="qualification">
                                            <option value="undergraduate">Undergraduate</option>
                                            <option value="graduate">Graduate</option>
                                            <option value="postgraduate">Postgraduate</option>
                                        </select></td></tr>
                            <tr><td>Hobbies:</td>
                                <td>
                                    <input type="checkbox" name="hobbies" value="playing">Playing
                                    <input type="checkbox" name="hobbies" value="gardening">Gardening
                                    <input type="checkbox" name="hobbies" value="singing">Singing
                                </td></tr>
                            <tr><td>Comments:</td>
                            
                                <td><textarea name="feedback" rows="10" cols="30"></textarea></td></tr>
                            <tr><td colspan="2"><input type="submit" name="send" value="Register"></td></tr>
                        </table>
                    </fieldset>
                </form>
            </div>
            <div class="signinform">
                <form method="post" action="DisplayServlet">
                    <fieldset>
                        <legend>Sign In Form</legend>
                        <table>
                            <tr><td>Email:</td><td><input type="email" name="mail"/></td></tr>
                            <tr><td>Password:</td><td><input type="password" name="pass"/></td></tr>
                            <tr><td colspan="2"><input type="submit" name="login" value="Log In"></td></tr>
                        </table>
                    </fieldset>
                </form>
            </div>
                 
        </div>
    </body>
</html>
