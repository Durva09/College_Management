package dao;

import db.DBConnector;
import dto.MessageDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class MessageDAO {
    
    public MessageDTO getComplains(String id)
    {
        DBConnector db=new DBConnector();
        Statement st=db.getStatement();
        MessageDTO msg=new MessageDTO();
        
        String query="select * from complain where complain_id='"+id+"'";
        try
        {
        ResultSet rs=st.executeQuery(query);
        while(rs.next())
        {
            msg.setSender(rs.getString("sender"));
            msg.setReciever(rs.getString("reciever"));
            msg.setMessage(rs.getString("message"));
            msg.setDate(rs.getString("complain_date"));
            msg.setId(rs.getString("complain_id"));
        }
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
        return msg;
    }
    
    public List<MessageDTO> getAllComplains(String username,String category)
    {
        List<MessageDTO> l1=new ArrayList<MessageDTO>();
        DBConnector db=new DBConnector();
        Statement st=db.getStatement();
        
        String query="select * from complain where reciever='"+username+"' and category='"+category+"' order by complain_id desc";
        try
        {
        ResultSet rs=st.executeQuery(query);
        while(rs.next())
        {
            MessageDTO msg=new MessageDTO();
            msg.setSender(rs.getString("sender"));
            msg.setReciever(rs.getString("reciever"));
            msg.setMessage(rs.getString("message"));
            msg.setDate(rs.getString("complain_date"));
            msg.setId(rs.getString("complain_id"));
            msg.setCategory(rs.getString("category"));
            l1.add(msg);
        }
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
        return l1;
    }
    
    
    public MessageDTO getNotice(String id)
    {
        DBConnector db=new DBConnector();
        Statement st=db.getStatement();
        MessageDTO msg=new MessageDTO();
        
        String query="select * from notice where nid='"+id+"'";
        try
        {
        ResultSet rs=st.executeQuery(query);
        while(rs.next())
        {
            msg.setMessage(rs.getString("message"));
            msg.setDate(rs.getString("date"));
        }
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
        return msg;
    }
    
    
    public List<MessageDTO> getAllNotices(String username,String sender,String reciever)
    {
        List<MessageDTO> l1=new ArrayList<MessageDTO>();
        DBConnector db=new DBConnector();
        Statement st=db.getStatement();
        
        String query="select * from notice where reciever='"+reciever+"' and sender='"+sender+"' order by nid desc";
        try
        {
        ResultSet rs=st.executeQuery(query);
        while(rs.next())
        {
            MessageDTO msg=new MessageDTO();
            msg.setSender(rs.getString("sender_id"));
            msg.setMessage(rs.getString("message"));
            msg.setDate(rs.getString("date"));
            msg.setId(rs.getString("nid"));
            l1.add(msg);
        }
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
        return l1;
    }
    
    
    public MessageDTO getAssignment(String id)
    {
        DBConnector db=new DBConnector();
        Statement st=db.getStatement();
        MessageDTO msg=new MessageDTO();
        
        String query="select * from assign where aid='"+id+"'";
        try
        {
        ResultSet rs=st.executeQuery(query);
        while(rs.next())
        {
            msg.setMessage(rs.getString("message"));
            msg.setDate(rs.getString("date"));
        }
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
        return msg;
    }
    
    
    public List<MessageDTO> getAllAssignments(String username,String sender,String reciever)
    {
        List<MessageDTO> l1=new ArrayList<MessageDTO>();
        DBConnector db=new DBConnector();
        Statement st=db.getStatement();
        
        String query="select * from assign where reciever='"+reciever+"' and sender='"+sender+"' order by aid desc";
        try
        {
        ResultSet rs=st.executeQuery(query);
        while(rs.next())
        {
            MessageDTO msg=new MessageDTO();
            msg.setSender(rs.getString("sender_id"));
            msg.setMessage(rs.getString("message"));
            msg.setDate(rs.getString("date"));
            msg.setId(rs.getString("aid"));
            l1.add(msg);
        }
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
        return l1;
    }
    
}
