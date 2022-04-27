package edu.ithaca.groupOne.collegeSchedular;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class Student extends Person {

    private String major;
    private HashMap<String, Schedule> schedules; //think about making this something other than an array - map with key as name or something
    private double numCredits;
    private ArrayList<Course> classes;
    
    /**
     * Constructor method - assumes major is already valid, do we want to change this?
     * @param id : String, the id of the student
     * @param major : String, the major of the student
     * @param password : String, the password for the student login
     */
    public Student(String id, String major, String password){
        this.id = id;
        this.major = major;
        this.password = password;
        numCredits = 18;
        classes = new ArrayList<Course>();
    }

    /**
     * Creates a new schedule and adds it to the student's list of schedules
     * @param name : String, the name of the schedule
     */
    public void createSchedule(String name){

    }

    /**
     * Adds a course to a particular schedule
     * @param scheduleName : String, the name of the schedule to add the course too
     * @param course : Course, the course to add
     */
    public void addCourseToSchedule(String scheduleName, Course course){

    }

    /**
     * Removes a schedule from the student's list of schedules
     * @param name : String, schedule's name to remove
     */
    public void removeSchedule(String name){

    }

    /**
     * Changes the students major
     * @param newMajor : String the new major of the student
     */
    public void changeMajor(String newMajor) throws IllegalArgumentException{
        newMajor = newMajor.toLowerCase(); //always use lower case to make things simple
        if (Institution.checkMajor(newMajor)){ //makes sure major is a valid major
            this.major = newMajor;
        }
        else{
            throw new IllegalArgumentException();
        }
    }

    /**
     * Gets the students current major
     * @return String : the major of the student
     */
    public String getMajor(){
        return major;
    }

    /**
     * Gets the collection of schedules the student has made
     * @return FIGURE OUT DATA TYPE : All the schedules the student has made
     */
    public Schedule[] getSchedules(){ 
        Collection<Schedule> sch = schedules.values();
        Schedule[] s = new Schedule[sch.size()];
        return sch.toArray(s);
    }

    /**
     * Gets the password of the student
     * @return String : the password of the student
     */
    public String getPassword(){
        return password;
    }

    /**
     * Gets the number of credits the student is currently unrolled in
     * @return int : the number of credits the student is currently enrolled in
     */
    public double getNumCredits(){
        return numCredits;
    }

    public void setNumCredits(double numCredits){
        this.numCredits = numCredits;
    }

    public void addCourse(Course course){
        classes.add(course);
    }

    public ArrayList<Course> getClasses(){
        return classes;
    }

}