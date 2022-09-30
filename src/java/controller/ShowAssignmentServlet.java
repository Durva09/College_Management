package controller;

import dto.MessageDTO;
import java.io.IOException;
import java.io.OutputStream;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ShowAssignmentAuthenticator;

public class ShowAssignmentServlet extends HttpServlet {

    public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
    {
      String aid=request.getParameter("id");
      OutputStream outStream = response.getOutputStream();
      
      MessageDTO msg=new MessageDTO();
      msg.setId(aid);
      
      ShowAssignmentAuthenticator show=new ShowAssignmentAuthenticator();
      show.isDisplay(msg,outStream);
    }
}
