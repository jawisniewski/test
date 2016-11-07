import java.sql.*;

/**
 * Created by Hebo on 07.11.2016.
 */
public class dbconnect {


    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/firma_transportowa";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";
    private Connection Conn;
    private Statement Stat;

    public dbconnect() {
        try {
            Class.forName(DB_DRIVER);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Conn=DriverManager.getConnection(DB_CONNECTION,DB_USER,DB_PASSWORD);
            Stat=Conn.createStatement();
        }
        catch (SQLException e){
            e.printStackTrace();
        }



    }
}


