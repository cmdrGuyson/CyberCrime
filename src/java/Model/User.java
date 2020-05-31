package Model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class User {
    
    private String username, email, password, firstName, lastName, typeOfUser, status, dateRegistered;
    
    /*Constructor Used In Registering User*/
    public User(String username, String email, String password, String firstName, String lastName) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.typeOfUser = "user";
        this.status = "Pending";
        
        /* Create a date formatter to convert java date to SQL friendly date */
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        
        /* Set date registered date to the present date after converting to simple date format */
        this.dateRegistered = formatter.format(new Date());
    }
     
    /*During login procedure*/
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    /*Constructor Used in User Authentication (Login)*/
    public User(String username, String password, String typeOfUser, String status) {
        this.username = username;
        this.password = password;
        this.typeOfUser = typeOfUser;
        this.status = status;
    }
    
    /* Constructor used when displaying user */
    public User(String username, String email, String firstName, String lastName, String status, String dateRegistered) {
        this.username = username;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.status = status;
        this.dateRegistered = dateRegistered;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTypeOfUser() {
        return typeOfUser;
    }

    public void setTypeOfUser(String typeOfUser) {
        this.typeOfUser = typeOfUser;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDateRegistered() {
        return dateRegistered;
    }

    public void setDateRegistered(String dateRegistered) {
        this.dateRegistered = dateRegistered;
    }
}
