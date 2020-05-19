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

/* Display progress of reports made by registered users */
public class ViewMyReportsController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        viewMyReports(request, response);
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

    private void viewMyReports(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HandleReport handleReport = new HandleReport();
        
        HttpSession session = request.getSession();

        // Call getMyReports() function on handleReport object using username taken from session data
        List<Report> myReports = handleReport.getMyReports((String) session.getAttribute("username"));
        
        // Set list of reports taken as request attribute
        request.setAttribute("myReports", myReports);
        
        //forward request to user-my-reports.jsp page
        RequestDispatcher dispatcher = request.getRequestDispatcher("user-my-reports.jsp");
        dispatcher.forward(request, response);

    }
    
}
