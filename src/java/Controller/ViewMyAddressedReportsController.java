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
import javax.servlet.http.HttpSession;

/* Servlet to display officer's own addressed complaints */
public class ViewMyAddressedReportsController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        viewMyAddressedReports(request, response);
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

    private void viewMyAddressedReports(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HandleReport handleReport = new HandleReport();
        
        HttpSession session = request.getSession();

        // Getting the logged in officers addressed reports using his username from session data
        List<Report> addressedReports = handleReport.getMyAddressedReports((String) session.getAttribute("username"));

        // Set reports taken as request attributes
        request.setAttribute("addressedReports", addressedReports);
        
        // forward the request to officer-my-reports.jsp page
        RequestDispatcher dispatcher = request.getRequestDispatcher("officer-my-reports.jsp");
        dispatcher.forward(request, response);

    }
}
