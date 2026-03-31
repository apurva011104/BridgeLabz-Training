public class OnlineClassroomAttendanceTrackerMain {
    
    public static void markAttendance(AttendanceTracker tracker, String sessionId, String studentId){
        try {
            tracker.markAttendance(sessionId, studentId);
        } 
        catch (DuplicateAttendanceException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        AttendanceTracker tracker = new AttendanceTracker();

        String studentId1 = "STU123";
        String studentId2 = "STU456";
        String studentId3 = "STU789";
        String studentId4 = "STU147";
        String studentId5 = "STU258";

        String sessionId1 = "SSN1234";
        String sessionId2 = "SSN5678";
        String sessionId3 = "SSN9012";

        tracker.addStudent(studentId1);
        tracker.addStudent(studentId2);
        tracker.addStudent(studentId3);
        tracker.addStudent(studentId4);
        tracker.addStudent(studentId5);

        tracker.createSession(sessionId1);
        tracker.createSession(sessionId2);
        tracker.createSession(sessionId3);

        markAttendance(tracker, sessionId1, studentId1);
        markAttendance(tracker, sessionId1, studentId3);
        markAttendance(tracker, sessionId1, studentId5);
        markAttendance(tracker, sessionId1, studentId1);
        markAttendance(tracker, sessionId2, studentId2);
        markAttendance(tracker, sessionId2, studentId4);
        markAttendance(tracker, sessionId2, studentId1);

        tracker.displayAttendance();
        
        tracker.removeAttendance(sessionId2, studentId1);

        tracker.displayAttendance();
    }
}
