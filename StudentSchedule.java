import java.sql.*;
/*******************************************************************************
 *  Caitlin Driver
 *  JavaProject
 *  I promise that this is my code.
 ******************************************************************************/

public class StudentSchedule {
    //class properties
    private int studentID;
    private int crn;
    private int[] crnArray;
    
    private final String url = "jdbc:ucanaccess://C:\\Users\\dihog\\OneDrive\\Documents\\RegistrationMDB";
    private final String driver = "net.ucanaccess.jdbc.UcanaccessDriver";
    
    //Empty argument Constructor
    public StudentSchedule() {
        //initialize properties
        studentID = 0;
        crn = 0;
    }
    
    //Constructor with arguments
    public StudentSchedule(int id, int secNum) {
        this.studentID = id;
        this.crn = secNum;
    }
    
    //Get and Set methods for each property
    public void setStudentID(int id){
        studentID = id;
    }
    public int getID() {
        return studentID;
    }
    public void setCRN(int secNum) {
        crn = secNum;
    }
    public int getCRN(){
        return crn;
    }
    public int[] getCRNArray() {
        return crnArray;
    }
    
    /***************************************************************************
     * Display method for showing the student schedule properties.
     **************************************************************************/
    public void display(){
        
        System.out.println("StudentID: " + studentID);
        for(int z = 0;z<crnArray.length;z++){
        System.out.println("CRN :      " + crnArray[z]);
        }
        System.out.println("=============================");
    }
    
    /***************************************************************************
     * Select database method for selecting a current students schedule from the 
     * database.
     **************************************************************************/
    public void selectDB(int id) {
        studentID = id;
        try {
            //load the driver
            Class.forName(driver);
            
            //Establish a connection
            Connection selectConnect = DriverManager.getConnection(url);
            System.out.println("SelectDB Connected");
            
            //Create statement
            Statement selectStatement = selectConnect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
            //execute statement
            String sql = "SELECT CRN FROM StudentSchedule WHERE StudentID = "+studentID;
            System.out.println(sql);

            ResultSet results = selectStatement.executeQuery(sql);
            
                results.last();
                int size = results.getRow();
                results.beforeFirst();
                crnArray = new int[size];
                
            for(int x=0;x<crnArray.length;x++){
                results.next();
                crnArray[x]=results.getInt(1);
            }   
            

            //close connection to database
            selectConnect.close();
        }
        catch(Exception e) { //catch exception
            System.out.println("Select Database Error: " + e);
        }
    }//end selectdb
    
    /***************************************************************************
     * Insert database method for adding a new section to a students schedule.
     **************************************************************************/
    public void insertDB(int id, int secNum) {
        try{
            //load the driver
            Class.forName(driver);
            
             //Establish connection
            Connection insertConnect = DriverManager.getConnection(url);
            System.out.println("Database connected");
           
            //create statement
            Statement insertStatement = insertConnect.createStatement();
           
            //execute statement
            String sql = "INSERT INTO StudentSchedule (StudentID,CRN) VALUES ("+id+","+secNum+")";
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
     * Delete database method for deleting an existing student id from the schedule.
     **************************************************************************/
    public void deleteDB(int id) {
        try{
            //load the driver
            Class.forName(driver);
            
            //Get connected
            Connection deleteConnect = DriverManager.getConnection(url);
            System.out.println("Connected to database within delete method");
            
            //create statement
            Statement deleteStatement = deleteConnect.createStatement();
            
            //execute statement
            String sql = "DELETE FROM StudentSchedule WHERE StudentID = "+id+"";
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
     * Update database method for updating an existing schedule on the database.
     **************************************************************************/
    public void updateDB(int id, int secNum){
        try{
            //load the driver
            Class.forName(driver);
            
            //Get connected
            Connection connect = DriverManager.getConnection(url);
            System.out.println("Connected to database within update method");
            
            //create statement
            Statement statement = connect.createStatement();
            
            //execute statement
            String sql = "UPDATE StudentSchedule SET CRN = "+secNum+" WHERE StudentID = "+id+"";
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
     * Main method for testing the student schedule class.
     **************************************************************************/
    public static void main(String[]args) {
        StudentSchedule schedule = new StudentSchedule();
        //schedule.selectDB(16);
        //schedule.display();
        //schedule.selectDB(3);
        //schedule.display();
        
        //schedule.insertDB(20,30111);
        //schedule.updateDB(20, 30101);
        //schedule.deleteDB(20);
    }
    
}
