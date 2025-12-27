// In CRUD operation, this code is all about reading the data




import java.sql.*;

public class demoJDBC {
    public static void main(String[] args) throws Exception {

        /*
        Process of connecting to JDBC

        Import the package
        load and register
        create the connection
        create the statement
        execute the statement
        close the connection- this is the important step to prevent the data leakage
         */

        //Step: loading and registering the driver

     Class.forName("org.postgresql.Driver");

// Step: Connecting to the database

     String url="jdbc:postgresql://localhost:5432/Demo";  // java connecting with jdbc, then postgresql data name, then the IP address
     String uname ="postgres";
     String pass= "2022";
     Connection con = DriverManager.getConnection(url,uname,pass);

     //String query = "select sname from student where sid = 1";  // creating the query to get one row
       String query = "select * from student";


     System.out.println("Connection established");


     // Creating the statement
        Statement st= con.createStatement(); // Statement is the interface and createStatement is the method of the Connection class accessed through the object con

     // Execute the statement
        ResultSet rs = st.executeQuery(query);

//        rs.next(); // the return type of next() is boolean therefore if the data is available it will print true
//        // rs.next is done before fetching the data as the pointer is on the first row.This next is done to check the data is present in the next row or not
//        String name = rs.getString("sname"); // this getString method will provide the data of this column
//        System.out.println("The name of the student is "+ name);


        // statement to get all the data from the table
        while(rs.next()){
            System.out.print(rs.getInt("sid")+" - "); //getInt as value of this column is Integer type, moreover in name you can also mention column number
            System.out.print(rs.getString("sname")+" - ");
            System.out.println(rs.getInt("marks"));
        }


     //closing the connection
        con.close();
        System.out.println("Closing the connection");

 }
 }

