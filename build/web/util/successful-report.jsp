<%-- 
    Document   : successful-report
    Created on : Apr 1, 2020, 1:16:11 AM
    Author     : Ebisu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>CyberCrime | Report Submitted</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
              integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous" />
        <link rel="stylesheet" type="text/css" href="css/index.css" />
        <link rel="icon" href="images/hacker.png" />
    </head>

    <body class="successfullyCreatedReport">

        <!--Content-->
        <div class="container container-home content">
            <div class="row">
                <div class="col-sm-12 col-md-12 col-xs-12 centerAlign">
                    <div class="image-hack">
                        <img src="images/storyboard.gif" height="400" />
                    </div>
                </div>
                <div class="col-sm-12 col-md-12 col-xs-12 notFoundText">
                    <h2>Successfully submitted report!</h2>
                    <p>Your report will be published to an officer after its legitimacy has been verified</p>
                    <p> <a href="home-user.jsp"> Go back home</a></p>
                </div>
            </div>
        </div>


        <%@ include file="footer.html" %>

    </body>

</html>