package Controller;

import Model.HandleUser;
import Model.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/* Servlet to handle login procedure */
public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //Create user object from user entered data
        User user = new User(request.getParameter("username"), request.getParameter("password"));

        HandleUser handleUser = new HandleUser();

        String accountType = null;

        try {
            
            //Authenticate user by using handleUser object.
            accountType = handleUser.authenticateUser(user);
            
        } catch (Exception e) {
            System.out.println(e);
        }

        HttpSession session = request.getSession();
        
        session.setAttribute("username", user.getUsername());
        
        switch (accountType) {
            
            //Assign attributes to session and redirect to respective home pages
            
            case "admin":
                session.setAttribute("typeOfUser", "admin");
                response.sendRedirect("home-admin.jsp");
                break;
            case "officer":
                session.setAttribute("typeOfUser", "officer");
                response.sendRedirect("home-officer.jsp");
                break;
            case "user":
                session.setAttribute("typeOfUser", "user");
                response.sendRedirect("home-user.jsp");
                break;
            case "pending-user":
                request.getRequestDispatcher("util/pending-account.jsp").include(request, response);
                break;
            case "inactive-user":
                request.getRequestDispatcher("util/account-deactivated.jsp").include(request, response);
                break;
            default:
                request.getRequestDispatcher("util/no-account.jsp").include(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
