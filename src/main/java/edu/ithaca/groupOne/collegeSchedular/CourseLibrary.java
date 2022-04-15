package edu.ithaca.groupOne.collegeSchedular;

import java.util.ArrayList;

public class CourseLibrary {
    private ArrayList<Course> courses;

    public CourseLibrary(){
        courses = new ArrayList<Course>();
    }

    public ArrayList<Course> getCourses(){
        return courses;
    }

    public void addCourse(Course course){

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

        //check if course is valid
        

        //add course to list
        courses.add(course);
    }

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
