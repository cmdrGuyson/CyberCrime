package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SendHomeController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accountType = null;

        if (request.getSession().getAttribute("typeOfUser") != null) {
            accountType = (String) request.getSession().getAttribute("typeOfUser");

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
