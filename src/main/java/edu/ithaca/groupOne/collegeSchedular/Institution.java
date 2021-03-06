package edu.ithaca.groupOne.collegeSchedular;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Institution {
    private static int maxCourseLength = 4;
    private static HashMap<String, Student> students = new HashMap<>();
    private static HashMap<String, Professor> professors = new HashMap<>();
    private static HashMap<String, Admin> admins = new HashMap<>();
    private static CourseLibrary courseLibrary = new CourseLibrary();
    private static ArrayList<String> majors = new ArrayList<>(Arrays.asList
        (
        "Computer Science",
        "English",
        "Philosophy",
        "Screen Writing",
        "Physics",
        "Biology"
        )
    );

    
    /**
     * @param major
     * @return true if Major exist or false if Major does not exist
     */
    public static boolean checkMajor(String major){
        for (String x : majors){
            x = x.toLowerCase();
            if (x.equals(major)){
                return true;
            }
        }
        return false;
    }

    /**
     * @param fID
     * @return Person assosiated with ID
     */
    //should throw exception if person not found
    public static Person getPerson(String fID){
        char type = fID.charAt(0);
        String ID = fID.substring(1);
        if (type == '1'){
            return students.get(ID);
        } else if (type == '2'){
            return professors.get(ID);
        } else {
            return admins.get(ID);
        }
    }

    /**
     * @param cID
     * @return Course assosiated with cID
     */
    //should throw execption if course not found
    public static Course getCourse(int cID){
        return courseLibrary.getCourse(cID);
    }

    /**
     * @param ID
     * @param person
     * @post adds ID(key) and person(value) to either studnets, professors, or admins HashMap
     */
    public static void addPerson(String fID, Person person){
        char type = fID.charAt(0);
        String ID = fID.substring(1);
        if (type == '1'){
            students.put(ID, (Student) person);
        } if (type == '2'){
            professors.put(ID, (Professor) person);
        } else if (type == '3') {
            admins.put(ID, (Admin) person);
        }
    }

    public static void addPerson(Person person){
        String fID = person.getId();
        char type = fID.charAt(0);
        String ID = fID.substring(1);
        if (type == '1'){
            students.put(ID, (Student) person);
        } if (type == '2'){
            professors.put(ID, (Professor) person);
        } else if (type == '3') {
            admins.put(ID, (Admin) person);
        }
    }

    /**
     * Resets the course library
     */
    public static void resetCourseLibrary(){
        courseLibrary = new CourseLibrary();
    }

    public static String genID(int type) throws IllegalArgumentException{
        //assign first digit based on type
        String newID = "";
        if(type == 1){
            newID = "1";
        }
        else if(type == 2){
            newID = "2";
        }
        else if(type == 3){
            newID = "3";
        }

        //throw error if type != 1, 2, or 3
        if(newID.length() < 1){
            throw new IllegalArgumentException("Invalid Person Type");
        }

        Random rand = new Random();

        //loop 5 times
        for(int i = 0; i<5; i++){
            //Add random digit to id
            String digit = "" + (char)('0' + rand.nextInt(0, 10));
            newID = newID + digit;
        }

        return newID;
    }

    public static boolean isIDValid(String ID){
        //6 digits
        if(ID.length() != 6){
            return false;
        }

        //Invalid first digit - must be 1, 2, or 3
        if(ID.charAt(0) > '3' || ID.charAt(0) < '0')
            return false;


        //each digit is numeric
        for(int i = 1; i < 6; i++){
            if(ID.charAt(i) > '9' || ID.charAt(i) < '0'){
                return false;
            }
        }

        //TODO-------------------------
        //is a unique id
        //seems to not work yet lol
        Set<String> allIDs = new HashSet<String>();
            
        for (String k : students.keySet()) {
            allIDs.add(k);
        }
        for (String k : professors.keySet()) {
            allIDs.add(k);
        }
        for (String k : admins.keySet()) {
            allIDs.add(k);
        }

        if (allIDs.contains(ID.substring(1))) {
            return false;
        }


        return true;
    }

    public static int getMaxCourseLength(){
        return maxCourseLength;
    }

    public static CourseLibrary getCourseLibrary(){
        return courseLibrary;
    }
}