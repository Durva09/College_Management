package controller;

import dto.MessageDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.FacultySendNoticeAuthenticator;

public class FacultySendNoticeServlet extends HttpServlet {

    public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
    {
        response.sendRedirect("login.html");
    }
    public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
    {
        String message=request.getParameter("message");
        String rid=request.getParameter("rid");
        String date=String.valueOf(LocalDate.now());
        PrintWriter out=response.getWriter();
        
        MessageDTO msg=new MessageDTO();
        msg.setSender(rid);
        msg.setMessage(message);
        msg.setDate(date);
        
        FacultySendNoticeAuthenticator noti=new FacultySendNoticeAuthenticator();
        boolean send=noti.isSend(msg);
        System.out.println("hello");
        if(send)
        {
            request.setAttribute("message", "Notice Sent Successfully");
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/facultySendNoticeStudent.jsp");
            rd.include(request, response);
        }
        else
        {
            request.setAttribute("message", "Notice not Sent ");
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/facultySendNoticeStudent.jsp");
            rd.include(request, response);
        }
    }
}
