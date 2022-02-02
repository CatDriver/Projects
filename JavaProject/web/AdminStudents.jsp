<%------------------------------------------------------------------------------ 
    Caitlin Driver
    JavaProject
    I promise that this is my code.
------------------------------------------------------------------------------%>

<%@page import = "Java.Students" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JavaProject</title>
        <style>
            * {
              box-sizing: border-box;
            }

            body {
              font-family: Arial, Helvetica, sans-serif;
              color: #fefbd8;
            }

            /* Style the header */
            header {
              background-color: #618685;
              padding: 30px;
              text-align: center;
              font-size: 35px;
            }

            /* Create two columns/boxes that floats next to each other */
            nav {
              float: left;
              width: 30%;
              height: 300px; /* only for demonstration, should be removed */
              background-color: #fefbd8;
              padding: 20px;
            }
            
            nav a {
                color: #80ced6;
            }
            
            nav a:hover {
                color: #618685;
            }

            /* Style the list inside the menu */
            nav ul {
              list-style-type: none;
              padding: 0;
            }

            article {
              float: left;
              padding: 20px;
              width: 70%;
              background-color: #80ced6;
              height: 300px; /* only for demonstration, should be removed */
              overflow: scroll;
            }

            /* Clear floats after the columns */
            section:after {
              content: "";
              display: table;
              clear: both;
            }

            /* Style the footer */
            footer {
              background-color: #618685;
              padding: 10px;
              text-align: center;
            }

            /* Responsive layout - makes the two columns/boxes stack on top of each other instead of next to each other, on small screens */
            @media (max-width: 600px) {
              nav, article {
                width: 100%;
                height: auto;
              }
            }
        </style>
    </head>
    <body>
        
        <header>
          <h2>Fairyland University</h2>
        </header>

        <section>
            <nav>
                <ul>
                    <li><a href="index.jsp">Home</a></li>
                    <li><a href="WelcomeAdmin.jsp">Admin Home</a></li>
                    <li><a href="Courses.jsp">Add Course</a></li>
                    <li><a href="Instructors.jsp">Add Instructor</a></li>
                    <li><a href="AddDropSections.jsp">Add/Drop Sections</a></li>
                </ul>
            </nav>

            <article>
                <% if (session.getAttribute("adminStudUpdated") != null) { %>
                    <p>Information has been updated.</p>
                <% } %>
                <Form action="AdminPIServlet" method="post">                    
                    <label for="StudentID">Student ID:</label>
                    <input type="text" id="id" name="id"><br><br>
                    <label for="Password">Password:</label>
                    <input type="text" id="pw" name="pw"><br><br>
                    <label for="FirstName">First Name:</label>
                    <input type="text" id="fn" name="fn"><br><br>
                    <label for="LastName">Last Name:</label>
                    <input type="text" id="ln" name="ln"><br><br>
                    <label for="Street">Street:</label>
                    <input type="text" id="st" name="st"><br><br>
                    <label for="City">City:</label>
                    <input type="text" id="city" name="city"><br><br>
                    <label for="State">State:</label>
                    <input type="text" id="state" name="state"><br><br>
                    <label for="Zip">Zip:</label>
                    <input type="text" id="zip" name="zip"><br><br>
                    <label for="Email">Email:</label>
                    <input type="text" id="email" name="email"><br><br>
                    <label for="GPA">GPA:</label>
                    <input type="text" id="gpa" name="gpa"><br><br>
                    <input type="submit" value="ADD">
                    <input type="reset" value="Clear">
                </Form>
                        
            </article>
        </section>

        <footer>
            <p>"I did a push-up today. Well, actually I fell down. But I had to use my arms to get back up so....you know, close enough. I need some chocolate."</p>
        </footer>
    </body>
</html>