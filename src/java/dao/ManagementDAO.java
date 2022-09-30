package dao;

import db.DBConnector;
import dto.ManagementDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ManagementDAO {
    
    public ManagementDTO getUserData(String id)
    {
        ManagementDTO user=new ManagementDTO();
        DBConnector db=new DBConnector();
        
        String query="select * from management where management_ID='"+id+"'";
        
        try{
        Statement st=db.getStatement();
        ResultSet rs=st.executeQuery(query);
        while(rs.next())
        {
            user.setID(id);
            user.setUsername(rs.getString("name"));
            user.setDepartment(rs.getString("department"));
            user.setDesignation(rs.getString("designation"));
            user.setGender(rs.getString("Gender"));
            user.setContact(rs.getString("contact"));
            user.setEmail(rs.getString("mail_id"));
            user.setYear(rs.getString("joining_year"));
            user.setQualification(rs.getString("qualification"));
            user.setAadhar(rs.getString("aadhar_no"));
            user.setBlood_group(rs.getString("blood_group"));
            user.setAddress(rs.getString("address"));
            user.setDob(rs.getString("dob"));
            user.setExperience(rs.getString("experience"));
        }
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
        return user;
    }
    
    
    public List<ManagementDTO> getAllUserData(String category)
    {
        DBConnector db=new DBConnector();
        List<ManagementDTO> listOfFaculties=new ArrayList<ManagementDTO>();
        String query="select * from management where category='"+category+"'";
        
        try{
        Statement st=db.getStatement();
        ResultSet rs=st.executeQuery(query);
        while(rs.next())
        {
            ManagementDTO user=new ManagementDTO();
            user.setID(rs.getString("Management_ID"));
            user.setUsername(rs.getString("name"));
            user.setQualification(rs.getString("qualification"));
            user.setDepartment(rs.getString("department"));
//            user.setEmail(rs.getString("mail_id"));
//            user.setContact(rs.getString("contact"));
            user.setDesignation(rs.getString("designation"));
//            user.setFather_name(rs.getString("father_name"));
//            user.setAadhar(rs.getString("aadhar_no"));
//            user.setBlood(rs.getString("blood_group"));
//            user.setAddress(rs.getString("address"));
//            user.setDob(rs.getString("dob"));
            listOfFaculties.add(user);
        }
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
        return listOfFaculties;
    }
    
}
