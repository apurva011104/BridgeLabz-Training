package healthclinic;

import healthclinic.util.DatabaseInitializer;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the Health Clinic Management System!");
        DatabaseInitializer.createDatabaseIfNotExists();
        DatabaseInitializer.createPatientTable();
    }
}
