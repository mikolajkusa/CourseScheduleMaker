package edu.ithaca.groupOne.collegeSchedular;

public class Student extends Person {

    private String major;
    private String password;
    private Schedule[] schedules; //think about making this something other than an array - map with key as name or something
    private int numCredits;
    
    /**
     * Constructor method - assumes major is already valid, do we want to change this?
     * @param major : String, the major of the student
     * @param password : String, the password for the student login
     */
    public Student(String major, String password){
        this.major = major;
        this.password = password;
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
        newMajor = newMajor.toLowerCase();
        if (Institution.checkMajor(newMajor)){
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
    public Schedule[] getSchedules(){ //maybe not make it an array, think about data types
        return null;
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
    public int getNumCredits(){
        return -1;
    }
}