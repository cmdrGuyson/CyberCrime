<%-- 
    Document   : index
    Created on : Mar 30, 2020, 8:49:09 PM
    Author     : Ebisu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />

        <!-- Style Sheets and Icons -->
        <link
            rel="stylesheet"
            href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
            integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
            crossorigin="anonymous"
            />
        <link rel="stylesheet" type="text/css" href="css/index.css" />
        <link rel="icon" href="images/hacker.png" />

        <title>CyberCrime | Login</title>
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
            <button class="btn btn-outline-primary my-2 my-sm-0" type="submit">
                View All Reports
            </button>
        </nav>

        <!--Content-->
        <div class="container container-home content">
            <div class="row">
                <div class="col-sm">
                    <div class="image-hack">
                        <img src="images/hacker-background.png" height="400" />
                    </div>
                </div>
                <div class="col-sm">
                    <br /><br />
                    <form class="form-signin" method="POST" action="LoginController">
                        <h4 class="h4 mb-3 font-weight-normal">Sign in</h4>
                        <br />
                        <div class="text-center">
                            <label for="inputEmail" class="sr-only">Username</label>
                            <input
                                type="username"
                                id="inputUsername"
                                class="form-control"
                                placeholder="Username"
                                name="username"
                                required
                                autofocus
                                />
                            <br />
                            <label for="inputPassword" class="sr-only">Password</label>
                            <input
                                type="password"
                                id="inputPassword"
                                class="form-control"
                                placeholder="Password"
                                name="password"
                                required
                                />
                            <br /><br />

                            <button class="btn btn-md btn-primary btn-block" type="submit">
                                Sign in
                            </button>
                            <br />
                            <p class="mt-5 mb-3 text-muted">
                                Don't have an account? <a href="register.jsp">Register!</a>
                            </p>
                        </div>
                    </form>
                </div>
            </div>
        </div>

        <div class="container container-home">
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
                        <p class="notice">
                            <em>
                                You have to have a registered account to report a cyber crime.
                            </em>
                        </p>
                        <br />
                        <p>
                            After you make an account you will have the option to report a
                            cyber crime.
                        </p>
                        <p>
                            Your report will be published to an officer after its legitimacy 
                            has been verified.
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