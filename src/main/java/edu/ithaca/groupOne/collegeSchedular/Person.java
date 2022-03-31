package edu.ithaca.groupOne.collegeSchedular;

public abstract class Person {
    int id;
    String password;

    public boolean login(int enteredID, String enteredPassword){
        if(enteredID != id){
            return false;
        }
        else if(enteredPassword.compareTo(password) != 0){
            return false;
        }

        return true;
    }
}
