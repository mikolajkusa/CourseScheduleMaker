package edu.ithaca.groupOne.collegeSchedular;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

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

    /**
     * Resets the course library
     */
    public static void resetCourseLibrary(){
        courseLibrary = new CourseLibrary();
    }

    public static String genID(int type){
        return null;
    }

    public static boolean isIDValid(String ID){
        return false;
    }

    public static int getMaxCourseLength(){
        return maxCourseLength;
    }

    public static CourseLibrary getCourseLibrary(){
        return courseLibrary;
    }
}