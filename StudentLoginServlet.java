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
//@WebServlet(name = "StudentLoginServlet", urlPatterns = {"/StudentLoginServlet"})
public class StudentLoginServlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String studentLoginID, loginPW;
        studentLoginID = "";
        loginPW = "";
        
        try {
            //step 1
            studentLoginID = request.getParameter("id");
            System.out.println("StudentLoginID accessed: " + studentLoginID);
            
            //step 2 get any objects out of the session using getAttribute()
            
            
            //step 3 create any objects needed to lookup a student
            Students student;
            student = new Students();
            
            int stringToInt = Integer.parseInt(studentLoginID);
            
            student.selectDB(stringToInt);
            System.out.println("FirstName = " + student.getFirstName());
            
            loginPW = request.getParameter("pw");
            System.out.println("LoginPW: " + loginPW);
            
            //step 5 put student object in session using HttpSession
            HttpSession session1;
            session1 = request.getSession();
            session1.setAttribute("student", student);
            System.out.println("Student added to Session/sceduling");
            
            if (stringToInt==student.getStudentID()) {
                if (loginPW.equals(student.getPassword())) {
                    System.out.println("You're In!");
                    RequestDispatcher toNextPage;
                    toNextPage = request.getRequestDispatcher("studentSchedule.jsp");
                    toNextPage.forward(request, response);
                }
                else {
                    System.out.println("Password failed!");
                    RequestDispatcher toErrorPage;
                    toErrorPage = request.getRequestDispatcher("LoginError.jsp");
                    toErrorPage.include(request, response);
                }
            }
            else {
                System.out.println("Login ID failed!");
                RequestDispatcher toErrorPage;
                toErrorPage = request.getRequestDispatcher("LoginError.jsp");
                toErrorPage.include(request, response);
            }
            
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