package Controller;

import Model.HandleReport;
import Model.Report;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewAcceptedReportsController extends HttpServlet {

@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        viewAcceptedReports(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

    private void viewAcceptedReports(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HandleReport handleReport = new HandleReport();

        List<Report> acceptedReports = handleReport.getReports("In-progress");

        request.setAttribute("acceptedReports", acceptedReports);
        RequestDispatcher dispatcher = request.getRequestDispatcher("officer-dashboard.jsp");
        dispatcher.forward(request, response);

    }
}
