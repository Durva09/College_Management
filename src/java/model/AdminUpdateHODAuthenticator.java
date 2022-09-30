package model;

import db.DBConnector;
import dto.ManagementDTO;
import dto.StudentDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AdminUpdateHODAuthenticator {
    
    public boolean isUpdt(ManagementDTO user)
    {
       DBConnector db=new DBConnector();
       Connection con=db.getConnection();
       PreparedStatement ps=null;
       
       String query="update management set name=?, contact=?, gender=?, aadhar_no=?, blood_group=?, department=?, qualification=?, experience=?, joining_year=?, designation=?, address=?, mail_id=?, dob=? where management_ID='"+user.getID()+"'";
       try
       {
           ps=con.prepareStatement(query);
           ps.setString(1,user.getUsername());
           ps.setString(2,user.getContact());
           ps.setString(3,user.getGender());
           ps.setString(4,user.getAadhar());
           ps.setString(5,user.getBlood_group());
           ps.setString(6,user.getDepartment());
           ps.setString(7,user.getQualification());
           ps.setString(8,user.getExperience());
           ps.setString(9,user.getYear());
           ps.setString(10,user.getDesignation());
           ps.setString(11,user.getAddress());
           ps.setString(12,user.getEmail());
           ps.setString(13,user.getDob());
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
