
package controller;

import DB.DB_Manager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;


@ManagedBean
@RequestScoped
public class SignUpBean
{

   
    private String username;
    private String password;
    
    
    
    public SignUpBean()
    {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
    public void InsertData()
    {
        try
        {
            DB_Manager dbm  =  new DB_Manager();
            String Q="INSERT INTO `users` (`username`, `password`) VALUES("+"'"+username+"'"+","+"'"+password+"'"+")";
            
            dbm.InsertUpdateDelete(Q);
            
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "New record has inserted", null);
            FacesContext.getCurrentInstance().addMessage(null,  facesMessage);
            
            
        }
        
        catch(Exception ex)
        {
            String  message = ex.getMessage();
            
            
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, message, null);
            FacesContext.getCurrentInstance().addMessage(null,  facesMessage);
            
    }
    
    }
}
