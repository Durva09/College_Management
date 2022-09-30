package model;

import db.DBConnector;
import dto.StudentDTO;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentChangePasswordAuthenticator {

    public boolean isUpdt(StudentDTO user)
    {
        String newpass=user.getPassword();
        String username=user.getUsername();
        String query="update student set password='"+newpass+"' where enrollment='"+username+"'";
        
        DBConnector db=new DBConnector();
        Statement st=db.getStatement();
        try
        {
           int x=st.executeUpdate(query);
           if(x>0)
           {
               System.out.println(newpass+" "+username);
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
