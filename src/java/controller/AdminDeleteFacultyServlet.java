package controller;

import dto.ManagementDTO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.AdminDeleteFacultyAuthenticator;

public class AdminDeleteFacultyServlet extends HttpServlet {
  public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
  {
     String id=request.getParameter("faculty");
     
     ManagementDTO user=new ManagementDTO();
     user.setID(id);
     
     AdminDeleteFacultyAuthenticator student=new AdminDeleteFacultyAuthenticator();
     boolean dlt=student.isDlt(user);
     if(dlt)
     {
        request.setAttribute("message", "Faculty Deleted Successfully");
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/adminDeleteFaculty.jsp");
        rd.include(request, response);
     }
     else
     {
         request.setAttribute("message", "Faculty cannot be Deleted");
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/adminDeleteFaculty.jsp");
        rd.include(request, response);
     }
  }
}
