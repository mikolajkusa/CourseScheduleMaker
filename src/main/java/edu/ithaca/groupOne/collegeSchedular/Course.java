package edu.ithaca.groupOne.collegeSchedular;

public class Course {

    private int courseID;
    private int studentCount;
    private int maxStudentCount;
    private double credits;
    private String major;
    private String semester;
    private boolean isAvailable;
    private String timeSlot;

    public Course(int courseID, int maxStudentCount, double credits, String major, String semester, String timeSlot){
        this.courseID = courseID;
        studentCount = 0;
        this.maxStudentCount = maxStudentCount;
        this.credits = credits;
        this.major = major;
        this.semester = semester;
        isAvailable = false;
        this.timeSlot = timeSlot;
    }
    
    public void removeStudent(){

    }

    public void addStudent(){

    }

    public int getCourseID(){
        return courseID;
    }

    public int getStudentCount(){
        return studentCount;
    }

    public int getMaxStudentCount(){
        return maxStudentCount;
    }

    public double getCredits(){
        return credits;
    }

    public String getMajor(){
        return major;
    }

    public String getSemester(){
        return semester;
    }

    public boolean getAvailability(){
        return isAvailable;
    }
    
    public String getTimeSlot(){
        return timeSlot;
    }
}
