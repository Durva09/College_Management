package model;

import db.DBConnector;
import dto.MessageDTO;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;

@MultipartConfig(maxFileSize = 16177215)
public class FacultySendAssignmentAuthenticator {
    
    public boolean isSend(MessageDTO msg)
    {
       String sid=msg.getId();
       String message=msg.getMessage();
       String date=msg.getDate();
       String sender=msg.getSender();
       Part image=msg.getAssign();
       InputStream inputStream = null;
       
       DBConnector db=new DBConnector();
       Connection con=db.getConnection();
       
       String query="insert into assign(sender,reciever,sender_id,date,message,upfile,sender_name) values(?,?,?,?,?,?,?)";
       
       try
       {
        
        if(image!=null)
        {
           inputStream=image.getInputStream();
        
       PreparedStatement ps=con.prepareStatement(query);
       ps.setString(1,"faculty");
       ps.setString(2,"student");
       ps.setString(3,sid);
       ps.setString(4,date);
       ps.setString(5,message);
       ps.setBinaryStream(6,inputStream,inputStream.available());
       ps.setString(7,sender);
       int x=ps.executeUpdate();
       if(x>0)
       {
           return true;
       }
       }
       }
       catch(SQLException e)
       {
           System.out.println(e);
       }
       catch(IOException e)
       {
           System.out.println(e);
       }
    return false;
    }
}
