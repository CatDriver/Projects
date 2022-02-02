import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;

/*******************************************************************************
 *  Caitlin Driver
 *  JavaProject
 *  I promise that this is my code.
 ******************************************************************************/

public class Courses {
    //declare class properties
    private String courseID;
    private String courseName;
    private String description;
    private int creditHours;
    
    private final String url = "jdbc:ucanaccess://C:\\Users\\dihog\\OneDrive\\Documents\\RegistrationMDB";
    private final String driver = "net.ucanaccess.jdbc.UcanaccessDriver";
    
    //Empty argument constructor
    public Courses() {
        //initialize properties
        courseID = "";
        courseName = "";
        description = "";
        creditHours = 0;
    }
    
    //Constructor with arguments
    public Courses(String id, String name, String desc, int hours) {
        //incoming variables are linked to this class variables
        this.courseID = id;
        this.courseName = name;
        this.description = desc;
        this.creditHours = hours;
    }
    
    //Get and Set methods for each property
    public void setID(String id){
        courseID = id;
    }
    public String getID() {
        return courseID;
    }
    public void setName(String name) {
        courseName = name;
    }
    public String getCustPW(){
        return courseName;
    }
    public void setDescription(String desc) {
        description = desc;
    }
    public String getDescription() {
        return description;
    }
    public void setCreditHours(int hours) {
        creditHours = hours;
    }
    public int getCustLN() {
        return creditHours;
    }
    
    /***************************************************************************
     * Display method for showing the class properties and their values.
     **************************************************************************/
    public void display(){
        System.out.println("CourseID    : " + courseID);
        System.out.println("Course Name : " + courseName);
        System.out.println("Description : " + description);
        System.out.println("Credit Hours: " + creditHours);
        System.out.println("================================");
    }
    
    /***************************************************************************
     *  Select database method that communicates with the database and selects a
     *  specific course.
     **************************************************************************/
    public void selectDB(String id) {
        
        try {
            //load the driver
            Class.forName(driver);
            
            //Establish a connection
            Connection selectConnect = DriverManager.getConnection(url);
            System.out.println("SelectDB Connected");
            
            //Create statement
            Statement selectStatement = selectConnect.createStatement();
            
            //execute statement
            String sql = "SELECT * FROM Courses WHERE CourseID = '"+id+"'";
            System.out.println(sql);

            ResultSet results = selectStatement.executeQuery(sql);
            results.next(); //grab all data from customer id
               courseID = results.getString(1);
               courseName = results.getString(2);
               description = results.getString(3);
               creditHours = results.getInt(4);

            //close connection to database
            selectConnect.close();
        }
        catch(Exception e) { //catch exception
            System.out.println("Select Database Error: " + e);
        }
    }//end selectdb
    
    /***************************************************************************
     * Insert database method to insert a new course into the database.
     **************************************************************************/
    public void insertDB(String id, String name, String desc, int hours) {
        try{
            //load the driver
            Class.forName(driver);
            
             //Establish connection
            Connection insertConnect = DriverManager.getConnection(url);
            System.out.println("Database connected");
           
            //create statement
            Statement insertStatement = insertConnect.createStatement();
           
            //execute statement
            String sql = "INSERT INTO Courses (CourseID,CourseName,Description,CreditHours) VALUES ('"+id+"','"+name+"','"+desc+"','"+hours+"')";
            System.out.println(sql);
            
            int x = insertStatement.executeUpdate(sql);
            if(x>0){
                System.out.println("Database updated!");
            }
            else{
                System.out.println("Database not updated.");
            }
            
            //close connection
            insertConnect.close();
        }
        catch(Exception e){
            System.out.println("InsertDB Error: " + e);
        }
    }//end insertdb
    
    /***************************************************************************
     * Delete database method that deletes a course from the database.
     **************************************************************************/
    public void deleteDB(String id) {
        try{
            //load the driver
            Class.forName(driver);
            
            //Get connected
            Connection deleteConnect = DriverManager.getConnection(url);
            System.out.println("Connected to database within delete method");
            
            //create statement
            Statement deleteStatement = deleteConnect.createStatement();
            
            //execute statement
            String sql = "DELETE FROM Courses WHERE CourseID = '"+id+"'";
            System.out.println(sql);
            
            int z = deleteStatement.executeUpdate(sql);
            if (z>0){
                System.out.println("Database deleted");
            }
            else{
                System.out.println("Database not deleted");
            }
            
            //close connection
            deleteConnect.close();
        }
        catch(Exception e){
            System.out.println("Error within deleteDB: " + e);
        }
    }//end deletedb
    
    /***************************************************************************
     * Update database method that updates a current course in the database.
     **************************************************************************/
    public void updateDB(String id, String name, String desc, int hours){
        try{
            //load the driver
            Class.forName(driver);
            
            //Get connected
            Connection connect = DriverManager.getConnection(url);
            System.out.println("Connected to database within update method");
            
            //create statement
            Statement statement = connect.createStatement();
            
            //execute statement
            String sql = "UPDATE Courses SET CourseName = '"+name+"' , Description = '"+desc+"' , CreditHours = '"+hours+"' WHERE CourseID = '"+id+"'";
            System.out.println(sql);
            
            int y = statement.executeUpdate(sql);
            if (y>0){
                System.out.println("Database updated");
            }
            else{
                System.out.println("Database not updated");
            }
            
            //close connection
            connect.close();
        }
        catch(Exception e){
            System.out.println("Error within updateDB: " + e);
        }
        
    }//end of updateDB method
    
    
    /***************************************************************************
     * Main method to use for testing the courses class.
     **************************************************************************/
    public static void main(String[]args) {
       //Create a customer object
        Courses course = new Courses();
        //course.insertDB("CIST 4000", "Computers", "Everything", 4);
        
        //course.deleteDB("CIST 4000");
        
        //course.updateDB("CIST 4000", "Matrix", "Numbers", 3);
        
        //course.selectDB("CIST 4000");
        //course.display();
        
        //course.deleteDB("CIST 4000");
    }
}
