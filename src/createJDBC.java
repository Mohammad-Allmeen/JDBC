// In CRUD operation, this code is about creating/inserting, updating and deleting the data from the code




import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.*;

public class createJDBC {
    public static void main(String[] args) throws Exception {


        Class.forName("org.postgresql.Driver");

       // Step: Connecting to the database

        String url="jdbc:postgresql://localhost:5432/Demo";  // java connecting with jdbc, then postgresql data name, then the IP address
        String uname ="postgres";
        String pass= "2022";
        Connection con = DriverManager.getConnection(url,uname,pass);

        //---query for inserting the values
       // String query = "insert into student values(8, 'Arhan', 92)";

        //---query for updating the values
      String query2 = "update student set sid= 8 where sid=9";

        //---query for deleting the value from the table
      //  String query3= "delete from student where sid= 7";


        System.out.println("Connection established");


        // Step: Creating the statement
        Statement st= con.createStatement(); // Statement is the interface and createStatement is the method of the Connection class accessed through the object con

        // Step: Execute the statement

         //boolean status=st.execute(query); // this method return boolean because this will provide true/false statement that your data in inserted or not you are not fetching its just you are inserting the data in the table
        boolean status2=st.execute(query2);
        //boolean status3 = st.execute(query3);
        System.out.println(status2);


        //Step: Closing the connection
        con.close();
        System.out.println("Closing the connection");

    }
}


