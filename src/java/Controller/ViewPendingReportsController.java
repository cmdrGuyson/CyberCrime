package Controller;

import Model.HandleReport;
import Model.Report;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewPendingReportsController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        viewPendingReports(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

    private void viewPendingReports(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HandleReport handleReport = new HandleReport();

        List<Report> pendingReports = handleReport.getPendingReports();

        request.setAttribute("pendingReports", pendingReports);
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin-dashboard.jsp");
        dispatcher.forward(request, response);

    }

}
