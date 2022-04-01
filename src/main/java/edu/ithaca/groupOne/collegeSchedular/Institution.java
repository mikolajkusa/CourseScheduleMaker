package edu.ithaca.groupOne.collegeSchedular;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;

public class Institution {
    private HashMap<Integer, Student> students = new HashMap<>();
    private HashMap<Integer, Professor> professors = new HashMap<>();
    private HashMap<Integer, Admin> admins = new HashMap<>();
    private HashMap<Integer, Course> courses = new HashMap<>();
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
     * @param ID
     * @return Person assosiated with ID
     */
    public Person getPerson(int ID){
        int type = ID;
        while (type > 9) {
            type /= 10;
        }
        if (type == 1){
            return students.get(ID);
        } else if (type == 2){
            return professors.get(ID);
        } else {
            return admins.get(ID);
        }
    }

    /**
     * @param cID
     * @return Course assosiated with cID
     */
    public Course getCourse(int cID){
        return courses.get(cID);
    }

    /**
     * @param ID
     * @param person
     * @post adds ID(key) and person(value) to either studnets, professors, or admins HashMap
     */
    public void addPerson(int ID, Person person){
        int type = ID;
        while (type > 9){
            type /= 10;
        }
        if (type == 1){
            students.put(ID, person);
        } else if (type == 2){
            professors.put(ID, person);
        } else {
            admins.put(ID, person);
        }
    }

    /**
     * @param cID
     * @param course
     * @post adds cID(key) and course(value) to course HashMap
     */
    public void addCourse(int cID, Course course){
        courses.put(cID, course);
    }

    public Collection getStudents(){

    }
}