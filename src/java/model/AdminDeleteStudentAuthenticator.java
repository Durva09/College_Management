package model;

import db.DBConnector;
import dto.StudentDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;


public class AdminDeleteStudentAuthenticator {
    
    public boolean isDlt(StudentDTO user)
    {
       DBConnector db=new DBConnector();
       Connection con=db.getConnection();
       PreparedStatement ps=null;
       Statement st=db.getStatement();
       
       String query="delete from student where enrollment='"+user.getEnrollment()+"'";
        
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
