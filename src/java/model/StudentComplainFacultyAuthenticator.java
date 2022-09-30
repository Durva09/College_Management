package model;

import db.DBConnector;
import dto.MessageDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class StudentComplainFacultyAuthenticator {
    
    public boolean isSend(MessageDTO msg)
    {
       String sender=msg.getSender();
       String reciever=msg.getReciever();
       String message=msg.getMessage();
       String date=msg.getDate();
       
       DBConnector db=new DBConnector();
       Connection con=db.getConnection();
       
       String query="insert into complain(sender,reciever,message,complain_date,category) values(?,?,?,?,?)";
       
       try
       {
       PreparedStatement ps=con.prepareStatement(query);
       ps.setString(1,sender);
       ps.setString(2,reciever);
       ps.setString(3,message);
       ps.setString(4,date);
       ps.setString(5,"student");
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
