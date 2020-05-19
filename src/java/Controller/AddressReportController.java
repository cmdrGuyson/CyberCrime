package Controller;

import Model.HandleReport;
import Model.Report;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/* Servlet to handle precedure to address report */
public class AddressReportController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        
        HandleReport handleReport = new HandleReport();
        
        //Get username from session
        String handledOfficer = (String) session.getAttribute("username");
        
        //Get user entered data
        String officer_response = request.getParameter("response");
        String status = request.getParameter("status");
        int reportID = Integer.parseInt(request.getParameter("reportID"));

        //Create report object from user entered data
        Report report = new Report(reportID, status, officer_response, handledOfficer);

        //call addressReport() method using newly created report object
        handleReport.addressReport(report);

        //After addressing report, display other reports to be displayed
        response.sendRedirect("ViewAcceptedReportsController");
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
