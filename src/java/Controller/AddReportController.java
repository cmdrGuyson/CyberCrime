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


public class AddReportController extends HttpServlet {


    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        addReport(request, response);
        
    }
    
    private void addReport(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        HttpSession session = request.getSession();
                
        HandleReport handleReport = new HandleReport();
        
        String username = (String) session.getAttribute("username");
        String description = request.getParameter("description");
        String typeOfCrime = request.getParameter("typeOfCrime");
        String estimatedDateOfCrime = request.getParameter("estimatedDateOfCrime");
        
        Report report = new Report(description, typeOfCrime, username, estimatedDateOfCrime);
        
        handleReport.addReport(report);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("util/successful-report.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
