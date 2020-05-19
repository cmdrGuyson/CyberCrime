package Model;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HandleUser {

    private final Connection connection;

    public HandleUser() {

        /*Make connection upon instantiation*/
        connection = Database_Connection.connectToDatabase();

    }

    /* Method to register users */
    public void registerUser(User user) throws MySQLIntegrityConstraintViolationException {

        try {

            /* Statement to be executed to register specific user */
            PreparedStatement statement = connection.prepareStatement("INSERT INTO user (username, email, password, firstName, lastName, dateRegistered, typeOfUser, status)" + " VALUES (?,?,?,?,?,?,?,?);");

            /* customize statement according to recieved user object */
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
            System.out.println(e);
            
            /* This exception will be thrown if users with same username or email exists within the system. */
            throw e;
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public String authenticateUser(User user) {

        try {

            /* Statement to be executed to get all users */
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

        } catch (SQLException e) {
            System.out.println(e);
        }

        return "invalid";
    }

    public List<User> getPendingUsers() {

        List<User> pendingUsers = new ArrayList<>();

        try {

            /* Statement to be executed to get a list of pending users */
            PreparedStatement statement = connection.prepareStatement("SELECT username, email, firstName, lastName, dateRegistered, status FROM user WHERE status = 'Pending';");
            ResultSet results = statement.executeQuery();

            while (results.next()) {

                User user = new User(results.getString("username"), results.getString("email"), results.getString("firstName"), results.getString("lastName"), results.getString("status"), results.getString("dateRegistered"));
                pendingUsers.add(user);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return pendingUsers;
    }
    
    public void changeStatus(String username, String status) {
        
        try {
            
            /* Statement to be executed to update the status of specific user */
            PreparedStatement statement = connection.prepareCall("UPDATE user SET status = ? WHERE username = ?;");
            
            statement.setString(1, status);
            statement.setString(2, username);
            
            statement.executeUpdate();
            
        }catch(SQLException e){
            System.out.println(e);
        }   
        
    }
}
