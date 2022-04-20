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

    /**
     * Delete the course from the courses map
     * @param courseId - the id of the course to delete
     * @throws IllegalArgumentException
     */
    public void deleteCourse(Integer courseId) throws IllegalArgumentException{
        if (courses.containsKey(courseId)){
            courses.remove(courseId);
        }
        else{
            throw new IllegalArgumentException();
        }
        //NEED TO REMOVE COURSE FROM THE COURSE LIBRARY
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
        //NEED TO ADD COURSE TO THE COURSE LIBRARY
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
        if (time.length() < 7){
            return false;
        }
        int timeIdx = time.indexOf(" ") + 1;
        if (timeIdx == 0){
            return false;
        }
        String days = time.substring(0, timeIdx - 1);
        days = days.toLowerCase();
        String validChars = "mwfthusa";
        for (int i = 0; i < timeIdx - 1; i++){
            if(!validChars.contains(days.substring(i,i+1))){
                return false;
            }
        }
        int timeSplit = time.indexOf("-");
        if (timeSplit == -1){
            return false;
        }
        String startTime = time.substring(timeIdx, timeSplit);
        String endTime = time.substring(timeSplit + 1);
        try{
            int timeStart = Integer.parseInt(startTime);
            int timeEnd = Integer.parseInt(endTime);
            if (timeStart > 12 || timeStart < 1){
                return false;
            }
            if (timeEnd > 12 || timeEnd < 1){
                return false;
            }
            if (timeStart > timeEnd){
                int t = timeStart + Institution.getMaxCourseLength();
                if (t > 12){
                    t = t - 12;
                    if (timeEnd > t){
                        return false;
                    }
                }
            }
            if (timeEnd - timeStart > Institution.getMaxCourseLength()){
                return false;
            }
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

}
