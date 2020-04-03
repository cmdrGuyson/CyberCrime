<%-- 
    Document   : user-my-reports
    Created on : Apr 3, 2020, 5:10:05 PM
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

    <body>
        <!--Navigation Bar-->

        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="#">
                <img src="images/hacker.png" width="40" height="40" alt="" />
            </a>
            <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                <div class="navbar-nav">
                    <a class="nav-item nav-link" href="home-user.jsp"
                       >Home</a
                    >
                    <a class="nav-item nav-link" href="#">Published Reports</a>
                    <a class="nav-item nav-link" href="#">Contact</a>
                </div>
            </div>
            <form class="form-inline">
                <input
                    class="form-control mr-sm-2"
                    type="search"
                    placeholder="Search for report"
                    aria-label="Search"
                    />
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">
                    Search
                </button>
            </form>
            <a href="report-crime.jsp" class="btn btn-outline-danger my-2 my-sm-0" role="button">Report Crime</a>
            <button class="btn btn-outline-primary my-2 my-sm-0" disabled href="#">
                View My Reports
            </button>
            <a href="LogoutController" data-toggle="tooltip" title="Sign out">
                <i class="fas fa-sign-out-alt fa-lg"></i>
            </a>
        </nav>

        <!--Content-->


        <div class="container content container-table">
            <h6 class="display-4">My Reports</h6>

            <br /><br />

            <!--Table-->

            <div class="container-dash">
                <table class="table table-striped">
                    <thead class="thead-dark">
                        <tr>
                            <th scope="col">Report ID</th>
                            <th scope="col" width="6%">Date Of Crime</th>
                            <th scope="col" width="6%">Reported Date</th>
                            <th scope="col">Type</th>
                            <th scope="col">Description</th>
                            <th scope="col">Response</th>
                            <th scope="col">Status</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="report" items="${myReports}">

                            <tr>

                                <th scope="row">${report.getReportID()}</th>
                                <td>${report.getEstimatedDateOfCrime()}</td>
                                <td>${report.getReportedDate()}</td>
                                <td>${report.getTypeOfCrime()}</td>
                                <td>${report.getDescription()}</td>
                                <td>${report.getResponse()}</td>
                                <td><b>${report.getStatus()}<b/></td>

                            </tr>

                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>


        <%@ include file="util/footer.html" %>

    </body>
</html>
