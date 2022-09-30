package controller;

import dto.StudentDTO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.StudentChangePasswordAuthenticator;

public class StudentChangePasswordServlet extends HttpServlet {
public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
{
    response.sendRedirect("studentHome.jsp");
}
public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
{
    String newpass =request.getParameter("newpass");
    String confirmpass=request.getParameter("confirmpass");
    HttpSession session=request.getSession(true);
    String username=(String)session.getAttribute("username");
    
    if(newpass.equals(confirmpass))
    {
        StudentDTO user=new StudentDTO();
        user.setPassword(newpass);
        user.setUsername(username);
        
        StudentChangePasswordAuthenticator student=new StudentChangePasswordAuthenticator();
        boolean updt=student.isUpdt(user);
        
        if(updt)
        {
        request.setAttribute("message", "Password Updated Successfully");
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/studentChangePassword.jsp");
        rd.include(request, response);
        }
        else
        {
        request.setAttribute("message", "Password cannot be updated");
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/studentChangePassword.jsp");
        rd.include(request, response);
        }
    }
    else
    {
        response.sendRedirect("studentNewPassword.jsp");
    }
}
}
