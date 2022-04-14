package edu.ithaca.groupOne.collegeSchedular;

public class CourseIdInUseException extends Exception{
    public CourseIdInUseException(String error){
        super(error);
    }
}
