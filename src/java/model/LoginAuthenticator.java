/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import db.DBConnector;
import dto.ManagementDTO;
import dto.StudentDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author 91934
 */
public class LoginAuthenticator {
    
    public boolean isLogin(StudentDTO user)
    {
        String username=user.getUsername();
        String password=user.getPassword();
        String category=user.getCategory();
        
        String tablepassword="";
        
        String query ="select password,category from student where enrollment='"+username+"'";
        
        DBConnector db=new DBConnector();
        Statement st=db.getStatement();
        
        try
        {
            ResultSet rs=st.executeQuery(query);
            if(rs.next())
            {
                System.out.println(query);
                tablepassword=rs.getString("password");
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
        if(username!=null && password!=null && !username.equals("")&& password.equals(tablepassword) && category.equals("student"))
        {
            return true;
        }
        return false;
        
    }
    
    public boolean isLogin(ManagementDTO user)
    {
        String username=user.getUsername();
        String password=user.getPassword();
        String category=user.getCategory();
       
        String tablepassword="",tablecategory="";
        
        String query ="select password,category from management where management_ID='"+username+"'";
        
        DBConnector db=new DBConnector();
        Statement st=db.getStatement();
        
        try
        {
            ResultSet rs=st.executeQuery(query);
            if(rs.next())
            {
                System.out.println(query);
                tablepassword=rs.getString("password");
                tablecategory=rs.getString("category");
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
        if(username!=null && password!=null && !username.equals("")&& password.equals(tablepassword) && category.equals(tablecategory))
        {
            return true;
        }
        return false;
        
    }
    
}