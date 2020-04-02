/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.HandleReport;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateReportStatusController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        updateReportStatus(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

    private void updateReportStatus(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HandleReport handleReport = new HandleReport();
        handleReport.changeStatus(request.getParameter("reportID"), request.getParameter("status"));
        RequestDispatcher dispatcher = request.getRequestDispatcher("ViewPendingReportsController");
        dispatcher.forward(request, response);
    }

}
