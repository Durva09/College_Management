package controller;

import dto.MessageDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import model.FacultySendAssignmentAuthenticator;

@MultipartConfig(maxFileSize = 16177215)
public class FacultySendAssignmentServlet extends HttpServlet {

    public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
    {
        response.sendRedirect("login.html");
    }
    public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
    {
        String message=request.getParameter("message");
        String rid=request.getParameter("rid");
        String date=String.valueOf(LocalDate.now());
        String uname=request.getParameter("user");
        PrintWriter out=response.getWriter();
        Part fp=request.getPart("userfile");
        
        MessageDTO msg=new MessageDTO();
        msg.setId(rid);
        msg.setMessage(message);
        msg.setDate(date);
        msg.setSender(uname);
        msg.setAssign(fp);
        
        FacultySendAssignmentAuthenticator noti=new FacultySendAssignmentAuthenticator();
        boolean send=noti.isSend(msg);
        if(send)
        {
            request.setAttribute("message", "Assignment Sent Successfully");
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/facultySendAssignment.jsp");
            rd.include(request, response);
        }
        else
        {
            request.setAttribute("message", "Assignment not Sent ");
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/facultySendAssignment.jsp");
            rd.include(request, response);
        }
    }
}
