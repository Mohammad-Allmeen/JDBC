// Code when the user enters the data from the console or data comes from any website
// Prepared statement is used when the data is coming from the user
// PreparedStatement extends the Statement therefore its the child class of thr Statement
// Whenever data comes from the user for example website or from the console

import java.sql.*;

public class PreparedStatementTopic {
    public static void main(String[] args) throws SQLException{

        // Loading and registering the driver

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
          e.printStackTrace();
        }

        String url= "jdbc:postgresql://localhost:5432/Demo";
        String uname= "postgres";
        String pass= "2022";
        Connection con = DriverManager.getConnection(url, uname, pass);


        String query= "insert into student values(?,?,?)";

        int sid= 9;
        String sname= "Aahil";
        int marks= 90;

        PreparedStatement st= con.prepareStatement(query);


        st.setInt(1,sid);
        st.setString(2,sname);
        st.setInt(3, marks);
        st.execute();

        st.close();
        con.close();
        }
    }

