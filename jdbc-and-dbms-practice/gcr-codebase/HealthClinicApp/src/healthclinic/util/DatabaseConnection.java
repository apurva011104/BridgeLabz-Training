package healthclinic.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    
    private static DatabaseConnection instance;
    private Connection connection;

    private DatabaseConnection(){
        try {
            String url="jdbc:mysql://localhost:3306/health_clinic";
            String username="root";
            String password="Avacodes0108@";
            this.connection = DriverManager.getConnection(url,username,password);
            System.out.println("Database connection established successfully.");
        } 
        catch (SQLException e) {
            System.err.println("Database connection failed. Error:  "+e.getMessage());
        }
    }

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
    
    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Database connection closed.");
            } catch (SQLException e) {
                System.err.println("Error closing connection: " + e.getMessage());
            }
        }
    }

}
