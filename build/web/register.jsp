<%-- 
    Document   : register
    Created on : Mar 31, 2020, 5:47:41 PM
    Author     : Ebisu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>CyberCrime | Register</title>
        <link
            rel="stylesheet"
            href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
            integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
            crossorigin="anonymous"
            />
        <link rel="stylesheet" type="text/css" href="css/index.css" />
        <link rel="icon" href="images/hacker.png" />
    </head>

    <%
        String type = (String) request.getSession().getAttribute("typeOfUser");

        if (type == null) {

    %>

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
                    <a class="nav-item nav-link" href="contact-us.jsp">Contact</a>
                </div>
            </div>
            <%@ include file="util/search-form.jsp" %>
            <a class="btn btn-outline-primary my-2 my-sm-0" href="ViewPublishedReportsController">
                View All Reports
            </a>
        </nav>

        <!--Content-->
        <div class="container container-home content">
            <div class="row">
                <div class="col-sm">
                    <div class="image-hack">
                        <br /><br /><br /><br />
                        <img src="images/signup-hacker.png" height="400" />
                    </div>
                </div>
                <div class="col-sm">
                    <br /><br />
                    <form class="form-signin" method="POST" action="RegisterController" oninput='confirmPassword.setCustomValidity(confirmPassword.value != password.value ? "Passwords do not match." : "")'>
                        <h4 class="h4 mb-3 font-weight-normal">Register</h4>
                        <br />
                        <div class="text-center">
                            <label for="inputEmail" class="sr-only">Username</label>
                            <input
                                type="username"
                                name="username"
                                id="inputUsername"
                                class="form-control"
                                placeholder="Username"
                                required
                                autofocus
                                />
                            <br />
                            <label for="inputPassword" class="sr-only">Password</label>
                            <input
                                type="password"
                                id="inputPassword"
                                class="form-control"
                                name="password"
                                placeholder="Password"
                                required
                                />
                            <br />
                            <label for="inputConfirmPassword" class="sr-only"
                                   >Confirm Password</label
                            >
                            <input
                                type="password"
                                id="inputConfirmPassword"
                                name="confirmPassword"
                                class="form-control"
                                placeholder="Confirm Password"
                                required
                                />
                            <br />
                            <label for="inputFirstName" class="sr-only">First Name</label>
                            <input
                                type="text"
                                id="inputFirstName"
                                class="form-control"
                                placeholder="First Name"
                                name="firstName"
                                required
                                autofocus
                                />
                            <br />
                            <label for="inputLastName" class="sr-only">Last Name</label>
                            <input
                                type="text"
                                id="inputLastName"
                                class="form-control"
                                name="lastName"
                                placeholder="Last Name"
                                autofocus
                                />
                            <br />
                            <label for="inputOrganizationName" class="sr-only organization-hidden">Organization Name</label>
                            <input
                                type="text"
                                id="inputOrganizationName"
                                class="form-control organization-hidden"
                                name="organizationName"
                                placeholder="Organization Name"
                                autofocus
                                />
                            <br />
                            <input
                                type="email"
                                id="inputEmail"
                                class="form-control"
                                name="email"
                                placeholder="Email"
                                required
                                autofocus
                                />
                            <br />
                            <select id="inputType" class="form-control" required name="type" onchange="hide()">
                                <option selected>Individual</option>
                                <option>Organization</option>
                            </select>
                            <br />
                            <p>If registering an organization please leave Last name empty</p>
                            <br />
                            <br />

                            <button class="btn btn-md btn-primary btn-block" type="submit">
                                Register
                            </button>
                            <br />
                            <!-- <div class="checkbox mb-3">
                              <label>
                                <input type="checkbox" value="remember-me" /> Remember me
                              </label>
                            </div> -->
                            <p class="mt-5 mb-3 text-muted">
                                Already have an account? <a href="index.jsp">Login!</a>
                            </p>
                        </div>
                    </form>
                </div>
            </div>
        </div>

        <%@ include file="util/footer.html" %>

    </body>

    <script>
        //Hide Organization field after page loads
        document.getElementById("inputOrganizationName").style.display = 'none';
        
        //Script to change register form based on type of user
        function hide() {
            var e = document.getElementById("inputType");
            var type = e.options[e.selectedIndex].value;
            
            
            if(type === "Organization") {
                // If its an organization change first name and last name input field placeholders and show organization name field
                document.getElementById("inputOrganizationName").style.display = 'block';
                document.getElementById('inputFirstName').placeholder='HR-Manager First Name'
                document.getElementById('inputLastName').placeholder='HR-Manager Last Name'
            }else{
                // If its not an organization change hr-manager first name and last name input field placeholders and hide organization name field
                document.getElementById("inputOrganizationName").style.display = 'none';
                document.getElementById('inputFirstName').placeholder='First Name'
                document.getElementById('inputLastName').placeholder='Last Name'
            }
        }
    </script>

    <%    } else {

            RequestDispatcher dispatcher = request.getRequestDispatcher("SendHomeController");
            dispatcher.forward(request, response);
        }
    %>

</html>
