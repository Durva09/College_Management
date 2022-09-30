package controller;

import dto.MessageDTO;
import java.io.IOException;
import java.time.LocalDate;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.FacultyResponseAuthenticator;

public class FacultyResponseServlet extends HttpServlet {

   public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
   {
       response.sendRedirect("login.html");
   }
   public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
   {
       String reply=request.getParameter("reply");
       String date=String.valueOf(LocalDate.now());
       String id=request.getParameter("cid");
       
       MessageDTO msg=new MessageDTO();
       msg.setReply(reply);
       msg.setDate(date);
       msg.setId(id);
       
       FacultyResponseAuthenticator resp=new FacultyResponseAuthenticator();
       boolean send= resp.isSend(msg);
       
       if(send)
       {
            request.setAttribute("message", "Response Sent Successfully");
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/facultyRespond.jsp");
            rd.include(request, response); 
       }
       else
       {
           request.setAttribute("message","Response not Sent");
           RequestDispatcher rd=getServletContext().getRequestDispatcher("/facultyRespond.jsp");
           rd.include(request,response);
       }
   }
   
}
