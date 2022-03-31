package edu.ithaca.groupOne.collegeSchedular;

public class Student {

    private String major;
    private String password;
    private int id;
    private Schedule[] schedules; //think about making this something other than an array - map with key as name or something
    
    /**
     * Constructor method
     * @param id : int, the id of the student
     * @param major : String, the major of the student
     * @param password : String, the password for the student login
     */
    public Student(int id, String major, String password){

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
    public void changeMajor(String newMajor){

    }

    /**
     * Gets the students current major
     * @return String : the major of the student
     */
    public String getMajor(){
        return null;
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
        return null;
    }

    /**
     * Gets the id of the student
     * @return int : the id of the student
     */
    public int getId(){
        return -1;
    }
}