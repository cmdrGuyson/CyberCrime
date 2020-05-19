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

/* Servlet to handle the procedure of searching for reports to address */
public class SearchAcceptedReportsController extends HttpServlet {

@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        searchAcceptedReports(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

    private void searchAcceptedReports(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HandleReport handleReport = new HandleReport();
        
        /*call searchReportsOfficer() method on handle report using user entered search string and get
        list of reports*/
        List<Report> reports = handleReport.searchReportsOfficer(request.getParameter("searchString"));

        //set the list of reports obtained as request's attributes and forwarded to officer-dashboard.jsp
        request.setAttribute("acceptedReports", reports);
        RequestDispatcher dispatcher = request.getRequestDispatcher("officer-dashboard.jsp");
        dispatcher.forward(request, response);

    }
}
