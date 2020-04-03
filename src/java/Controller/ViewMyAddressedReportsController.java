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

        List<Report> addressedReports = handleReport.getMyAddressedReports((String) session.getAttribute("username"));

        request.setAttribute("addressedReports", addressedReports);
        RequestDispatcher dispatcher = request.getRequestDispatcher("officer-my-reports.jsp");
        dispatcher.forward(request, response);

    }
    
}
