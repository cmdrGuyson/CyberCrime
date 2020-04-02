package Controller;

import Model.HandleUser;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateUserStatusController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        updateUserStatus(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

    private void updateUserStatus(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HandleUser handleUser = new HandleUser();
        handleUser.changeStatus(request.getParameter("username"), request.getParameter("status"));
        RequestDispatcher dispatcher = request.getRequestDispatcher("ViewPendingUsersController");
        dispatcher.forward(request, response);
    }

}
