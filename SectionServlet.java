import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*******************************************************************************
 *  Caitlin Driver
 *  JavaProject
 *  I promise that this is my code.
 ******************************************************************************/
//@WebServlet(name = "SectionServlet", urlPatterns = {"/SectionServlet"})
public class SectionServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String crn;
        String courseID;
        String timeDays;
        String room;
        String instructor;
        
        System.out.println("before try");
                
        try {
            //step 1 read data from previous file
            crn = request.getParameter("crn");
            courseID = request.getParameter("courseid");
            timeDays = request.getParameter("td");
            room = request.getParameter("rn");
            instructor = request.getParameter("teach");
            
            System.out.println(crn);
            //step 2 get any objects out of the session using getAttribute()
            HttpSession session;
            session = request.getSession();
            Students stud = (Students)session.getAttribute("student");
            
            //step 3 create any objects needed to lookup
            Sections sectionObject = new Sections();
            StudentSchedule schedule = new StudentSchedule();
            
            
            //step 4 make any decisions necessary to continue
            int crnInt = Integer.parseInt(crn);
            int teachInt = Integer.parseInt(instructor);
            
            String act = request.getParameter("act");
            
            System.out.println(act);
            
            if (act.equals("ADD")) {
            //action for update here
                if (stud != null) {
                    sectionObject.insertDB(crnInt,courseID,timeDays,room,teachInt);
                    schedule.insertDB(stud.getStudentID(), crnInt);
                    System.out.println("You updated sections!");
                }   else {
                    sectionObject.insertDB(crnInt, courseID, act, room, teachInt);
                }
            } 
            else if (act.equals("DROP")) {
            //action for delete
                if (stud != null) {
                    sectionObject.deleteDB(crnInt);
                    schedule.deleteDB(stud.getStudentID());
                    System.out.println("You dropped a section!");
                }   else {
                    sectionObject.deleteDB(crnInt);
                }
            }
            
            //step 5 put student object in session using HttpSession
            session.setAttribute("sectionObject", sectionObject);
            System.out.println("sectionObject added to Session/sceduling");
            
            //step 6 use requestDispatcher to forward control to next HTML/JSP/Servlet
            RequestDispatcher rd;
            rd = request.getRequestDispatcher("AddDropSections.jsp");
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
