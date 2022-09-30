package controller;

import dto.StudentDTO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.AdminAddStudentAuthenticator;

public class AdminAddStudentServlet extends HttpServlet {
  public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
  {
     String enrollment="0818";
     String name=request.getParameter("name");
     String gender=request.getParameter("gender");
     String password=request.getParameter("password");
     String branch=request.getParameter("branch");
     String email=request.getParameter("email");
     String contact=request.getParameter("contact");
     String year=request.getParameter("year");
     String fname=request.getParameter("fname");
     String aadhar=request.getParameter("aadhar");
     String blood=request.getParameter("blood");
     String address=request.getParameter("address");
     String dob=request.getParameter("dob");
     String brnch="";
     
     switch(branch)
     {
         case "Computer_Science": brnch="CS";break;
         case "Information_Technology": brnch="IT";break;
         case "Mechanical_Engineering": brnch="ME";break;
         case "Chemical_Engineering": brnch="CM";break;
         case "Civil_Engineering": brnch="CE";break;
         case "Electronics_and_communication_Engineering": brnch="EC";break;
     }
     
     enrollment="0818"+brnch+year;
     
     StudentDTO user=new StudentDTO();
     user.setEnrollment(enrollment);
     user.setUsername(name);
     user.setGender(gender);
     user.setPassword(password);
     user.setBranch(branch);
     user.setEmail(email);
     user.setContact(contact);
     user.setYear(year);
     user.setFather_name(fname);
     user.setAadhar(aadhar);
     user.setBlood(blood);
     user.setAddress(address);
     user.setDob(dob);
     
     AdminAddStudentAuthenticator student=new AdminAddStudentAuthenticator();
     boolean insrt=student.isInsrt(user);
     if(insrt)
     {
        request.setAttribute("message", "Student Added Successfully");
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/adminAddStudent.jsp");
        rd.include(request, response);
     }
     else
     {
         request.setAttribute("message", "Student cannot be Added");
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/adminAddStudent.jsp");
        rd.include(request, response);
     }
  }
}
