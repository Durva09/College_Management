package model;

import db.DBConnector;
import dto.StudentDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AdminUpdateStudentAuthenticator {
    
    public boolean isUpdt(StudentDTO user)
    {
       DBConnector db=new DBConnector();
       Connection con=db.getConnection();
       PreparedStatement ps=null;
       
       String query="update student set name=?, father_name=?, gender=?, aadhar_no=?, blood_group=?, branch=?, admission_year=?, mail_id=?, contact=?, address=?, dob=? where enrollment='"+user.getEnrollment()+"'";
       try
       {
           ps=con.prepareStatement(query);
           ps.setString(1,user.getUsername());
           ps.setString(2,user.getFather_name());
           ps.setString(3,user.getGender());
           ps.setString(4,user.getAadhar());
           ps.setString(5,user.getBlood());
           ps.setString(6,user.getBranch());
           ps.setString(7,user.getYear());
           ps.setString(8,user.getEmail());
           ps.setString(9,user.getContact());
           ps.setString(10,user.getAddress());
           ps.setString(11,user.getDob());
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
