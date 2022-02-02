import java.sql.*;
/*******************************************************************************
 *  Caitlin Driver
 *  JavaProject
 *  I promise that this is my code.
 ******************************************************************************/

public class Instructors {
    //class properties of the instructors database
    private int instructorID;
    private String firstName;
    private String lastName;
    private String instStreet;
    private String instCity;
    private String instState;
    private int instZip;
    private String instOffice;
    private String instEmail;
    
    private final String url = "jdbc:ucanaccess://C:\\Users\\dihog\\OneDrive\\Documents\\RegistrationMDB";
    private final String driver = "net.ucanaccess.jdbc.UcanaccessDriver";
    
    //Empty argument Constructor
    public Instructors(){
        //initialize properties
        instructorID = 0;
        firstName = "";
        lastName = "";
        instStreet = "";
        instCity = "";
        instState = "";
        instZip = 0;
        instOffice = "";
        instEmail = "";
    }
    
    //Constructor with arguments
    public Instructors(int id, String fname, String lname, String street, String city, String state, int zip, String office, String email) {
        //incoming variables set to class variables
        this.instructorID = id;
        this.firstName = fname;
        this.lastName = lname;
        this.instStreet = street;
        this.instCity = city;
        this.instState = state;
        this.instZip = zip;
        this.instOffice = office;
        this.instEmail = email;
    }
    
    //Get and Set methods for each property
    public void setID(int id){
        instructorID = id;
    }
    public int getID() {
        return instructorID;
    }
    public void setFirstName(String name) {
        firstName = name;
    }
    public String getFirstName(){
        return firstName;
    }
    public void setLastName(String name) {
        lastName = name;
    }
    public String getDescription() {
        return lastName;
    }
    public void setStreet(String street) {
        instStreet = street;
    }
    public String getStreet() {
        return instStreet;
    }
    public void setCity(String city) {
        instCity = city;
    }
    public String getCity() {
        return instCity;
    }
    public void setState(String state) {
        instState = state;
    }
    public String getState() {
        return instState;
    }
    public void setZip(int zip) {
        instZip = zip;
    }
    public int getZip() {
        return instZip;
    }
    public void setOffice(String office) {
        instOffice = office;
    }
    public String getOffice() {
        return instOffice;
    }
    public void setEmail(String email) {
        instEmail = email;
    }
    public String getEmail() {
        return instEmail;
    }
    
    /***************************************************************************
     * Display method for showing the Instructors properties.
     **************************************************************************/
    public void display(){
        System.out.println("Instructor ID: " + instructorID);
        System.out.println("First Name:    " + firstName);
        System.out.println("Last Name:     " + lastName);
        System.out.println("Street:        " + instStreet);
        System.out.println("City:          " + instCity);
        System.out.println("State:         " + instState);
        System.out.println("Zip:           " + instZip);
        System.out.println("Office:        " + instOffice);
        System.out.println("Email:         " + instEmail);
        System.out.println("====================================");
    }
    
    /***************************************************************************
     * Select database method for selecting a specific instructor from the database.
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
            String sql = "SELECT * FROM Instructors WHERE ID = '"+id+"'";
            System.out.println(sql);

            ResultSet results = selectStatement.executeQuery(sql);
            results.next(); //grab all data from customer id
               instructorID = results.getInt(1);
               firstName = results.getString(2);
               lastName = results.getString(3);
               instStreet = results.getString(4);
               instCity = results.getString(5);
               instState = results.getString(6);
               instZip = results.getInt(7);
               instOffice = results.getString(8);
               instEmail = results.getString(9);

            //close connection to database
            selectConnect.close();
        }
        catch(Exception e) { //catch exception
            System.out.println("Select Database Error: " + e);
        }
    }//end selectdb
    
    /***************************************************************************
     * Insert database method to add a new instructor to the database.
     **************************************************************************/
    public void insertDB(int id, String fname, String lname, String street, String city, String state, int zip, String office, String email) {
        try{
            //load the driver
            Class.forName(driver);
            
             //Establish connection
            Connection insertConnect = DriverManager.getConnection(url);
            System.out.println("Database connected");
           
            //create statement
            Statement insertStatement = insertConnect.createStatement();
           
            //execute statement
            String sql = "INSERT INTO Instructors (ID,FirstName,LastName,Street,City,State,Zip,Office,EMail) VALUES ('"+id+"','"+fname+"','"+lname+"','"+street+"','"+city+"','"+state+"','"+zip+"','"+office+"','"+email+"')";
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
     * Delete database method to delete a current instructor from the database.
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
            String sql = "DELETE FROM Instructors WHERE ID = '"+id+"'";
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
     *  Update database method that updates a current instructors information.
     **************************************************************************/
    public void updateDB(int id, String fname, String lname, String street, String city, String state, int zip, String office, String email){
        try{
            //load the driver
            Class.forName(driver);
            
            //Get connected
            Connection connect = DriverManager.getConnection(url);
            System.out.println("Connected to database within update method");
            
            //create statement
            Statement statement = connect.createStatement();
            
            //execute statement
            String sql = "UPDATE Instructors SET FirstName = '"+fname+"' , LastName = '"+lname+"' , Street = '"+street+"' , City = '"+city+"' , State = '"+state+"' , Zip = '"+zip+"' , Office = '"+office+"' , EMail = '"+email+"' WHERE ID = '"+id+"'";
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
     * Main method to testing the class. 
     **************************************************************************/
    public static void main(String[]args) {
        Instructors teach = new Instructors();
        //teach.selectDB(1);
        //teach.display();
        
        //teach.insertDB(10, "Betty", "Crocker", "444 Baking St", "Dallas", "GA", 30157, "office", "email");
        
        //teach.updateDB(10, "fname", "lname", "street", "city", "state", 30157, "office", "email");
        
        teach.deleteDB(10);
    }
}
