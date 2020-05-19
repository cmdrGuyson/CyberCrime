<%-- 
    Document   : published-reports
    Created on : Apr 3, 2020, 7:31:45 PM
    Author     : Ebisu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>CyberCrime | Published Reports</title>
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
            <a class="navbar-brand" href="SendHomeController">
                <img src="images/hacker.png" width="40" height="40" alt="" />
            </a>
            <%@ include file="util/search-form.jsp" %>
            <button class="btn btn-outline-primary my-2 my-sm-0" disabled>
                View All Reports
            </button>
        </nav>

        <!--Content-->


        <div class="container content container-table">
            <h6 class="display-4">Published Reports</h6>

            <br /><br />

            <div class="container-dash">
                
                <!--Table to display published reports-->
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
                        
                        <!-- For each report make a new row in the table -->
                        <c:forEach var="report" items="${publishedReports}">

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
