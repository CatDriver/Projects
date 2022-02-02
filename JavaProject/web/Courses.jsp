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
                <li><a href="index.jsp">Home</a></li>
                <li><a href="WelcomeAdmin.jsp">Welcome Administrator</a></li>
                <li><a href="Courses.jsp">Add Course</a></li>
                <li><a href="Instructors.jsp">Add Instructor</a></li>
                <li><a href="AddDropSections.jsp">Add Section</a></li>
                <li><a href="AdminStudents.jsp">Add Student</a></li>
            </nav>
            
            <article>
                <% if (session.getAttribute("courseUpdated") != null) { %>
                    <p>Information has been updated.</p>
                <% } %>
                <form action="CourseServlet" method="post">
                    <label for="CourseID">CourseID:</label>
                    <input type="text" id="cid" name="cid"><br><br>
                    <label for="CourseName">Course Name:</label>
                    <input type="text" id="cn" name="cn"><br><br>
                    <label for="Description">Description:</label>
                    <input type="text" id="description" name="description"><br><br>
                    <label for="CreditHours">Credit Hours:</label>
                    <input type="text" id="ch" name="ch"><br><br>
                    <input type="submit" value="Add" id="add" name="add">
                    <input type="reset" value="Clear">
                </form>
            </article>
        </section>
        
        <footer>
            <p>"The best thing about the future is that it comes one day at a time." -Abraham Lincoln</p>
        </footer>
    </body>
    
</html>
