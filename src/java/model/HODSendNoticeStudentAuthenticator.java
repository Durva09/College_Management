package model;

import db.DBConnector;
import dto.MessageDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class HODSendNoticeStudentAuthenticator {
    
    public boolean isSend(MessageDTO msg)
    {
       String sender=msg.getSender();
       String message=msg.getMessage();
       String date=msg.getDate();
       
       DBConnector db=new DBConnector();
       Connection con=db.getConnection();
       
       String query="insert into notice(reciever,sender,sender_id,date,message) values(?,?,?,?,?)";
       
       try
       {
       PreparedStatement ps=con.prepareStatement(query);
       ps.setString(1,"student");
       ps.setString(2,"hod");
       ps.setString(3,sender);
       ps.setString(4,date);
       ps.setString(5,message);
       int x=ps.executeUpdate();
       if(x>0)
       {
           return true;
       }
       }
       catch(SQLException e)
       {
           System.out.println(e);
       }
    return false;
    }
}
