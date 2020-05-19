package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* This servlet directs users to their respective homepage depending on session data. */
public class SendHomeController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accountType = null;

        // Session attribute of typeOfUser is taken and checked if user is logged in
        if (request.getSession().getAttribute("typeOfUser") != null) {
            accountType = (String) request.getSession().getAttribute("typeOfUser");

            //User is directed to their respective home page
            switch (accountType) {
                case "admin":
                    response.sendRedirect("home-admin.jsp");
                    break;
                case "officer":
                    response.sendRedirect("home-officer.jsp");
                    break;
                case "user":
                    response.sendRedirect("home-user.jsp");
                    break;
            }

        } else {
            //If user is not logged in, they are directed to default home page
            response.sendRedirect("index.jsp");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
