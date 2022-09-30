package controller;

import dto.StudentDTO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.AdminDeleteStudentAuthenticator;

public class AdminDeleteStudentServlet extends HttpServlet {
  public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
  {
     String enrollment=request.getParameter("enrollment");
     
     StudentDTO user=new StudentDTO();
     user.setEnrollment(enrollment);
     
     AdminDeleteStudentAuthenticator student=new AdminDeleteStudentAuthenticator();
     boolean dlt=student.isDlt(user);
     if(dlt)
     {
        request.setAttribute("message", "Student Deleted Successfully");
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/adminDeleteStudent.jsp");
        rd.include(request, response);
     }
     else
     {
         request.setAttribute("message", "Student cannot be Deleted");
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/adminDeleteStudent.jsp");
        rd.include(request, response);
     }
  }
}
