package controller;

import dto.ManagementDTO;
import dto.StudentDTO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.AdminDeleteHODAuthenticator;
import model.AdminDeleteStudentAuthenticator;

public class AdminDeleteHODServlet extends HttpServlet {
  public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
  {
     String id=request.getParameter("hod");
     
     ManagementDTO user=new ManagementDTO();
     user.setID(id);
     
     AdminDeleteHODAuthenticator student=new AdminDeleteHODAuthenticator();
     boolean dlt=student.isDlt(user);
     if(dlt)
     {
        request.setAttribute("message", "HOD Deleted Successfully");
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/adminDeleteHod.jsp");
        rd.include(request, response);
     }
     else
     {
         request.setAttribute("message", "HOD cannot be Deleted");
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/adminDeleteHod.jsp");
        rd.include(request, response);
     }
  }
}
