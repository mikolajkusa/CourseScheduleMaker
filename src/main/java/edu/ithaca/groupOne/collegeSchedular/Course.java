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
    /**
     * Decrements the student count for a course
     * @throws CourseEmptyException if student count is zero
     * @throws CourseUnavailableException if the course availability is set to false
     */
    public void removeStudent() throws CourseEmptyException, CourseUnavailableException{
        if(!isAvailable){
            throw new CourseUnavailableException("This course is unavailable");
        }
        else if(studentCount == 0){
            throw new CourseEmptyException("Can't remove student from an empty course");
        }
        studentCount--;
    }

    /**
     * Increments the student count for a class
     * @throws CourseUnavailableException if the course availability is set to flase
     * @throws StudentMaximumExceededException if the student maximum is reached
     */
    public void addStudent() throws CourseUnavailableException, StudentMaximumExceededException{
        if(!isAvailable){
            throw new CourseUnavailableException("This course is unavailable");
        }
        else if(studentCount == maxStudentCount){
            throw new StudentMaximumExceededException("Course is already full.");
        }
        studentCount++;

    }

    public static boolean isCourseValid(Course course){

        if(course == null || course.courseID < 0 || course.maxStudentCount < 1){
            return false;
        }

        return true;
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

    public void setMaxStudentCount(int maxStudentCount){
        this.maxStudentCount = maxStudentCount;
    }
    /**
     * sets availability of course. Sets student count to zero if status is false.
     * @param status
     */
    public void setAvailability(boolean status){
        if(!status){
            studentCount = 0;
        }
        isAvailable = status;
    }

    public void setSemester(String semester){
        this.semester = semester;
    }

    public void setTimeSlot(String timeSlot){
        this.timeSlot = timeSlot;
    }

    public void setMajor(String major){
        this.major = major;
    }

    public void setCredits(double credits){
        this.credits = credits;
    }
}