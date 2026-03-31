import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeLeaveManager {
    
    private final Map<String, Employee> employeeRecord;
    private final List<LeaveRequest> leaveRequestRecord;

    public EmployeeLeaveManager() {
        this.employeeRecord = new HashMap<>();
        this.leaveRequestRecord = new ArrayList<>();
    }

    private final String generateEmployeeID(){
        String id;
        do { 
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 10; i++) {
                sb.append((int)(Math.random()*10));
            }
            id = "EMP" + sb.toString();
        } 
        while (employeeRecord.containsKey(id));
        return id;
    }

    public Employee addEmployee(String name, int leaveBalance){
        if(name==null || name.isEmpty() || leaveBalance<10){
            throw new IllegalArgumentException("Invalid data");
        }
        String id = generateEmployeeID();
        Employee employee = new Employee(id, name, leaveBalance);
        employeeRecord.put(id, employee);
        return employee;
    }

    public void applyLeave(Employee employee, int numberOfDays){
        if(employee==null || !employeeRecord.containsKey(employee.getEmployeeId())){
            throw new IllegalArgumentException("No such employee found in the record");
        }
        if(numberOfDays<=0){
            throw new IllegalArgumentException("Invalid number of days!");
        }
        LeaveRequest request = new LeaveRequest(employee, numberOfDays);
        leaveRequestRecord.add(request);
    }

    public void processLeaveRequests(){
        for(int i=0; i<leaveRequestRecord.size(); i++){
            LeaveRequest request = leaveRequestRecord.get(i);
            if(request.getStatus()!=LeaveStatus.PENDING){
                continue;
            }
            Employee employee = request.getEmployee();
            int numberOfDays = request.getNumberOfDays();
            try {
                validateLeaveBalance(employee, numberOfDays);
                request.setStatus(LeaveStatus.APPROVED);
                employee.setLeaveBalance(employee.getLeaveBalance() - numberOfDays);
                System.out.println("Leave request approved for employee "+employee.getName()+" for "+numberOfDays+" days.");

            } catch (InsufficientLeaveBalanceException e) {
                System.out.println("Leave request rejected. "+e.getMessage());
                request.setStatus(LeaveStatus.REJECTED);
            }
        }
    }
    
    private boolean validateLeaveBalance(Employee employee, int numberOfDays) throws InsufficientLeaveBalanceException{
        if(employee.getLeaveBalance()<numberOfDays){
            throw new InsufficientLeaveBalanceException("Insufficient leave balance for "+employee.getName());
        }
        return true;

    }
}
