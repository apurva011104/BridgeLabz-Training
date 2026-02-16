public class EmployeeLeaveManagementSystem {
    public static void main(String[] args) {

        EmployeeLeaveManager leaveManager = new EmployeeLeaveManager();

        Employee employee1 = leaveManager.addEmployee("Ava", 20);
        Employee employee2 = leaveManager.addEmployee("Amelia", 15);
        Employee employee3 = leaveManager.addEmployee("Abby", 10);

        leaveManager.applyLeave(employee1, 5);
        leaveManager.applyLeave(employee3, 8);
        leaveManager.applyLeave(employee2, 3);
        leaveManager.applyLeave(employee1, 2);
        leaveManager.applyLeave(employee3, 5);
        leaveManager.applyLeave(employee1, 4);

        leaveManager.processLeaveRequests();
    }
}
