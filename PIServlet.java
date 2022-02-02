import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.*;
import javax.servlet.http.*;

/*******************************************************************************
 *  Caitlin Driver
 *  JavaProject
 *  I promise that this is my code.
 ******************************************************************************/
//@WebServlet(name = "PIServlet", urlPatterns = {"/PIServlet"})
public class PIServlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String studID;
        String password;
        String firstName;
        String lastName;
        String studStreet;
        String studCity;
        String studState;
        String studZip;
        String studEmail;
        String studGPA;
        
        try {
            //step 1 read data from previous file
            studID = request.getParameter("id");
            password = request.getParameter("pw");
            firstName = request.getParameter("fn");
            lastName = request.getParameter("ln");
            studStreet = request.getParameter("st");
            studCity = request.getParameter("city");
            studState = request.getParameter("state");
            studZip = request.getParameter("zip");
            studEmail = request.getParameter("email");
            studGPA = request.getParameter("gpa");
            
            //step 2 get any objects needed out of session
            
            Students studAgain;
            HttpSession session;
            session = request.getSession();
            studAgain = (Students)session.getAttribute("student");
            
            //step 3 create any objects needed to complete task at hand
            
            
            //step 4 make any decisions necessary to continue
            int id = Integer.parseInt(studID);
            int zip = Integer.parseInt(studZip);
            double gpa = Double.parseDouble(studGPA);
            
            studAgain.updateDB(id, password, firstName, lastName, studStreet, studCity, studState, zip, studEmail, gpa);
            
            //step 5 put any objects in session that may be needed by the next servlet
            session.setAttribute("student", studAgain);
            session.setAttribute("studUpdated", "updated");
            System.out.println("studAgain added to Session/sceduling");
            
            //step 6 use requestdispatcher to forward control to next HTML/JSP/Servlet
            RequestDispatcher rd;
            rd = request.getRequestDispatcher("PersonalInfo.jsp");
            rd.include(request,response);
            
        }
        catch(Exception e){
            System.out.println("Error in PIServlet: " + e);
        }
    }    
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}