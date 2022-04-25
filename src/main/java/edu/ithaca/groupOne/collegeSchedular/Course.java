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

    public Course(int courseID, int maxStudentCount, double credits, String major, String semester, String timeSlot) throws IllegalArgumentException{
        if(courseIsValid(timeSlot)){
            this.courseID = courseID;
            studentCount = 0;
            this.maxStudentCount = maxStudentCount;
            this.credits = credits;
            this.major = major;
            this.semester = semester;
            isAvailable = false;
            this.timeSlot = timeSlot;
        }
        else{
            throw new IllegalArgumentException("Time slot is invalid");
        }
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

    public void setCredits(int credits){
        this.credits = credits;
    }
    /**
     * Checks whether time slots and semester formats are valid
     * @return validity, true or false
     */
    public static boolean courseIsValid(String timeSlot){
        if(!timeSlot.contains("MWF ")&&!timeSlot.contains("TR ")){
            return false;
        }
        try{
            String[] timeSlotArray = timeSlot.split(" ");
            String[] times = timeSlotArray[1].split("-");
            double time_0 = Double.parseDouble(times[0]);
            double time_1 = Double.parseDouble(times[1]);
            if(time_1<time_0 || time_0<0 || time_1<0 || time_0>=24 || time_1>=24){
                return false;
            }
        }
        catch(Exception error){
            return false;
        }
        
        return true;
    }
}