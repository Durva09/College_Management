package model;

import db.DBConnector;
import dto.ManagementDTO;
import dto.StudentDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;


public class AdminDeleteFacultyAuthenticator {
    
    public boolean isDlt(ManagementDTO user)
    {
       DBConnector db=new DBConnector();
       Connection con=db.getConnection();
       PreparedStatement ps=null;
       Statement st=db.getStatement();
       
       String query="delete from management where management_ID='"+user.getID()+"'";
        
       try
       {
           int x=st.executeUpdate(query);
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
