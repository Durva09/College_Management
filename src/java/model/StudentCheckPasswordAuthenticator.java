package model;

import db.DBConnector;
import dto.StudentDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentCheckPasswordAuthenticator {
  public boolean isCorrect(StudentDTO student)
  {
      String current=student.getPassword();
      String username=student.getUsername();
      String password="";
      
      String query ="select password from student where enrollment='"+username+"'";
        
      DBConnector db=new DBConnector();
      Statement st=db.getStatement();
        
        try
        {
            ResultSet rs=st.executeQuery(query);
            if(rs.next())
            {
                password=rs.getString("password");
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
        
        if(password.equals(current))
        {
            return true;
        }
    return false;    
  }
}
