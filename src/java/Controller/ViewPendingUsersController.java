package Controller;

import Model.HandleUser;
import Model.User;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewPendingUsersController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        viewPendingUsers(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

    private void viewPendingUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HandleUser handleUser = new HandleUser();

        List<User> pendingUsers = handleUser.getPendingUsers();

        request.setAttribute("pendingUsers", pendingUsers);
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin-dashboard-user.jsp");
        dispatcher.forward(request, response);

    }
}
