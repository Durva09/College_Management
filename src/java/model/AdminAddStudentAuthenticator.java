package model;

import db.DBConnector;
import dto.StudentDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class AdminAddStudentAuthenticator {
    
    public boolean isInsrt(StudentDTO user)
    {
       DBConnector db=new DBConnector();
       Connection con=db.getConnection();
       PreparedStatement ps=null;
       Statement st=db.getStatement();
       String sno="";
       int no=0;
       
       String query="select max(sno) from student where branch='"+user.getBranch()+"'";
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
       String enrollment = user.getEnrollment()+sno;
        System.out.println("enroll"+sno+" "+no+" "+enrollment);
       query="insert into student values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
       try
       {
           ps=con.prepareStatement(query);
           ps.setString(1,enrollment);
           ps.setString(2,user.getUsername());
           ps.setString(3,user.getFather_name());
           ps.setString(4,user.getPassword());
           ps.setString(5,user.getGender());
           ps.setString(6,user.getAadhar());
           ps.setString(7,user.getBlood());
           ps.setString(8,user.getBranch());
           ps.setString(9,user.getYear());
           ps.setString(10,user.getEmail());
           ps.setString(11,user.getContact());
           ps.setString(12,user.getAddress());
           ps.setString(13,user.getDob());
           ps.setInt(14,0);
           ps.setString(15,"student");
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
