package controller;

import dto.StudentDTO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.StudentUpdateProfileAuthenticator;

public class StudentUpdateProfileServlet extends HttpServlet {
  public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
  {
     String enrollment=request.getParameter("enrollment");
     String name=request.getParameter("name");
     String gender=request.getParameter("gender");
     String branch=request.getParameter("branch");
     String email=request.getParameter("email");
     String contact=request.getParameter("contact");
     String year=request.getParameter("year");
     String fname=request.getParameter("fname");
     String aadhar=request.getParameter("aadhar");
     String blood=request.getParameter("blood");
     String address=request.getParameter("address");
     String dob=request.getParameter("dob");
     
     StudentDTO user=new StudentDTO();
     user.setEnrollment(enrollment);
     user.setUsername(name);
     user.setGender(gender);
     user.setBranch(branch);
     user.setEmail(email);
     user.setContact(contact);
     user.setYear(year);
     user.setFather_name(fname);
     user.setAadhar(aadhar);
     user.setBlood(blood);
     user.setAddress(address);
     user.setDob(dob);
     
     StudentUpdateProfileAuthenticator student=new StudentUpdateProfileAuthenticator();
     boolean updt=student.isUpdt(user);
     if(updt)
     {
        request.setAttribute("message", "Student Updated Successfully");
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/studentUpdateProfile.jsp");
        rd.include(request, response);
     }
     else
     {
         request.setAttribute("message", "Student cannot be Updated");
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/studentUpdateProfile.jsp");
        rd.include(request, response);
     }
  }
}
