<%-- 
    Document   : admin-dashboard
    Created on : Apr 1, 2020, 9:00:30 PM
    Author     : Ebisu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>CyberCrime | Dashboard</title>
        <script
            src="https://kit.fontawesome.com/b9bf971455.js"
            crossorigin="anonymous"
        ></script>
        <link
            rel="stylesheet"
            href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
            integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
            crossorigin="anonymous"
            />
        <link rel="stylesheet" type="text/css" href="css/index.css" />
        <link rel="icon" href="images/hacker.png" />
    </head>
    
    <%
        String type = (String) request.getSession().getAttribute("typeOfUser");

        if (type == "admin") {

    %>
    
    <body>
        <!--Navigation Bar-->

        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="#">
                <img src="images/hacker.png" width="40" height="40" alt="" />
            </a>
            <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                <div class="navbar-nav">
                    <a class="nav-item nav-link" href="home-admin.jsp"
                       >Home</a
                    >
                    <a class="nav-item nav-link" href="ViewPublishedReportsController">Published Reports</a>
                    <a class="nav-item nav-link" href="contact-us.jsp">Contact</a>
                </div>
            </div>
            <%@ include file="util/search-form.jsp" %>
            <button
                class="btn btn-outline-danger my-2 my-sm-0 disabled"
                type="submit"
                >
                Dashboard
            </button>
            <a href="LogoutController" data-toggle="tooltip" title="Sign out">
                <i class="fas fa-sign-out-alt fa-lg"></i>
            </a>
        </nav>

        <!--Content-->


        <div class="container content">
            <h6 class="display-4">Pending Reports</h6>
            <br />

            <a
                class="btn btn-outline-warning my-2 my-sm-0" href="ViewPendingUsersController"
                >
                Manage Users
            </a>

            <br /><br />


            <!--Table-->
            <div class="row dash-row">
                <div class="container-dash">
                    <table class="table table-striped">
                        <thead class="thead-dark">
                            <tr>
                                <th width="10%" scope="col">Report ID</th>
                                <th width="10%" scope="col">Username</th>
                                <th width="10%" scope="col">Full Name</th>
                                <th width="10%" scope="col">Email</th>
                                <th width="10%" scope="col">Date Of Crime</th>
                                <th width="10%" scope="col">Reported Date</th>
                                <th width="10%" scope="col">Type</th>
                                <th width="50%" scope="col">Description</th>
                                <th width="10%" scope="col">Status</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="report" items="${pendingReports}">

                                <c:url var="accept" value="UpdateReportStatusController">
                                    <c:param name="status" value="In-progress"/> 
                                    <c:param name="reportID" value="${report.getReportID()}"/>
                                </c:url>

                                <c:url var="decline" value="UpdateReportStatusController">
                                    <c:param name="status" value="Rejected"/> 
                                    <c:param name="reportID" value="${report.getReportID()}"/>
                                </c:url>

                                <tr>
                                    <th scope="row">${report.getReportID()}</th>
                                    <td>${report.getUsername()}</td>
                                    <td>${report.getFullName()}</td>
                                    <td>${report.getEmail()}</td>
                                    <td>${report.getEstimatedDateOfCrime()}</td>
                                    <td>${report.getReportedDate()}</td>
                                    <td>${report.getTypeOfCrime()}</td>
                                    <td>${report.getDescription()}</td>
                                    <td>${report.getStatus()}</td>
                                    <td>
                                        <a href="${accept}" data-toggle="tooltip" title="Accept">
                                            <i class="fas fa-check-circle"></i>
                                        </a>
                                        <a href="${decline}" data-toggle="tooltip" title="Decline">
                                            <i class="fas fa-ban"></i>
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>

        <%@ include file="util/footer.html" %>

    </body>
    
    <%    } else {

            RequestDispatcher dispatcher = request.getRequestDispatcher("util/access-denied.jsp");
            dispatcher.forward(request, response);
        }
    %>
    
</html>
