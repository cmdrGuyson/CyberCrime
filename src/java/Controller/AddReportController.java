package Controller;

import Model.HandleReport;
import Model.Report;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/* Servlet to make a report */
public class AddReportController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //Upon post call addReport function
        addReport(request, response);
        
    }
    
    private void addReport(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        //Get session information
        HttpSession session = request.getSession();
                
        HandleReport handleReport = new HandleReport();
        
        //Get username from session information
        String username = (String) session.getAttribute("username");
        
        //Get user entered data from request
        String description = request.getParameter("description");
        String typeOfCrime = request.getParameter("typeOfCrime");
        String estimatedDateOfCrime = request.getParameter("estimatedDateOfCrime");
        
        //Create a new report from data
        Report report = new Report(description, typeOfCrime, username, estimatedDateOfCrime);
        
        //call addReport method using created report
        handleReport.addReport(report);
        
        //Send to succesfull addition of report page
        RequestDispatcher dispatcher = request.getRequestDispatcher("util/successful-report.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
