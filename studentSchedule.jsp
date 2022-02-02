<%------------------------------------------------------------------------------ 
    Caitlin Driver
    JavaProject
    I promise that this is my code.
------------------------------------------------------------------------------%>


<%@page import = "Java.Students" %>
<%@page import = "Java.StudentSchedule" %>
<%@page import = "Java.Sections" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
            
            table, th, td {
                border: 2px solid black;
                padding: 5px;
            }
            
            .first {
                background-color: #618685;
                color: whitesmoke;
            }
            
            .rest {
                background-color: whitesmoke;
                color: #80ced6
            }

            article {
              float: left;
              padding: 20px;
              width: 70%;
              background-color: #80ced6;
              height: 300px; /* only for demonstration, should be removed */
              overflow: auto;
            }
            
            .center {
                display: block;
                margin-left: auto;
                margin-right: auto;
                width: 50%;
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
        <%
            Students student;
            student = (Students)session.getAttribute("student");
            
            StudentSchedule ss = new StudentSchedule();
            
            int studID = student.getStudentID();
            
            ss.selectDB(studID);
            int[] secArray = ss.getCRNArray();
            
            Sections sec = new Sections();
         
        %>
        <header>
          <h2>Fairyland University</h2>
        </header>

        <section>
            <nav>
                <ul>
                    <li><a href="index.jsp">Home</a></li>
                    <li><a href="login.jsp">Login</a></li>
                    <li><a href="PersonalInfo.jsp">Change Personal Information</a></li>
                    <li><a href="AddDropSections.jsp">Add/Drop Sections</a></li>
                </ul>
            </nav>

            <article>
                <h1>THIS SEMESTERS SCHEDULE</h1>
                
                <table>
                    <tr class="first">
                        <th>CRN</th>
                        <th>Course ID</th>
                        <th>Time</th>
                        <th>Room Number</th>
                    </tr>
                    <%
                        int x = 0;
                        while (x<secArray.length) {
                    %>
                    <tr class="rest">
                        <td><%= secArray[x] %></td>
                        <% sec.selectDB(secArray[x]); %>
                        <td><%= sec.getCourseID() %></td>
                        <td><%= sec.getTimeDays() %></td>
                        <td><%= sec.getRoomNo() %></td>
                    </tr>
                    <%
                        x++;
                        }
                    %>
                </table>
                
            </article>
            
        </section>

        <footer>
          <p>"When someone says you can't do it. Do it twice, and take pictures."</p>
        </footer>
    </body>
</html>
