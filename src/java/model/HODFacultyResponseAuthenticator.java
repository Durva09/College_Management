package model;

import db.DBConnector;
import dto.MessageDTO;
import java.sql.SQLException;
import java.sql.Statement;

public class HODFacultyResponseAuthenticator {
    
    public boolean isSend(MessageDTO msg)
    {
       String date=msg.getDate();
       String result=msg.getReply();
       String id=msg.getId();
       
       String query="update complain set reply='"+result+"', reply_date='"+date+"' where complain_id='"+id+"'";
       
       DBConnector db=new DBConnector();
       Statement st=db.getStatement();
       
       try
       {
           System.out.println(query);
           int x=st.executeUpdate(query);
           if(x>0)
           {
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
