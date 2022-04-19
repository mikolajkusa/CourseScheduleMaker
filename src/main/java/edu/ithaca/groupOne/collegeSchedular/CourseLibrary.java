package edu.ithaca.groupOne.collegeSchedular;

import java.util.ArrayList;

public class CourseLibrary {
    private ArrayList<Course> courses;

    /**
     * Constructor for thew CourseLibrary
     * Creates an empty ArrayList for the courses
     */
    public CourseLibrary(){
        courses = new ArrayList<Course>();
    }

    /**
     * Returns the ArrayList for courses
     * @return the ArrayList of courses
     */
    public ArrayList<Course> getCourses(){
        return courses;
    }


    /**
     * Adds a course to the courses ArrayList, if it is a valid course
     * @param course - the course to be added if it is valid
     * @throws IllegalArgumentException if the course being added is invalid or a duplicate
     * @post - the course is added to the list, or the list remians the same if the course is not valid
     */
    public void addCourse(Course course){

        //checks if valid course
        if(!Course.isCourseValid(course)){
            throw new IllegalArgumentException("Not a valid course");
        }

        //check if course already exists
        if(courses.contains(course)){
            throw new IllegalArgumentException("Course already exists");
        }

        for (Course c : courses) {
            if(c.getCourseID() == course.getCourseID()){
                throw new IllegalArgumentException("Course with that ID already exists");
            }
        }        

        //add course to list
        courses.add(course);
    }

    /**
     * Removes a course from the courses ArrayList
     * @param courseID - the id of the course being removed
     * @throws IllegalArgumentException - if the course id does not exist in the courses ArrayList
     * @post - the course with the given id is removed, or the ArrayList remains the same if not found
     */
    public void removeCourse(int courseID){
        boolean found = false;
        for(int i = 0; i < courses.size(); i++){

            if(courses.get(i).getCourseID() == courseID){
                courses.remove(i);
                i+= courses.size() + 1;
                found = true;
            }

        }

        if(!found){
            throw new IllegalArgumentException("Course not found");
        }
    }
}
