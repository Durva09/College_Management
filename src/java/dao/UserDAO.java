package dao;

import db.DBConnector;
import dto.UserDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class UserDAO {
    public UserDTO getUserData(String username,String category)
    {
        DBConnector db = new DBConnector();
        UserDTO user=new UserDTO();
        try
        {
            Statement st=db.getStatement();
            String query="select * from "+category+" where username='"+username+"'";
            ResultSet rs=st.executeQuery(query);
            while(rs.next())
            {
                user.setUsername(rs.getString("username"));
                user.setCategory(rs.getString("category"));
            }
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
        return user;
    }
}
