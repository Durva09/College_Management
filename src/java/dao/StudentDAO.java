package dao;

import db.DBConnector;
import dto.StudentDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    
    public StudentDTO getUserData(String username)
    {
        StudentDTO user=new StudentDTO();
        DBConnector db=new DBConnector();
        
        String query="select * from student where enrollment='"+username+"'";
        
        try{
        Statement st=db.getStatement();
        ResultSet rs=st.executeQuery(query);
        while(rs.next())
        {
            user.setEnrollment(rs.getString("enrollment"));
            user.setUsername(rs.getString("name"));
            user.setGender(rs.getString("gender"));
            user.setBranch(rs.getString("branch"));
            user.setEmail(rs.getString("mail_id"));
            user.setContact(rs.getString("contact"));
            user.setYear(rs.getString("admission_year"));
            user.setFather_name(rs.getString("father_name"));
            user.setAadhar(rs.getString("aadhar_no"));
            user.setBlood(rs.getString("blood_group"));
            user.setAddress(rs.getString("address"));
            user.setDob(rs.getString("dob"));
        }
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
        return user;
    }
    
    public List<StudentDTO> getAllUserData()
    {
        DBConnector db=new DBConnector();
        List<StudentDTO> listOfStudents=new ArrayList<StudentDTO>();
        String query="select * from student";
        
        try{
        Statement st=db.getStatement();
        ResultSet rs=st.executeQuery(query);
        while(rs.next())
        {
            StudentDTO user=new StudentDTO();
            user.setEnrollment(rs.getString("enrollment"));
            user.setUsername(rs.getString("name"));
            user.setGender(rs.getString("gender"));
            user.setBranch(rs.getString("branch"));
//            user.setEmail(rs.getString("mail_id"));
//            user.setContact(rs.getString("contact"));
            user.setYear(rs.getString("admission_year"));
//            user.setFather_name(rs.getString("father_name"));
//            user.setAadhar(rs.getString("aadhar_no"));
//            user.setBlood(rs.getString("blood_group"));
//            user.setAddress(rs.getString("address"));
//            user.setDob(rs.getString("dob"));
            listOfStudents.add(user);
        }
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
        return listOfStudents;
    }
    
}
