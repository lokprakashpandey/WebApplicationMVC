/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lok.controller;

import com.lok.dao.UserInsert;

import com.lok.model.RegisterModel;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lokpr
 */
public class DisplayServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            if(request.getParameter("send") != null && request.getParameter("send").equals("Register")) {
                String name = request.getParameter("fullname");
                String mail = request.getParameter("mail");
                String password = request.getParameter("pass");
                String gender = request.getParameter("gender");
                String qual = request.getParameter("qualification");
                String hobby[] = request.getParameterValues("hobbies");
                String fb = request.getParameter("feedback");
                
                int n = hobby.length;
                
                
                if("".equals(mail) || "".equals(password)) {
                    response.sendRedirect("index.jsp");           
                }
                else {
                    //                out.println("Name is:"+name+"<br/>");
                    //                out.println("Email is:"+mail+"<br/>");
                    //                out.println("Password is:"+password+"<br/>");
                    //                out.println("Gender is:"+gender+"<br/>");
                    //                out.println("Qualification is:"+qual+"<br/>");
                    //                out.println("Your hobbies are:");
                    //                for(int i=0;i<n;i++)
                    //                        out.println(hobby[i]);
                    //                out.println("<br/>Feedback:"+fb+"<br/>");
                    //                String []mailSplit = mail.split("@");
                    //                out.println("Your username is:"+mailSplit[0]);
                    //
                    
                    
                    //out.println("11111111111111111111111");
                    RegisterModel m = new RegisterModel();
                    m.setName(name);
                    m.setEmail(mail);
                    m.setPassword(password);
                    m.setGender(gender);
                    m.setQualification(qual);
                    String h="";
                    for(int i=0;i<n;i++)
                        h += hobby[i]+" ";
                    m.setHobby(h);
                    m.setComment(fb);

                    UserInsert.insertUser(m);
                    //out.println("5555555555555555555555555555555");
                    response.sendRedirect("test.jsp");
                }
            } 
            else if (request.getParameter("login") != null && request.getParameter("login").equals("Log In")) {
                String e = request.getParameter("mail");
                String p = request.getParameter("pass");
                RegisterModel m = UserInsert.checkAuthentication(e,p);
                if(m == null){
                response.sendRedirect("index.jsp");
                }
                else {
            //        Cookie ck = 
                    request.setAttribute("user", m);
                    RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
                    rd.forward(request, response);
                }
            }
            
            else if (request.getParameter("save") != null && request.getParameter("save").equals("Save")) {
                String name = request.getParameter("fullname");
                String mail = request.getParameter("mail");
                String password = request.getParameter("pass");
                String gender = request.getParameter("gender");
                String qual = request.getParameter("qualification");
                String hobby[] = request.getParameterValues("hobbies");
                String fb = request.getParameter("feedback");
                int n = hobby.length;
                
                    RegisterModel m = new RegisterModel();
                    m.setName(name);
                    m.setEmail(mail);
                    m.setPassword(password);
                    m.setGender(gender);
                    m.setQualification(qual);
                    String h="";
                    for(int i=0;i<n;i++)
                        h += hobby[i]+" ";
                    m.setHobby(h);
                    m.setComment(fb);
                    
//                    out.println(m.getName());
//                    out.println(m.getEmail());
//                    out.println(m.getPassword());
//                    out.println(m.getGender());
//                    out.println(m.getQualification());
//                    out.println(m.getHobby());
//                    out.println(m.getComment());
                    UserInsert.updateUser(m);
                    
                    request.setAttribute("user", m);
                    RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
                    rd.forward(request, response);
                    
                    
                    
            }
        }
    }    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
