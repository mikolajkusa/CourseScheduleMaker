package edu.ithaca.groupOne.collegeSchedular;

public abstract class Person {
   protected String id;
    protected String password;

    /**
     * Returns whether or not the entered id and password match the objects id and password
     * @param enteredID - the entered id number
     * @param enteredPassword - the entered password
     * @return true if the entered id and password the Person's exactly, false otherwise
     */
    public boolean login(String enteredID, String enteredPassword){
        if(enteredID.compareTo(id) != 0){
            return false;
        }
        else if(enteredPassword.compareTo(password) != 0){
            return false;
        }

        return true;
    }

    /**
     * Checks and returns whether or not the given string is a valid id number
     * Rules: must be a numeric, 6 digit id number. The first digit must 1, 2, or 3
     * @param enteredID - the string be checked
     * @return - true if enteredID is a valid id, false otherwise
     */
    public static boolean isIDValid(String enteredID){
        //Check if id is 6 digits
        if(enteredID.length() != 6){
            return false;
        }

        //Check if first digit is 1, 2, or 3
        if(enteredID.charAt(0) != '1' && enteredID.charAt(0) != '2' && enteredID.charAt(0) != '3'){
            return false;
        }

        //Check if each digit is numeric
        for(int i = 0; i < enteredID.length(); i++){
            if(enteredID.charAt(i) > '9' || enteredID.charAt(i) < '0'){
                return false;
            }
        }

        return true;
    }
}
