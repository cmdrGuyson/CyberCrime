<%-- 
    Document   : admin-dashboard-user
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
        
        <link rel="stylesheet" type="text/css" href="css/additional.css" />
        <link rel="stylesheet" type="text/css" href="css/index.css" />
        <link rel="icon" href="images/hacker.png" />
        <style>
            body {background-image: url("images/paper-plane.gif"), url("images/register-hacker.png");
                  background-repeat: no-repeat, no-repeat;
                  background-position: left top, right bottom;
            }
        </style>
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
            <h6 class="display-4">Manage Users</h6>
            <br />

            <a
                class="btn btn-outline-warning btnWhite my-2 my-sm-0" href="ViewPendingReportsController"
                >
                Pending Reports
            </a>

            <br /><br />


            <!--Table to display users-->
            <div class="row dash-row">
                <div class="container-dash">
                    <table class="table table-striped">
                        <thead class="thead-dark">
                            <tr>
                                <th scope="col">Username</th>
                                <th scope="col">First Name</th>
                                <th scope="col">Last Name</th>
                                <th scope="col">Email</th>
                                <th scope="col">Registered Date</th>
                                <th scope="col">Status</th>
                            </tr>
                        </thead>
                        <tbody>
                            <!--For each user add a new row to the table-->
                            <c:forEach var="user" items="${pendingUsers}">

                                <c:url var="accept" value="UpdateUserStatusController">
                                    <c:param name="status" value="Active"/> 
                                    <c:param name="username" value="${user.getUsername()}"/>
                                </c:url>

                                <!--Username of user stored in request parameter-->
                                <c:url var="decline" value="UpdateUserStatusController">
                                    <c:param name="status" value="Inactive"/> 
                                    <c:param name="username" value="${user.getUsername()}"/>
                                </c:url>

                                <tr>
                                    <th scope="row">${user.getUsername()}</th>
                                    <td>${user.getFirstName()}</td>
                                    <td>${user.getLastName()}</td>
                                    <td>${user.getEmail()}</td>
                                    <td>${user.getDateRegistered()}</td>
                                    <td>${user.getStatus()}</td>
                                    <td>
                                        <a href="${accept}" data-toggle="tooltip" title="Accept"
                                           ><i class="fas fa-check-circle"></i
                                            ></a>
                                        <a href="${decline}" data-toggle="tooltip" title="Decline"
                                           ><i class="fas fa-ban"></i
                                            ></a>
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
