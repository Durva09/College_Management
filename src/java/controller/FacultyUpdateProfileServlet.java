package controller;

import dto.ManagementDTO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.FacultyUpdateProfileAuthenticator;

public class FacultyUpdateProfileServlet extends HttpServlet {
  public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
  {
     String id=request.getParameter("id");
     String name=request.getParameter("name");
     String gender=request.getParameter("gender");
     String department=request.getParameter("department");
     String designation=request.getParameter("designation");
     String email=request.getParameter("email");
     String contact=request.getParameter("contact");
     String year=request.getParameter("year");
     String qualification=request.getParameter("qualification");
     String experience=request.getParameter("experience");
     String aadhar=request.getParameter("aadhar");
     String blood=request.getParameter("blood");
     String address=request.getParameter("address");
     String dob=request.getParameter("dob");
     
     ManagementDTO user=new ManagementDTO();
     user.setID(id);
     user.setUsername(name);
     user.setGender(gender);
     user.setDepartment(department);
     user.setDesignation(designation);
     user.setEmail(email);
     user.setContact(contact);
     user.setYear(year);
     user.setQualification(qualification);
     user.setExperience(experience);
     user.setAadhar(aadhar);
     user.setBlood_group(blood);
     user.setAddress(address);
     user.setDob(dob);
     
     FacultyUpdateProfileAuthenticator hod=new FacultyUpdateProfileAuthenticator();
     boolean updt=hod.isUpdt(user);
     if(updt)
     {
        request.setAttribute("message", "Faculty Updated Successfully");
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/facultyHome.jsp");
        rd.include(request, response);
     }
     else
     {
         request.setAttribute("message", "Faculty cannot be Updated");
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/facultyhodHome.jsp");
        rd.include(request, response);
     }
  }
}
