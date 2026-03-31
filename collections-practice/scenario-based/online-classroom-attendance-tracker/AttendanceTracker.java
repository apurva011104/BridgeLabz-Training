
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AttendanceTracker{

    private final Set<String> studentIDs;
    private final Map<String, Set<String>> attendanceRecord;

    public AttendanceTracker() {
        this.studentIDs = new HashSet<>();
        this.attendanceRecord = new HashMap<>();
    }

    public void addStudent(String studentID){
        if(studentIDs.contains(studentID)){
            throw new IllegalArgumentException("Student ID is already present in the record.");
        }
        studentIDs.add(studentID);
    }

    public void createSession(String sessionID){
        if(attendanceRecord.containsKey(sessionID)){
            throw new IllegalArgumentException("Session with the following session ID has already been created.");
        }
       
        attendanceRecord.put(sessionID, new HashSet<>());
    }

    public void markAttendance(String sessionID, String studentID) throws DuplicateAttendanceException{
        if(!studentIDs.contains(studentID)){
            throw new IllegalArgumentException("No such student ID found in the record");
        }
        if(!attendanceRecord.containsKey(sessionID)){
            throw new IllegalArgumentException("No such session ID found in the record");
        }
        Set<String> attendance = attendanceRecord.get(sessionID);
        if(attendance.contains(studentID)){
            throw new DuplicateAttendanceException("Student "+ studentID +" is already marked as present for session "+sessionID+"!");            
        }
        attendance.add(studentID);
        System.out.println("Student "+studentID+" is marked present for session "+sessionID);
    }
    
    public void removeAttendance(String sessionID, String studentID){
        if(!studentIDs.contains(studentID)){
            throw new IllegalArgumentException("No such student ID found in the record");
        }
        if(!attendanceRecord.containsKey(sessionID)){
            throw new IllegalArgumentException("No such session ID found in the record");
        }
        Set<String> attendance = attendanceRecord.get(sessionID);
        if(!attendance.contains(studentID)){
            throw new IllegalArgumentException("Student was never marked present!");            
        }
        attendance.remove(studentID);
        System.out.println("Student "+studentID+" is marked absent for session "+sessionID);
    }

    public void displayAttendance(){
        if(attendanceRecord.isEmpty()){
            System.out.println("No sessions found.");
            return;
        }
        System.out.println("-----------------------Attendance Record-----------------------");
        for(Map.Entry<String, Set<String>> entry: attendanceRecord.entrySet()){
            System.out.println("Session ID: "+entry.getKey());
            Set<String> attendes = entry.getValue();
            if(attendes.isEmpty()){
                System.out.println("No students has attended this session");
            }
            else{
                System.out.println("Present students IDs: "+ attendes);
            }
            System.out.println();
        }
        System.out.println("---------------------------------------------------------------");

    }
}