package Controller;

import Model.HandleReport;
import Model.Report;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

        String handledOfficer = (String) session.getAttribute("username");
        String officer_response = request.getParameter("response");
        String status = request.getParameter("status");
        int reportID = Integer.parseInt(request.getParameter("reportID"));

        Report report = new Report(reportID, status, officer_response, handledOfficer);

        handleReport.addressReport(report);

        response.sendRedirect("ViewAcceptedReportsController");
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
