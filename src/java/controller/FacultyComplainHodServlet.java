package controller;

import dto.MessageDTO;
import java.io.IOException;
import java.time.LocalDate;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.FacultyComplainHodAuthenticator;
public class FacultyComplainHodServlet extends HttpServlet {

    public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
    {
        response.sendRedirect("login.html");
    }
    public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
    {
        String sender=request.getParameter("sender");
        String reciever=request.getParameter("reciever");
        String message=request.getParameter("message");
        String date=String.valueOf(LocalDate.now());
        
        MessageDTO msg=new MessageDTO();
        msg.setSender(sender);
        msg.setReciever(reciever);
        msg.setMessage(message);
        msg.setDate(date);
        
        FacultyComplainHodAuthenticator complain = new FacultyComplainHodAuthenticator();
        boolean send= complain.isSend(msg);
        if(send)
        {
        request.setAttribute("message", "Complain Sent Successfully");
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/facultyComplainHod.jsp");
        rd.include(request, response); 
        }
        else
        {
        request.setAttribute("message", "Complain cannot be Forwarded");
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/facultyComplainHod.jsp");
        rd.include(request, response); 
        }
    }
}
