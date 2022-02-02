import java.sql.*;
/*******************************************************************************
 *  Caitlin Driver
 *  JavaProject
 *  I promise that this is my code.
 ******************************************************************************/

public class Students {
    //class properties
    private int studID;
    private String password;
    private String firstName;
    private String lastName;
    private String studStreet;
    private String studCity;
    private String studState;
    private int studZip;
    private String studEmail;
    private double studGPA;
    
    private final String url = "jdbc:ucanaccess://C:\\Users\\dihog\\OneDrive\\Documents\\RegistrationMDB";
    private final String driver = "net.ucanaccess.jdbc.UcanaccessDriver";
    
    //Empty argument Constructor
    public Students() {
        //initialize properties
        studID = 0;
        password = "";
        firstName = "";
        lastName = "";
        studStreet = "";
        studCity = "";
        studState = "";
        studZip = 0;
        studEmail = "";
        studGPA = 0.0;
    }
    
    //Constructor with arguments
    public Students(int id, String pw, String fname, String lname, String street, String city, String state, int zip, String email, double gpa) {
        //set incoming variables to class variables
        this.studID = id;
        this.password = pw;
        this.firstName = fname;
        this.lastName = lname;
        this.studStreet = street;
        this.studCity = city;
        this.studState = state;
        this.studZip = zip;
        this.studEmail = email;
        this.studGPA = gpa;
    }
    
    //Get and Set methods for each property
    public void setStudentID(int id){
        studID = id;
    }
    public int getStudentID() {
        return studID;
    }
    public void setPassword(String pw) {
        password = pw;
    }
    public String getPassword(){
        return password;
    }
    public void setFirstName(String name) {
        firstName = name;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setLastName(String name) {
        lastName = name;
    }
    public String getLastName() {
        return lastName;
    }
    public void setStreet(String street) {
        studStreet = street;
    }
    public String getStreet() {
        return studStreet;
    }
    public void setCity(String city) {
        studCity = city;
    }
    public String getCity() {
        return studCity;
    }
    public void setState(String state) {
        studState = state;
    }
    public String getState() {
        return studState;
    }
    public void setZip(int zip) {
        studZip = zip;
    }
    public int getZip() {
        return studZip;
    }
    public void setEmail(String email) {
        studEmail = email;
    }
    public String getEmail() {
        return studEmail;
    }
    public void setGPA(double gpa) {
        studGPA = gpa;
    }
    public double getGPA() {
        return studGPA;
    }
    
    /***************************************************************************
     * Display method for showing the Student properties and their values.
     **************************************************************************/
    public void display(){
        System.out.println("ID:         " + studID);
        System.out.println("Password:   " + password);
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name:  " + lastName);
        System.out.println("Street:     " + studStreet);
        System.out.println("City:       " + studCity);
        System.out.println("State:      " + studState);
        System.out.println("Zip:        " + studZip);
        System.out.println("Email:      " + studEmail);
        System.out.println("GPA:        " + studGPA);
        System.out.println("=================================");
    }
    
    /***************************************************************************
     * Select database method for selecting a current student from the database. 
     **************************************************************************/
    public void selectDB(int id) {
        
        try {
            //load the driver
            Class.forName(driver);
            
            //Establish a connection
            Connection selectConnect = DriverManager.getConnection(url);
            System.out.println("SelectDB Connected");
            
            //Create statement
            Statement selectStatement = selectConnect.createStatement();
            
            //execute statement
            String sql = "SELECT * FROM Students WHERE ID = "+id+"";
            System.out.println(sql);

            ResultSet results = selectStatement.executeQuery(sql);
            results.next(); //grab all data from customer id
               studID = results.getInt(1);
               password = results.getString(2);
               firstName = results.getString(3);
               lastName = results.getString(4);
               studStreet = results.getString(5);
               studCity = results.getString(6);
               studState = results.getString(7);
               studZip = results.getInt(8);
               studEmail = results.getString(9);
               studGPA = results.getDouble(10);

            //close connection to database
            selectConnect.close();
        }
        catch(Exception e) { //catch exception
            System.out.println("Select Database Error: " + e);
        }
    }//end selectdb
 
    /***************************************************************************
     * Insert database method for adding a new student to the database. 
     **************************************************************************/
    public void insertDB(int id, String pw, String fname, String lname, String street, String city, String state, int zip, String email, double gpa) {
        try{
            //load the driver
            Class.forName(driver);
            
             //Establish connection
            Connection insertConnect = DriverManager.getConnection(url);
            System.out.println("Database connected");
           
            //create statement
            Statement insertStatement = insertConnect.createStatement();
           
            //execute statement
            String sql = "INSERT INTO Students (ID,Password,FirstName,LastName,Street,City,State,Zip,EMail,GPA) VALUES ("+id+",'"+pw+"','"+fname+"','"+lname+"','"+street+"','"+city+"','"+state+"',"+zip+",'"+email+"',"+gpa+")";
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
     * Delete database method used to delete an existing student from the database. 
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
            String sql = "DELETE FROM Students WHERE ID = "+id+"";
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
     * Update database method for updating an existing students information to the database.
     **************************************************************************/
    public void updateDB(int id, String pw, String fname, String lname, String street, String city, String state, int zip, String email, double gpa){
        try{
            System.out.println("Am I in updae method?");
            
            //load the driver
            Class.forName(driver);
            
            //Get connected
            Connection connect = DriverManager.getConnection(url);
            System.out.println("Connected to database within update method");
            
            //create statement
            Statement statement = connect.createStatement();
            
            //execute statement
            String sql = "UPDATE Students SET Password = '"+pw+"' , FirstName = '"+fname+"' , LastName = '"+lname+"' , Street = '"+street+"' , City = '"+city+"' , State = '"+state+"' , Zip = "+zip+" , Email = '"+email+"' , GPA = "+gpa+" WHERE ID = "+id+"";
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
     * Main method for testing the Students class. 
     **************************************************************************/
    public static void main(String[]args) {
        Students student = new Students();
        //student.selectDB(10);
        //student.display();
        
        //student.insertDB(20, "hello", "fname", "lname", "street", "city", "state", 12345, "email", 4.0);
        //student.updateDB(20, "sike", "apple", "sauce", "street", "city", "state", 54321, "email", 3.0);
        student.deleteDB(20);
    }
}