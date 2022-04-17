package edu.ithaca.groupOne.collegeSchedular;

import java.util.ArrayList;

public class Schedule {
    private String name;
    private ArrayList<Course> courses;

    public Schedule(String name){
        this.name = name;
        courses = new ArrayList<Course>();
    }
    /**
     * Adds a course to the schedule
     * @throws TimeConflictException if the new course conflicts with pre-existing course
     */
    public void addCourse(Course course){}
    
    /**Removes a course from the schedule
     * @throws CourseNotFoundException if the course is not in the schedule
     */
    public void removeCourse(Course course){}
    
    /**
     * Returns the name assigned to the schedule
     * @return
     */
    public String getName(){
        return name;
    }
    
    /**
     * Returns a list of courses in the schedule
     * @return
     */
    public ArrayList<Course> getCourses(){
        return courses;
    }

}
