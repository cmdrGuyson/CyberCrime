<%-- 
    Document   : contact-us
    Created on : Apr 4, 2020, 8:52:23 PM
    Author     : Ebisu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>CyberCrime | Contact us</title>
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
    </head>

    <body>
        
        <!--Navigation Bar-->

        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="#">
                <img src="images/hacker.png" width="40" height="40" alt="" />
            </a>
            <%@ include file="util/search-form.jsp" %>
            <a class="btn btn-outline-primary my-2 my-sm-0" href="ViewPublishedReportsController">
                View All Reports
            </a>
        </nav>

        <!--Content-->
        <div class="container contactContainer content">
            <div class="row">
                <div class="col-sm-3 col-xs-3 col-md-3"></div>
                <div class="col-sm-6 col-md-6 col-xs-6 centerAlign contactBox">
                    <div class="row">
                        <div class="col-sm-12 col-md-12 col-xs-12">
                            <h2>Contact Us</h2>
                            <hr />
                        </div>
                        <div class="col-sm-12 col-md-12 col-xs-12">
                            <table class="contactTable leftText">
                                <tr>
                                    <td class="mainText">
                                        <i class="fas fa-envelope fa-lg"></i> Email address:
                                    </td>
                                    <td> cybercrime.contact@email.com </td>
                                </tr>
                                <tr>
                                    <td class="mainText"> <i class="fas fa-phone fa-lg"></i> Contact Number:
                                    </td>
                                    <td> +94-112394802 </td>
                                </tr>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        
        <%@ include file="util/footer.html" %>

    </body>
</html>