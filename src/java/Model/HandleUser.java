package Model;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class HandleUser {

    private final Connection connection;

    public HandleUser() {

        connection = Database_Connection.connectToDatabase();

    }

    public void registerUser(User user) throws MySQLIntegrityConstraintViolationException {

        try {

            PreparedStatement statement = connection.prepareStatement("INSERT INTO user (username, email, password, firstName, lastName, dateRegistered, typeOfUser, status)" + " VALUES (?,?,?,?,?,?,?,?);");

            statement.setString(1, user.getUsername());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassword());
            statement.setString(4, user.getFirstName());
            statement.setString(5, user.getLastName());
            statement.setString(6, user.getDateRegistered());
            statement.setString(7, user.getTypeOfUser());
            statement.setString(8, user.getStatus());

            statement.execute();

        } catch (MySQLIntegrityConstraintViolationException e) {
            throw e;
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public String authenticateUser(User user) {

        try {

            PreparedStatement statement = connection.prepareStatement("SELECT username, password, status, typeOfUser FROM user");
            ResultSet results = statement.executeQuery();

            while (results.next()) {

                /* GETTING USER CREDECTIALS FROM DATABSE AND CREATING NEW USER OBJECT TO STORE DATA */
                User selectedUser = new User(results.getString("username"), results.getString("password"), results.getString("typeOfUser"), results.getString("status"));

                if (user.getUsername().equals(selectedUser.getUsername()) && user.getPassword().equals(selectedUser.getPassword())) {

                    if (selectedUser.getTypeOfUser().equals("admin")) {
                        return "admin";
                    } else if (selectedUser.getTypeOfUser().equals("officer")) {
                        return "officer";
                    } else if (selectedUser.getTypeOfUser().equals("user") && selectedUser.getStatus().equals("Active")) {
                        return "user";
                    } else if (selectedUser.getTypeOfUser().equals("user") && selectedUser.getStatus().equals("Pending")) {
                        return "pending-user";
                    } else if ((selectedUser.getTypeOfUser().equals("user") && selectedUser.getStatus().equals("Inactive"))) {
                        return "inactive-user";
                    }
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return "invalid";
    }

    public List<User> getPendingUsers() {

        List<User> pendingUsers = new ArrayList<>();

        try {

            PreparedStatement statement = connection.prepareStatement("SELECT username, email, firstName, lastName, dateRegistered, status FROM user WHERE status = 'Pending';");
            ResultSet results = statement.executeQuery();

            while (results.next()) {

                User user = new User(results.getString("username"), results.getString("email"), results.getString("firstName"), results.getString("lastName"), results.getString("status"), results.getString("dateRegistered"));
                pendingUsers.add(user);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return pendingUsers;
    }
    
    public void changeStatus(String username, String status) {
        
        try {
            
            PreparedStatement statement = connection.prepareCall("UPDATE user SET status = ? WHERE username = ?;");
            
            statement.setString(1, status);
            statement.setString(2, username);
            
            statement.executeUpdate();
            
        }catch(Exception e){
            System.out.println(e);
        }   
        
    }
}
