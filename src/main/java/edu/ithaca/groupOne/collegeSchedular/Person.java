package edu.ithaca.groupOne.collegeSchedular;

public abstract class Person {
    String id;
    String password;

    public boolean login(String enteredID, String enteredPassword){
        if(enteredID.compareTo(id) != 0){
            return false;
        }
        else if(enteredPassword.compareTo(password) != 0){
            return false;
        }

        return true;
    }

    public static boolean isIDValid(String enteredID){
        return true;
    }
}
