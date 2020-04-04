<%-- 
    Document   : officer-dashboard
    Created on : Apr 2, 2020, 6:31:15 PM
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
                    <a class="nav-item nav-link" href="home-officer.jsp"
                       >Home</a
                    >
                    <a class="nav-item nav-link" href="ViewPublishedReportsController">Published Reports</a>
                    <a class="nav-item nav-link" href="#">Contact</a>
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
            <h6 class="display-4">Reports to be Addressed</h6>
            <br />

            <a
                class="btn btn-outline-warning my-2 my-sm-0" href="ViewMyAddressedReportsController"
                >
                My Addressed Reports
            </a>

            <br /><br />

            <!--Table-->

            <div class="container-dash">
                <table class="table table-striped">
                    <thead class="thead-dark">
                        <tr>
                            <th width="5%" scope="col">Report ID</th>
                            <th width="10%" scope="col">Username</th>
                            <th width="10%" scope="col">Full Name</th>
                            <th width="10%" scope="col">Email</th>
                            <th width="12.5%" scope="col">Date Of Crime</th>
                            <th width="12.5%" scope="col">Reported Date</th>
                            <th width="10%" scope="col">Type</th>
                            <th width="50%" scope="col">Description</th>
                            <th width="10%" scope="col">Status</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="report" items="${acceptedReports}">

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
                                    <a href="" data-toggle="modal" data-target="#addressReportModal">
                                        <i class="fas fa-bars"></i>
                                    </a>
                                </td>
                            </tr>

                        <div
                            class="modal fade"
                            id="addressReportModal"
                            tabindex="-1"
                            role="dialog"
                            aria-labelledby="addressReportModalLabel"
                            aria-hidden="true"
                            >
                            <div class="modal-dialog modal-dialog-centered modal-lg" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="exampleModalLongTitle">
                                            Address Report
                                        </h5>
                                        <button
                                            type="button"
                                            class="close"
                                            data-dismiss="modal"
                                            aria-label="Close"
                                            >
                                            <span aria-hidden="true">&times;</span>
                                        </button>
                                    </div>
                                    <div class="modal-body">
                                        <form method="POST" action="AddressReportController">
                                            <div class="form-row">
                                                <input type="hidden" name="reportID" value="${report.getReportID()}">
                                                <label for="response">Response</label>
                                                <textarea
                                                    class="form-control"
                                                    id="responseTextArea"
                                                    rows="5"
                                                    placeholder="Please provide a short response to how the report was addressed."
                                                    name="response"
                                                    required
                                                    ></textarea>
                                            </div>
                                            <div class="form-row">
                                                <div class="col">
                                                    <label for="inputStatus">Status</label>
                                                    <select id="inputStatus" class="form-control" name="status">
                                                        <option selected>In-progress</option>
                                                        <option>Recovered</option>
                                                        <option>Insufficient Data</option>
                                                    </select>
                                                </div>
                                            </div>
                                            <hr />
                                            <br />
                                            <button
                                                type="button"
                                                class="btn btn-secondary"
                                                data-dismiss="modal"
                                                >
                                                Close
                                            </button>
                                            <button class="btn btn-primary" type="submit" value="submit">
                                                Address Report
                                            </button>
                                        </form>
                                    </div>
                                </div>
                            </div>


                        </c:forEach>
                        </tbody>
                </table>
            </div>
        </div>


        <%@ include file="util/footer.html" %>

    </body>
</html>
