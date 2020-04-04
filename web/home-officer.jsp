<%-- 
    Document   : home-officer
    Created on : Apr 2, 2020, 6:15:14 PM
    Author     : Ebisu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>CyberCrime | Home</title>
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
                    <a class="nav-item nav-link active" href="#"
                       >Home<span class="sr-only">(current)</span></a
                    >
                    <a class="nav-item nav-link" href="ViewPublishedReportsController">Published Reports</a>
                    <a class="nav-item nav-link" href="contact-us.jsp">Contact</a>
                </div>
            </div>
            <%@ include file="util/search-form.jsp" %>
            <a class="btn btn-outline-danger my-2 my-sm-0" href="ViewAcceptedReportsController">
                Dashboard
            </a>
            <a href="LogoutController" data-toggle="tooltip" title="Sign out"
               ><i class="fas fa-sign-out-alt fa-lg"></i
                ></a>
        </nav>

        <!--Content-->
        <div class="container container-home">
            <br />
            <div class="text-center">
                <img src="images/another-hacker.png" height="400" />
            </div>
        </div>

        <div class="container container-home content">
            <div class="row">
                <div class="col-sm"></div>
                <div class="col-sm">
                    <div class="text-center">
                        <h3>Cyber Crime</h3>
                        <br />
                        <p>
                            The Computer Crimes mostly reported, in Sri Lanka are financial
                            frauds, abuse/hate/privacy violation, phishing, scams, malware,
                            unauthorized access, intellectual property violation, DoS/DDoS
                            attack, Social media related incidents.
                        </p>
                        <p>
                            According to SLCERT (Sri Lankan Computer Emergency Readiness
                            Team), Fake accounts crimes are major crimes committed in Sri
                            Lanka.
                        </p>
                        <p>
                            Computer crimes in Sri Lanka keep up increasing every year.
                            According to SLCERT, the computer crime rate has increased up to
                            4733% from 2008 to 2014. Particularly fake account crimes have
                            increased from nearly 0 to 2300.
                        </p>
                        <br /><br />
                        <h3>Reporting a Crime</h3>
                        <br />
                        <p>________________________________________________</p>
                        <p>
                            <em>
                                You have to have a registered account to report a cyber crime.
                            </em>
                        </p>
                        <p>________________________________________________</p>
                        <br />
                        <p>
                            After you make an account you will have the option to report a
                            cyber crime.
                        </p>
                        <p>
                            Your report will be published for an officer after the legitimacy
                            of your report has been verified.
                        </p>
                        <br />
                    </div>
                </div>
                <div class="col-sm"></div>
            </div>
        </div>

        <%@ include file="util/footer.html" %>

    </body>
</html>
