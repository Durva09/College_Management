package model;

import db.DBConnector;
import dto.ManagementDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class AdminAddHODAuthenticator {
    
    public boolean isInsrt(ManagementDTO user)
    {
       DBConnector db=new DBConnector();
       Connection con=db.getConnection();
       PreparedStatement ps=null;
       Statement st=db.getStatement();
       String sno="";
       int no=0;
       
       String query="select max(sno) from management where category='hod'";
       try
       {
           ResultSet rs=st.executeQuery(query);
           if(rs.next())
           {
               no=rs.getInt(1);
           }
       }
       catch(SQLException e)
       {
           System.out.println(e);  
       }
       
       sno=(no<10)?"0"+no : String.valueOf(no);
       String id = user.getID()+sno;
       query="insert into management values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
       try
       {
           ps=con.prepareStatement(query);
           ps.setString(1,id);
           ps.setString(2,user.getUsername());
           ps.setString(3,user.getContact());
           ps.setString(4,user.getPassword());
           ps.setString(5,user.getGender());
           ps.setString(6,user.getAadhar());
           ps.setString(7,user.getBlood_group());
           ps.setString(8,user.getDepartment());
           ps.setString(9,user.getQualification());
           ps.setString(10,user.getExperience());
           ps.setString(11,user.getYear());
           ps.setString(12,user.getDesignation());
           ps.setString(13,user.getAddress());
           ps.setString(14,user.getDob());
           ps.setString(15,"hod");
           ps.setString(16,user.getEmail());
           ps.setInt(17,0);
           int x=ps.executeUpdate();
           if(x>0)
           {
               return true;
           }
           else
           {
               return false;
           }
       }
       catch(SQLException e)
       {
           System.out.println(e);
       }
       return false;
    }
}
