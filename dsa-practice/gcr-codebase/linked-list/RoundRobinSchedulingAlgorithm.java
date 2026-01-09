import java.util.HashSet;
import java.util.Set;

class Process {
    private final String processId;
    private int burstTime;
    private int priority;

    public Process(String processId, int burstTime, int priority) {
        this.processId = processId;
        this.burstTime = burstTime;
        this.priority = priority;
    }

    public String getProcessId(){
        return processId; 
    }

    public int getBurstTime(){
        return burstTime; 
    }

    public int getPriority(){
        return priority; 
    }

    public void setBurstTime(int burstTime){
        this.burstTime = burstTime; 
    }

    public void displayProcess() {
        System.out.printf("Process ID: %s, Burst Time: %d, Priority: %d%n",processId, burstTime, priority);
    }
}


class ProcessNode {
    private Process process;
    private ProcessNode next;

    public ProcessNode(Process process) {
        this.process = process;
    }

    public Process getProcess() {
        return process;
    }

    public ProcessNode getNext() {
        return next;
    }

    public void setNext(ProcessNode next) {
        this.next = next;
    }


}

// Round Robin Scheduler using Circular Linked List
public class RoundRobinSchedulingAlgorithm {

    private Set<String> allProcessIDs;
    private ProcessNode processHead;
    private ProcessNode processTail;

    public RoundRobinSchedulingAlgorithm() {
        allProcessIDs = new HashSet<>();
    }

    //Method to check if process already exists
    private boolean processExists(String processId) {
        return allProcessIDs.contains(processId);
    }

    //CREATE OPERATIONS

    //Method to add process
    public void addProcess(String processId, int burstTime, int priority) {
        if (processExists(processId)) {
            System.out.println("Process ID already exists");
            return;
        }

        Process process = new Process(processId, burstTime, priority);
        ProcessNode newNode = new ProcessNode(process);

        if (processHead == null) { 
            processHead = newNode;
            processTail = newNode;
            newNode.setNext(newNode); 
        } 
        else {
            processTail.setNext(newNode);
            newNode.setNext(processHead);
            processTail = newNode;
        }

        allProcessIDs.add(processId);
        System.out.println("Process added successfully");
    }

    //DELETE OPERATIONS

    //Method to remove process
    public void removeProcess(String processId) {
        if (!processExists(processId)) {
            System.out.println("No such process exists");
            return;
        }

        ProcessNode current = processHead;
        ProcessNode previous = processTail;

        do {
            if (current.getProcess().getProcessId().equals(processId)) {
                if (current == processHead) {
                    if (processHead == processTail) {
                        processHead =  null;
                        processTail = null;
                    } 
                    else {
                        processHead = processHead.getNext();
                        processTail.setNext(processHead);
                    }
                } 
                else if (current == processTail) {
                    processTail = previous;
                    processTail.setNext(processHead);
                } 
                else {
                    previous.setNext(current.getNext());
                }

                allProcessIDs.remove(processId);
                System.out.println("Process removed successfully");
                return;
            }
            previous = current;
            current = current.getNext();
        } while (current != processHead);
    }

    //Read operations

    //Method to display pprocesses
    public void displayProcesses() {

        if (processHead == null) {
            System.out.println("No processes found in the queue");
            return;
        }

        System.out.println("All processes:");
        ProcessNode current = processHead;
        do {
            current.getProcess().displayProcess();
            current = current.getNext();
        } while (current != processHead);
    }

    //Method to simulate scheduling of processes
    public void simulateProcessScheduling(int timeQuantum) {
        if (processHead == null) {
            System.out.println("No processes to schedule");
            return;
        }

        int totalProcesses = allProcessIDs.size();
        int totalWaitingTime = 0;
        int totalTurnAroundTime = 0;

        ProcessNode current = processHead;
        ProcessNode previous = processTail;

        System.out.println("Starting Round Robin Simulation with time quantum = " + timeQuantum);

        while (allProcessIDs.size() > 0) {
            do {

                Process process = current.getProcess();

                if (process.getBurstTime() <= timeQuantum) {
                    System.out.printf("Executing %s for %d ms (completed)%n",process.getProcessId(), process.getBurstTime());
                    totalWaitingTime += 0; 
                    totalTurnAroundTime += process.getBurstTime();
                    ProcessNode nextNode = current.getNext();
                    removeProcess(process.getProcessId());
                    current = nextNode;
                    previous = processTail;

                } 
                else {

                    System.out.printf("Executing %s for %d units (remaining %d)%n",process.getProcessId(), timeQuantum, process.getBurstTime() - timeQuantum);

                    process.setBurstTime(process.getBurstTime() - timeQuantum);
                    previous = current;
                    current = current.getNext();

                }

                displayProcesses();

            } 
            while (current != processHead && processHead != null);
        }

        double averageWaitingTime = totalWaitingTime / (double) totalProcesses;
        double averageTurnaroundTime = totalTurnAroundTime / (double) totalProcesses;

        System.out.printf("Average Waiting Time: %.2f ms%n", averageWaitingTime);
        System.out.printf("Average Turnaround Time: %.2f ms%n", averageTurnaroundTime);
    }

    //Main method for testing
    public static void main(String[] args) {
        RoundRobinSchedulingAlgorithm roundRobin = new RoundRobinSchedulingAlgorithm();

        roundRobin.addProcess("P1251", 10, 1);
        roundRobin.addProcess("P2247", 5, 2);
        roundRobin.addProcess("P4723", 8, 1);

        roundRobin.displayProcesses();

        roundRobin.simulateProcessScheduling(4);
    }
}
