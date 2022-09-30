/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dto.ManagementDTO;
import dto.StudentDTO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.LoginAuthenticator;

/**
 *
 * @author 91934
 */
public class LoginCheckerServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException , ServletException
    {
        response.sendRedirect("login.jsp");
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException , ServletException
    {
    String username=request.getParameter("username");
    String password=request.getParameter("password");
    String category=request.getParameter("c");
    HttpSession session=request.getSession(true);
    
    LoginAuthenticator la=new LoginAuthenticator();
    boolean login=false;
    if(category.equals("student"))
    {
        StudentDTO user=new StudentDTO();
        user.setUsername(username);
        user.setPassword(password);
        user.setCategory(category);
        login=la.isLogin(user);
    }
    else
    {
        ManagementDTO user=new ManagementDTO();
        user.setUsername(username);
        user.setPassword(password);
        user.setCategory(category);
        login=la.isLogin(user);
    }
    
    if(login)
    {
        session.setAttribute("username", username);
        session.setAttribute("category",category);
        switch(category)
        {
            case "admin":response.sendRedirect("adminHome.jsp");break;
            case "hod":response.sendRedirect("hodHome.jsp");break;
            case "faculty":response.sendRedirect("facultyHome.jsp");break;
            case "student":response.sendRedirect("studentHome.jsp");break;
            default:response.sendRedirect("login.jsp");
        }
    }
    else
    {
        response.sendRedirect("login.jsp");
 
    }
}
}
