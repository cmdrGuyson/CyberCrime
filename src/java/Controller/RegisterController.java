package Controller;

import Model.HandleUser;
import Model.User;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* Used to handle registration procedure on form submit */
public class RegisterController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            registerUser(request, response);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    private void registerUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {

        // Get data from request parameters
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String type = request.getParameter("type");
        String email = request.getParameter("email");
        String organizationName = request.getParameter("organizationName");
        
        //If an organization is registering the organization name will be added within brackets to the last name of the HR-Manager
        if (!type.equals("Individual")){
            lastName += " ("+organizationName+")";
        }
        
        try {

            HandleUser handleUser = new HandleUser();
            
            //User object is created using user entered form data and this object is used to register user using handleUser object
            User user = new User(username, email, password, firstName, lastName);
            handleUser.registerUser(user);

        } catch (MySQLIntegrityConstraintViolationException e) {

            /*If user is trying to create an account with an existing username or password MySQLIntegrityConstraintViolationException is thrown
            from registerUser() method. It is caught here and user sent to same-account.jsp page */
            
            System.out.println(e);
            RequestDispatcher dispatcher = request.getRequestDispatcher("util/same-account.jsp");
            dispatcher.forward(request, response);
            return;
        }

        //After successfull registration user is sent to successful-register.jsp page
        RequestDispatcher dispatcher = request.getRequestDispatcher("util/successful-register.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
