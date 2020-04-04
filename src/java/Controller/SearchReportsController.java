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

public class SearchReportsController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        searchReports(request, response);
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

    private void searchReports(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HandleReport handleReport = new HandleReport();

        List<Report> reports = handleReport.searchReports(request.getParameter("searchString"));
        
        request.setAttribute("reports", reports);
        RequestDispatcher dispatcher = request.getRequestDispatcher("searched-reports.jsp");
        dispatcher.forward(request, response);
    }   
}
