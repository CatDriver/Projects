import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


//@WebServlet(name="InstructorServlet", urlPatterns = {"/InstructorServlet"})
public class InstructorServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String instructorID; //needs to be int
        String firstName;
        String lastName;
        String instStreet;
        String instCity;
        String instState;
        String instZip; //needs to be int
        String instOffice;
        String instEmail;
        
        try {
            //step 1 read data from previous file
            instructorID = request.getParameter("teachID");
            firstName = request.getParameter("fn");
            lastName = request.getParameter("ln");
            instStreet = request.getParameter("street");
            instCity = request.getParameter("city");
            instState = request.getParameter("state");
            instZip = request.getParameter("zip");
            instOffice = request.getParameter("office");
            instEmail = request.getParameter("email");
            
            //step 2 get any objects out of the session using getAttribute()
            
            
            //step 3 create any objects needed to lookup
            Instructors addInstructorObject = new Instructors();
            
            
            //step 4 make any decisions necessary to continue
            //change 2 properties from string to int
            int instructorIDToInt = Integer.parseInt(instructorID);
            int instZipToInt = Integer.parseInt(instZip);
            
            System.out.println("hi");
            addInstructorObject.insertDB(instructorIDToInt, firstName, lastName, instStreet, instCity, instState, instZipToInt, instOffice, instEmail);
            
            //step 5 put student object in session using HttpSession
            HttpSession session;
            session = request.getSession();
            session.setAttribute("addInstructorObject", addInstructorObject);
            session.setAttribute("instructorUpdated", "updated");
            System.out.println("addInstructorObject added to Session/sceduling");
            
            //step 6 use requestDispatcher to forward control to next HTML/JSP/Servlet
            RequestDispatcher rd;
            rd = request.getRequestDispatcher("Instructors.jsp");
            rd.include(request, response);
            
        }
        catch(Exception e) {
            System.out.println("Error: " + e);
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
