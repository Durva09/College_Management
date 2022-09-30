package controller;

import dto.StudentDTO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.StudentCheckPasswordAuthenticator;

public class StudentCheckPasswordServlet extends HttpServlet {
public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
{
    response.sendRedirect("studentHome.jsp");
}
public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
{
    String current=request.getParameter("current");
    HttpSession session=request.getSession(true);
    String username=(String)session.getAttribute("username");
    
    StudentDTO student=new StudentDTO();
    student.setPassword(current);
    student.setUsername(username);
    
    StudentCheckPasswordAuthenticator check=new StudentCheckPasswordAuthenticator();
    boolean change=check.isCorrect(student);
    
    if(change)
    {
        response.sendRedirect("studentNewPassword.jsp");
    }
    else
    {
        response.sendRedirect("studentChangePassword.jsp");
    }
}
}
