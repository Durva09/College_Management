package model;

import db.DBConnector;
import dto.MessageDTO;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Admin
 */
public class ShowAssignmentAuthenticator {
   
    private static final int BUFFER_SIZE = 4096;  
    
    public void isDisplay(MessageDTO msg, OutputStream out)
    {
      DBConnector db=new DBConnector();
      Statement st=db.getStatement();
      
      String query="select * from assign where aid='"+msg.getId()+"'";
      try
      {
          ResultSet rs=st.executeQuery(query);
          if (rs.next()) {
                Blob blob = rs.getBlob("upfile");
                InputStream inputStream = blob.getBinaryStream();
                
                OutputStream outStream=out;
                 
                byte[] buffer = new byte[BUFFER_SIZE];
                int bytesRead = -1;
                 
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outStream.write(buffer, 0, bytesRead);
                }
                 
                inputStream.close();
                outStream.close();             
            }
          
      }
      catch(SQLException e)
      {
          System.out.println(e);
      }
      catch(IOException e)
      {
          System.out.println(e);
      }
      
    }
}
