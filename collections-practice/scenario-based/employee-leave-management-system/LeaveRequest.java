public class LeaveRequest {
    
    private final Employee employee;
    private final int numberOfDays;
    private LeaveStatus status;

    public LeaveRequest(Employee employee, int numberOfDays) {
        this.employee = employee;
        this.numberOfDays = numberOfDays;
        this.status = LeaveStatus.PENDING;
    }

    public Employee getEmployee() {
        return employee;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public LeaveStatus getStatus() {
        return status;
    }

    public void setStatus(LeaveStatus status) {
        this.status = status;
    }

}
