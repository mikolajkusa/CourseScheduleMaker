package edu.ithaca.groupOne.collegeSchedular;

import java.util.Map;

public class Professor extends Person{
    private Map<Integer, Course> courses; //think about what data type this should be

    /**
     * Constructor for the professor
     * @param id - String, the id of the professor
     * @param password - String password, the password for the professor login
     */
    public Professor(String id, String password){
        
    }

    /**
     * Delete the course from the courses map
     * @param courseId - the id of the course to delete
     */
    public void deleteCourse(Integer courseId){

    }

    /**
     * Creates a course and adds it to the courses map
     * @param courseID - int, the id of the course
     * @param maxStudentCount - int the max student count of the course
     * @param credits - double, the number of credits the course is
     * @param major - String, the major the course is for
     * @param semester - String, the semester the course is offered
     * @param timeSlot - String, the time that the course is offered at
     */
    public void createCourse(int courseID, int maxStudentCount, double credits, String major, String semester, String timeSlot){

    }

    /**
     * Gets an array of all the courses the professor teaches
     * @return array, all the courses the progessor teaches
     */
    public Course[] getCoursesList(){
        return null;
    }

    /**
     * Gets the map that all of the courses are stored in
     * @return a map based off of course id's
     */
    public Map<Integer, Course> getCourses(){
        return null;
    }


}
