package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JavaProject</title>\n");
      out.write("        <style>\n");
      out.write("            * {\n");
      out.write("              box-sizing: border-box;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            body {\n");
      out.write("              font-family: Arial, Helvetica, sans-serif;\n");
      out.write("              color: #fefbd8;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            /* Style the header */\n");
      out.write("            header {\n");
      out.write("              background-color: #618685;\n");
      out.write("              padding: 30px;\n");
      out.write("              text-align: center;\n");
      out.write("              font-size: 35px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            /* Create two columns/boxes that floats next to each other */\n");
      out.write("            nav {\n");
      out.write("              float: left;\n");
      out.write("              width: 30%;\n");
      out.write("              height: 300px; /* only for demonstration, should be removed */\n");
      out.write("              background-color: #fefbd8;\n");
      out.write("              padding:20px;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            nav a {\n");
      out.write("                color: #80ced6;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            nav a:hover {\n");
      out.write("                color: #618685;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            /* Style the list inside the menu */\n");
      out.write("            nav ul {\n");
      out.write("              list-style-type: none;\n");
      out.write("              padding: 0; \n");
      out.write("            }\n");
      out.write("\n");
      out.write("            article {\n");
      out.write("              float: left;\n");
      out.write("              padding: 20px;\n");
      out.write("              width: 70%;\n");
      out.write("              background-color: #80ced6;\n");
      out.write("              height: 300px; /* only for demonstration, should be removed */\n");
      out.write("              overflow: auto;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            .center {\n");
      out.write("                display: block;\n");
      out.write("                margin-left: auto;\n");
      out.write("                margin-right: auto;\n");
      out.write("                width: 50%;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            /* Clear floats after the columns */\n");
      out.write("            section:after {\n");
      out.write("              content: \"\";\n");
      out.write("              display: table;\n");
      out.write("              clear: both;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            /* Style the footer */\n");
      out.write("            footer {\n");
      out.write("              background-color: #618685;\n");
      out.write("              padding: 10px;\n");
      out.write("              text-align: center;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            /* Responsive layout - makes the two columns/boxes stack on top of each other instead of next to each other, on small screens */\n");
      out.write("            @media (max-width: 600px) {\n");
      out.write("              nav, article {\n");
      out.write("                width: 100%;\n");
      out.write("                height: auto;\n");
      out.write("              }\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <header>\n");
      out.write("          <h2>Fairyland University</h2>\n");
      out.write("        </header>\n");
      out.write("\n");
      out.write("        <section>\n");
      out.write("          <nav>\n");
      out.write("            <ul>\n");
      out.write("              <li><a href=\"index.jsp\">Home</a></li>\n");
      out.write("              <li><a href=\"login.jsp\">Student Login</a></li>\n");
      out.write("              <li><a href=\"WelcomeAdmin.jsp\">Admin</a></li>\n");
      out.write("            </ul>\n");
      out.write("          </nav>\n");
      out.write("\n");
      out.write("          <article>\n");
      out.write("              <img src=\"https://www.profascinate.com/uploads/2/6/2/7/26273057/published/1730009_1.jpg?1516491587\" alt=\"College Campus\" class=\"center\">\n");
      out.write("              <p>We would like to welcome all student to Fairyland University. Please take a moment to log in to view your schedule for this semester.</p>\n");
      out.write("            \n");
      out.write("          </article>\n");
      out.write("        </section>\n");
      out.write("\n");
      out.write("        <footer>\n");
      out.write("            <p>\"It's okay to be a glowstick: Sometimes we have to break before we shine\"<br>\n");
      out.write("            -Jadah Sellner</p>\n");
      out.write("        </footer>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
