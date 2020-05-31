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
                    <a class="navbar-brand" href="SendHomeController">
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
                                    <img src="images/hacker.png" height="200px"/>
                                </div>

                                <div class="col-sm-12 col-md-12 col-xs-12">
                                    <br />
                                    <br />
                                    <p>Cyber crime is an initiative by the government of Sri Lanka to monitor and regulate criminal activity throughout the internet. With the advancement of technology, modern criminal activities happen behind screens and it is our duty to protect the citizens of this country from such happenings. Each incident reported will be handled by our team of officers and taken action against. We vow to make the internet a better place for you.</p>
                                    <br />
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
                                        <tr>
                                            <td class="mainText"> <i class="fas fa-map-marked-alt"></i> Address:
                                            </td>
                                            <td> 69/3, Sumpathipala Avenue, Colombo 08 </td>
                                        </tr>
                                    </table>
                                    <br />
                                    <p>Feel free to contact us if you have any concerns</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- Including the footer -->
                <%@ include file="util/footer.html" %>

            </body>
        </html>