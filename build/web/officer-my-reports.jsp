<%-- 
    Document   : officer-my-reports
    Created on : Apr 2, 2020, 11:57:45 PM
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
        <link rel="stylesheet" type="text/css" href="css/additional.css" />
        <link rel="stylesheet" type="text/css" href="css/index.css" />
        <link rel="icon" href="images/hacker.png" />
        <style>
            body {background-image: url("images/register-hacker.png");
                  background-repeat: no-repeat;
                  background-position: right bottom;
            }
        </style>
    </head>
    
    <%
        String type = (String) request.getSession().getAttribute("typeOfUser");

        if (type == "officer") {

    %>
    
    <body>
        <!--Navigation Bar-->

        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="#">
                <img src="images/hacker.png" width="40" height="40" alt="" />
            </a>
            <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                <div class="navbar-nav">
                    <a class="nav-item nav-link" href="home-officer.jsp"
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


        <div class="container content container-table">
            <h6 class="display-4">My Addressed Reports</h6>
            <br />

            <a
                class="btn btn-outline-warning btnWhite my-2 my-sm-0" href="ViewAcceptedReportsController"
                >
                Reports to be addressed
            </a>

            <br /><br />
            
            <div class="container-dash">
                
                <!--Table to display reports-->
                <table class="table table-striped">
                    <thead class="thead-dark">
                        <tr>
                            <th scope="col">Report ID</th>
                            <th scope="col">Username</th>
                            <th scope="col">Full Name</th>
                            <th scope="col">Email</th>
                            <th scope="col">Date Of Crime</th>
                            <th scope="col">Reported Date</th>
                            <th scope="col">Type</th>
                            <th scope="col">Description</th>
                            <th scope="col">Response</th>
                            <th scope="col">Status</th>
                        </tr>
                    </thead>
                    <tbody>
                        
                        <!--For each report add a new row to the table -->
                        <c:forEach var="report" items="${addressedReports}">
                            <tr>
                                <th scope="row">${report.getReportID()}</th>
                                <td>${report.getUsername()}</td>
                                <td>${report.getFullName()}</td>
                                <td>${report.getEmail()}</td>
                                <td>${report.getEstimatedDateOfCrime()}</td>
                                <td>${report.getReportedDate()}</td>
                                <td>${report.getTypeOfCrime()}</td>
                                <td>${report.getDescription()}</td>
                                <td>${report.getResponse()}</td>
                                <td>${report.getStatus()}</td>
                            </tr>
                        </c:forEach>
                            
                    </tbody>
                </table>
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
