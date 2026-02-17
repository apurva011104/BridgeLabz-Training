package com.bridgelabz;

import java.util.Scanner;

import com.bridgelabz.model.Employee;
import com.bridgelabz.service.EmployeeService;

public class UserInterface{
    public static void main(String [] args){
        System.out.println("Welcome to employee wage computation program");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter employee id: ");
        String id = scanner.nextLine().trim().replaceAll("\\s+", " ");
        System.out.println("Enter employee name: ");
        String name = scanner.nextLine().trim().replaceAll("\\s+", " ");;

        Employee employee = new Employee(id, name);
        
        EmployeeService service = new EmployeeService();

        boolean isPresent = service.checkAttendance(employee);

        System.out.println("Employee is "+(isPresent?"present":"absent"));

    }
}