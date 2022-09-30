package controller;

import dto.ManagementDTO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.AdminAddHODAuthenticator;

public class AdminAddHODServlet extends HttpServlet {
  public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
  {
     String id="1010HOD";
     String name=request.getParameter("name");
     String gender=request.getParameter("gender");
     String password=request.getParameter("password");
     String department=request.getParameter("department");
     String designation=request.getParameter("designation");
     String contact=request.getParameter("contact");
     String year=request.getParameter("year");
     String email=request.getParameter("email");
     String aadhar=request.getParameter("aadhar");
     String blood=request.getParameter("blood");
     String address=request.getParameter("address");
     String dob=request.getParameter("dob");
     String qualification=request.getParameter("qualification");
     String experience =request.getParameter("experience");
     id+=year;
     
     ManagementDTO user=new ManagementDTO();
     user.setID(id);
     user.setUsername(name);
     user.setGender(gender);
     user.setPassword(password);
     user.setDepartment(department);
     user.setExperience(experience);
     user.setEmail(email);
     user.setContact(contact);
     user.setYear(year);
     user.setDesignation(designation);
     user.setAadhar(aadhar);
     user.setBlood_group(blood);
     user.setQualification(qualification);
     user.setAddress(address);
     user.setDob(dob);
     
     AdminAddHODAuthenticator student=new AdminAddHODAuthenticator();
     boolean insrt=student.isInsrt(user);
     if(insrt)
     {
        request.setAttribute("message", "Faculty Added Successfully");
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/adminAddHod.jsp");
        rd.include(request, response);
     }
     else
     {
         request.setAttribute("message", "Faculty cannot be Added");
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/adminAddHod.jsp");
        rd.include(request, response);
     }
  }
}
