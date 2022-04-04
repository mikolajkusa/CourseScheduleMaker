package edu.ithaca.groupOne.collegeSchedular;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Institution {
    private HashMap<String, Student> students = new HashMap<>();
    private HashMap<String, Professor> professors = new HashMap<>();
    private HashMap<String, Admin> admins = new HashMap<>();
    private HashMap<String, Course> courses = new HashMap<>();
    private ArrayList<String> majors = new ArrayList<>(Arrays.asList
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
    public boolean checkMajor(String major){
        for (String x : majors){
            if (x == major){
                return true;
            }
        }
        return false;
    }

    /**
     * @param fID
     * @return Person assosiated with ID
     */
    public Person getPerson(String fID){
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
    public Course getCourse(String cID){
        return courses.get(cID);
    }

    /**
     * @param ID
     * @param person
     * @post adds ID(key) and person(value) to either studnets, professors, or admins HashMap
     */
    public void addPerson(String fID, Person person){
        char type = fID.charAt(0);
        String ID = fID.substring(1);
        if (type == '1'){
            students.put(ID, (Student) person);
        } if (type == '2'){
            professors.put(ID, (Professor) person);
        } else {
            admins.put(ID, (Admin) person);
        }
    }

    /**
     * @param cID
     * @param course
     * @post adds cID(key) and course(value) to course HashMap
     */
    public void addCourse(String cID, Course course){
        courses.put(cID, course);
    }

    public static String genID(int type){
        return null;
    }

    public static boolean isIDValid(String ID){
        return false;
    }
}