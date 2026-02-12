package healthclinic.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitializer {


    public static void createDatabaseIfNotExists() {
        String url="jdbc:mysql://localhost:3306/";
        String username="root";
        String password="Avacodes0108@";
        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement()) {

            String sql = "CREATE DATABASE IF NOT EXISTS health_clinic";
            statement.executeUpdate(sql);

            System.out.println("Database checked/created successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void createPatientTable() {

        String patientTableSql = """
                CREATE TABLE IF NOT EXISTS patients (
                    patient_id INT PRIMARY KEY AUTO_INCREMENT,
                    name VARCHAR(100) NOT NULL,
                    dob DATE NOT NULL,
                    contact VARCHAR(15) UNIQUE,
                    email VARCHAR(100) UNIQUE,
                    address TEXT,
                    blood_group VARCHAR(5)
                )
                """;

        try (
            Connection connection = DatabaseConnection.getInstance().getConnection();
            Statement statement = connection.createStatement()
        ) {

            statement.executeUpdate(patientTableSql);
            System.out.println("Patients table created successfully.");

        } 
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
