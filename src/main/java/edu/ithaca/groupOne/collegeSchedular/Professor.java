package edu.ithaca.groupOne.collegeSchedular;

import java.util.Map;
import java.util.TreeMap;

public class Professor extends Person{
    private Map<Integer, Course> courses; //will use a tree map for the implementation

    /**
     * Constructor for the professor
     * @param id - String, the id of the professor
     * @param password - String password, the password for the professor login
     */
    public Professor(String id, String password){
        this.id = id;
        this.password = password;
        courses = new TreeMap<>();
    }

    public Professor() {
        this.id = "1234";
        this.password = "password";
    }

    /**
     * Delete the course from the courses map
     * @param courseId - the id of the course to delete
     * @throws IllegalArgumentException
     */
    public void deleteCourse(Integer courseId) throws IllegalArgumentException{
        if (courses.containsKey(courseId)){
            courses.remove(courseId);
            Institution.getCourseLibrary().removeCourse(courseId);
        }
        else{
            throw new IllegalArgumentException();
        }
    }

    /**
     * Creates a course and adds it to the courses map
     * @param courseID - int, the id of the course
     * @param maxStudentCount - int the max student count of the course
     * @param credits - double, the number of credits the course is
     * @param major - String, the major the course is for
     * @param semester - String, the semester the course is offered
     * @param timeSlot - String, the time that the course is offered at
     * @throws CourseIdInUseException
     * @throws IllegalArgumentException
     */
    public void createCourse(int courseID, int maxStudentCount, double credits, String major, String semester, String timeSlot) throws CourseIdInUseException, IllegalArgumentException{
        if (!isSemesterValid(semester)){
            throw new IllegalArgumentException("Invalid semester");
        }
        if (!isTimeValid(timeSlot)){
            throw new IllegalArgumentException("Invalid time slot");
        }
        Course newCourse = new Course(courseID, maxStudentCount, credits, major, semester, timeSlot);
        if (courses.putIfAbsent(courseID, newCourse) != null){
            throw new CourseIdInUseException("This courseID is already in use.");
        }
        else{
            Institution.getCourseLibrary().addCourse(newCourse);
        }
    }

    /**
     * Gets an array of all the courses the professor teaches
     * @return array, all the courses the progessor teaches
     */
    public Course[] getCoursesList(){
        return courses.values().toArray(new Course[0]);
    }

    /**
     * Gets the map that all of the courses are stored in
     * @return a map based off of course id's
     */
    public Map<Integer, Course> getCourses(){
        return courses;
    }

    /**
     * Changes the max student count for a given course
     * @param courseId - int, the id of the course
     * @param newStudentCount - int, the new student count of the course
     * @throws IllegalArgumentException
     */
    public void changeCourseStudentCount(int courseId, int newStudentCount) throws IllegalArgumentException{
        Course course = courses.get(courseId);
        if (course == null){
            throw new IllegalArgumentException("Invalid course ID");
        }
        if (newStudentCount < 0){
            throw new IllegalArgumentException("Invalid student count");
        }
        course.setMaxStudentCount(newStudentCount);
    }

    /**
     * Changes the number of credits a given course is
     * @param courseId - int, the id of the course
     * @param newCredits - double, the amount of credits to change the course to
     * @throws IllegalArgumentException
     */
    public void changeCreditAmount(int courseId, double newCredits) throws IllegalArgumentException{
        Course course = courses.get(courseId);
        if (course == null){
            throw new IllegalArgumentException("Invalid course ID");
        }
        if (newCredits <= 0.0){
            throw new IllegalArgumentException("Invalid number of credits");
        }
        course.setCredits(newCredits);
    }

    /**
     * Changes the semester the course is offered
     * @param courseID - int, the id of the course
     * @param newSemester - String, the new semester to offer the course
     * @throws IllegalArgumentException
     */
    public void changeCourseSemester(int courseID, String newSemester) throws IllegalArgumentException{
        Course course = courses.get(courseID);
        newSemester = newSemester.toLowerCase();
        if (course == null){
            throw new IllegalArgumentException("Invalid course ID");
        }
        if (!isSemesterValid(newSemester)){
            throw new IllegalArgumentException("Invalid new semester");
        }
        course.setSemester(newSemester);
    }

    /**
     * Changes the time at which the course is offered
     * @param courseID - int, the id of the course
     * @param newTime - String, the new time the course will be at
     * @throws IllegalArgumentException
     */
    public void changeCourseTime(int courseID, String newTime) throws IllegalArgumentException{
        Course course = courses.get(courseID);
        if (course == null){
            throw new IllegalArgumentException("Invalid course ID");
        }
        if (!isTimeValid(newTime)){
            throw new IllegalArgumentException("Invalid new time");
        }
        course.setTimeSlot(newTime);
    }

    /**
     * Changes the course name
     * @param courseID - int, the id of the course
     * @param newName - String, the new name of the course
     */
    public void changeCourseName(int courseID, String newName){
        Course course = courses.get(courseID);
        if (course == null){
            throw new IllegalArgumentException("Invalid course ID");
        }
        course.setName(newName);
    }

    /**
     * Determines if a new semester is a valid semester
     * @param semester - String, the new semester to check
     * @return boolean, true if the semester is valid, false if otherwise
     */
    private boolean isSemesterValid(String semester){
        if (semester.length() < 2){
            return false;
        }
        String season = semester.substring(0, 2);
        String year = semester.substring(2);
        if (!season.equals("fa") && !season.equals("sp") && !season.equals("su") && !season.equals("wi")){
            return false; //checks the season
        }
        try{ //check the year
            int intYear = Integer.parseInt(year);
            if (intYear < 0){
                return false;
            }
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    /**
     * Determines if a time is a valid course time
     * @param time - String, the time to check
     * @return boolean, if the time is valid returns true, false otherwise
     */
    private boolean isTimeValid(String time){
        if (time.length() < 7){ //minimum length of the time string
            return false;
        }
        int timeIdx = time.indexOf(" ") + 1; //get starting index of the starting time
        if (timeIdx == 0){ //if the staring index is not found
            return false;
        }
        String days = time.substring(0, timeIdx - 1); //get the days
        days = days.toLowerCase();
        String validChars = "mwfthusa";
        for (int i = 0; i < timeIdx - 1; i++){
            if(!validChars.contains(days.substring(i,i+1))){ //make sure the days are valid
                return false;
            }
        }
        int timeSplit = time.indexOf("-"); //split times up into starting and ending times
        if (timeSplit == -1){ //if no where to split the time up
            return false;
        }
        String startTime = time.substring(timeIdx, timeSplit); //get starting and ending times
        String endTime = time.substring(timeSplit + 1);
        try{
            int timeStart = Integer.parseInt(startTime); //make sure they are both integers
            int timeEnd = Integer.parseInt(endTime);
            if (timeStart > 12 || timeStart < 1){ //make sure they are in between 1 and 12
                return false;
            }
            if (timeEnd > 12 || timeEnd < 1){
                return false;
            }
            if (timeStart < 7 && timeEnd > 6){ //check to make sure that time intervals are between 7am and 6pm
                return false;
            }
            if (timeStart > timeEnd){
                int t = timeStart + Institution.getMaxCourseLength(); //check for wrap around from 12-1 or similar
                if (t > 12){
                    t = t - 12;
                    if (timeEnd > t){
                        return false;
                    }
                }
            }
            if (timeEnd - timeStart > Institution.getMaxCourseLength()){ //make sure not too long
                return false;
            }
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

}
