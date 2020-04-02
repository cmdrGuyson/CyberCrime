<%-- 
    Document   : report-crime
    Created on : Mar 31, 2020, 11:54:33 PM
    Author     : Ebisu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <html lang="en">
        <head>
            <meta charset="UTF-8" />
            <meta name="viewport" content="width=device-width, initial-scale=1.0" />
            <title>CyberCrime | Report Crime</title>
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
                <button
                    class="btn btn-outline-danger my-2 my-sm-0 disabled"
                    type="submit"
                    disabled
                    >
                    Report Crime
                </button>
            </nav>

            <!--Content-->

            <div class="container content">
                <h6 class="display-4">Report Crime</h6>
                <br />

                <!--Table-->
                <div class="container-dash">
                    <form action="AddReportController" method="POST">
                        <div class="form-row">
                            <label for="crimeDescription">Description about crime</label>
                            <textarea
                                class="form-control"
                                id="crimeDescriptionTextArea"
                                rows="5"
                                required
                                name="description"
                                placeholder="Please provide a short description of the crime including the outcome of the crime and any damage caused"
                                maxlength="255"
                                ></textarea>
                        </div>
                        <div class="form-row">
                            <div class="col">
                                <label for="example-date-input">Estimated date of event</label>
                                <input
                                    class="form-control"
                                    type="date"
                                    value="2020-03-20"
                                    id="example-date-input"
                                    required
                                    name="estimatedDateOfCrime"
                                    />
                            </div>
                            <div class="col">
                                <label for="inputTypeOfCrime">Type of crime</label>
                                <select id="inputState" class="form-control" required name="typeOfCrime">
                                    <option selected>Hacking Attempt</option>
                                    <option>Phishing Attack</option>
                                    <option>Ransomware</option>
                                    <option>Cash Poisoning</option>
                                    <option>Email Bomb</option>
                                    <option>DDoS</option>
                                    <option>Privacy Violation</option>
                                    <option>Malware</option>
                                    <option>Other</option>
                                </select>
                            </div>
                        </div>
                        <br /><br /><br />
                        <button type="submit" class="btn btn-primary">Submit Report</button>
                    </form>
                </div>
            </div>

            <%@ include file="util/footer.html" %>

        </body>
    </html>
