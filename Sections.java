import java.sql.*;

/*******************************************************************************
 *  Caitlin Driver
 *  JavaProject
 *  I promise that this is my code.
 ******************************************************************************/

public class Sections {
    //class properties
    private int crn;
    private String courseID;
    private String timeDays;
    private String roomNo;
    private int instructor;
    
    private final String url = "jdbc:ucanaccess://C:\\Users\\dihog\\OneDrive\\Documents\\RegistrationMDB";
    private final String driver = "net.ucanaccess.jdbc.UcanaccessDriver";
    
    //Empty argument Constructor
    public Sections() {
        //initialize properties
        crn = 0;
        courseID = "";
        timeDays = "";
        roomNo = "";
        instructor = 0;
    }
    
    //Constructor with arguments
    public Sections(int secNum, String course, String time, String room, int teacher) {
        //set incoming variables to class variables
        this.crn = secNum;
        this.courseID = course;
        this.timeDays = time;
        this.roomNo = room;
        this.instructor = teacher;
    }
    
    //Get and Set methods for each property
    public void setCRN(int secNum){
        crn = secNum;
    }
    public int getCRN() {
        return crn;
    }
    public void setCourseID(String course) {
        courseID = course;
    }
    public String getCourseID(){
        return courseID;
    }
    public void setTimeDays(String time) {
        timeDays = time;
    }
    public String getTimeDays() {
        return timeDays;
    }
    public void setRoomNo(String room) {
        roomNo = room;
    }
    public String getRoomNo() {
        return roomNo;
    }
    public void setInstructor(int teacher) {
        instructor = teacher;
    }
    public int getinstructor() {
        return instructor;
    }
    
    /***************************************************************************
     * Display method for showing the sections properties.
     **************************************************************************/
    public void display(){
        System.out.println("CRN:        " + crn);
        System.out.println("CourseID:   " + courseID);
        System.out.println("TimeDays:   " + timeDays);
        System.out.println("RoomNo:     " + roomNo);
        System.out.println("Instructor: " + instructor);
        System.out.println("=================================");
    }
    
    /***************************************************************************
     * Select database method for selecting a current section from the database. 
     **************************************************************************/
    public void selectDB(int secNum) {
        crn = secNum;
        try {
            //load the driver
            Class.forName(driver);
            
            //Establish a connection
            Connection selectConnect = DriverManager.getConnection(url);
            System.out.println("SelectDB Connected");
            
            //Create statement
            Statement selectStatement = selectConnect.createStatement();
            
            //execute statement
            String sql = "SELECT * FROM Sections WHERE CRN = "+crn+"";
            System.out.println(sql);

            ResultSet results = selectStatement.executeQuery(sql);
            results.next(); //grab all data from customer id
               crn = results.getInt(1);
               courseID = results.getString(2);
               timeDays = results.getString(3);
               roomNo = results.getString(4);
               instructor = results.getInt(5);

            //close connection to database
            selectConnect.close();
        }
        catch(Exception e) { //catch exception
            System.out.println("Select Database Error: " + e);
        }
    }//end selectdb
    
    /***************************************************************************
     * Insert database method for inserting a new section into the database.
     **************************************************************************/
    public void insertDB(int secNum, String course, String time, String room, int teacher) {
        crn = secNum;
        courseID = course;
        timeDays = time;
        roomNo = room;
        instructor = teacher;
        try{
            //load the driver
            Class.forName(driver);
            
             //Establish connection
            Connection insertConnect = DriverManager.getConnection(url);
            System.out.println("Database connected");
           
            //create statement
            Statement insertStatement = insertConnect.createStatement();
           
            //execute statement
            String sql = "INSERT INTO Sections (CRN,CourseID,TimeDays,RoomNo,Instructor) VALUES ("+crn+",'"+courseID+"','"+timeDays+"','"+roomNo+"',"+instructor+")";
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
     * Delete database method to delete a current section from the database.
     **************************************************************************/
    public void deleteDB(int secNum) {
        crn = secNum;
        try{
            //load the driver
            Class.forName(driver);
            
            //Get connected
            Connection deleteConnect = DriverManager.getConnection(url);
            System.out.println("Connected to database within delete method");
            
            //create statement
            Statement deleteStatement = deleteConnect.createStatement();
            
            //execute statement
            String sql = "DELETE FROM Sections WHERE CRN = "+crn+"";
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
     * Update database method to update an existing section from the database.
     **************************************************************************/
    public void updateDB(int secNum, String course, String time, String room, int teacher){
        crn = secNum;
        courseID = course;
        timeDays = time;
        roomNo = room;
        instructor = teacher;
        try{
            //load the driver
            Class.forName(driver);
            
            //Get connected
            Connection connect = DriverManager.getConnection(url);
            System.out.println("Connected to database within update method");
            
            //create statement
            Statement statement = connect.createStatement();
            
            //execute statement
            String sql = "UPDATE Sections SET CourseID = '"+courseID+"' , TimeDays = '"+timeDays+"' , RoomNo = '"+roomNo+"' , Instructor = "+instructor+" WHERE CRN = "+crn+"";
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
     *  Main method for testing the sections class.
     **************************************************************************/
    public static void main(String[]args) {
        Sections sec = new Sections();
        
        //sec.selectDB(30101);
        //sec.display();
        
        //sec.insertDB(40000, "course", "time", "room", 10);
        
        //sec.updateDB(40000, "CIST 3000", "S12pm-2pm", "F1200", 8);
        
        sec.deleteDB(40000);
    }
    
}
