<%------------------------------------------------------------------------------ 
    Caitlin Driver
    JavaProject
    I promise that this is my code.
------------------------------------------------------------------------------%>

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
              padding:20px;
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
        <header>
          <h2>Fairyland University</h2>
        </header>

        <section>
          <nav>
            <ul>
              <li><a href="index.jsp">Home</a></li>
              <li><a href="login.jsp">Student Login</a></li>
              <li><a href="WelcomeAdmin.jsp">Admin</a></li>
            </ul>
          </nav>

          <article>
              <img src="https://www.profascinate.com/uploads/2/6/2/7/26273057/published/1730009_1.jpg?1516491587" alt="College Campus" class="center">
              <p>We would like to welcome all student to Fairyland University. Please take a moment to log in to view your schedule for this semester.</p>
            
          </article>
        </section>

        <footer>
            <p>"It's okay to be a glowstick: Sometimes we have to break before we shine"<br>
            -Jadah Sellner</p>
        </footer>
    </body>
</html>
