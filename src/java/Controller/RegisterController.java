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

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");

        try {

            HandleUser handleUser = new HandleUser();
            User user = new User(username, email, password, firstName, lastName);
            handleUser.registerUser(user);

        } catch (MySQLIntegrityConstraintViolationException e) {

            System.out.println(e);
            RequestDispatcher dispatcher = request.getRequestDispatcher("util/same-account.jsp");
            dispatcher.forward(request, response);
            return;

        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("util/successful-register.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
