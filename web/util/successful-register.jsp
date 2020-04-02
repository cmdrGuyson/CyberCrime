<%-- 
    Document   : successful-register
    Created on : Mar 31, 2020, 7:34:45 PM
    Author     : Ebisu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>CyberCrime | Home</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
              integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous" />
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
                    <a class="nav-item nav-link active" href="#">Home<span class="sr-only">(current)</span></a>
                    <a class="nav-item nav-link" href="#">Published Reports</a>
                    <a class="nav-item nav-link" href="#">Contact</a>
                </div>
            </div>
            <form class="form-inline">
                <input class="form-control mr-sm-2" type="search" placeholder="Search for report" aria-label="Search" />
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">
                    Search
                </button>
            </form>
            <button class="btn btn-outline-primary my-2 my-sm-0" type="submit">
                View All Reports
            </button>
        </nav>

        <!--Content-->
        <div class="container container-home content">
            <div class="row">
                <div class="col-sm-12 col-md-12 col-xs-12 centerAlign">
                    <div class="image-hack">
                        <img src="images/register-hacker.png" height="400" />
                    </div>
                </div>
                <div class="col-sm-12 col-md-12 col-xs-12 successfullyRegistered">
                    <p>Successfully Registered! <a href="index.jsp"> Please login to continue. </a></p>
                </div>
            </div>
        </div>

        <%@ include file="footer.html" %>

    </body>
</html>
