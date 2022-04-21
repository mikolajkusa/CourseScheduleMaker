package edu.ithaca.groupOne.collegeSchedular;

public class InsufficientCreditsException extends Exception {
    public InsufficientCreditsException(String error){
        super(error);
    }

}
