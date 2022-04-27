package edu.ithaca.groupOne.collegeSchedular;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class StudentTest {
    
    @Test
    void createScheduleTest(){
        Student trav = new Student("704123", "Computer Science", "SicParvisMagna");
        
        //Student starts with 0 schedules
        assertTrue(trav.getSchedules().length == 0);

        //Creates 1 schedule
        trav.createSchedule("Fall classes");
        assertTrue(trav.getSchedules().length == 1);

        //Creates 1 more schedule, total now is 2
        trav.createSchedule("Spring classes");
        assertTrue(trav.getSchedules().length == 2);

        //Schedule with empty name field, not allowed
        assertThrows(IllegalArgumentException.class, () -> trav.createSchedule(""));
        assertTrue(trav.getSchedules().length == 2);

        //Schedule with same name field as another, not allowed
        assertThrows(IllegalArgumentException.class, () -> trav.createSchedule("Spring classes"));
        assertTrue(trav.getSchedules().length == 2);
    }

    @Test
    void addCourseToScheduleTest(){
        
    }

    @Test
    void removeScheduleTest(){
        Student trav = new Student("704123", "Computer Science", "SicParvisMagna");
        
        //Student starts with 0 schedules
        assertTrue(trav.getSchedules().length == 0);

        //Creates 2 schedules
        trav.createSchedule("Spring classes");
        trav.createSchedule("Fall classes");
        assertTrue(trav.getSchedules().length == 2);

        //remove 1 schedule
        trav.removeSchedule("Spring classes");
        assertTrue(trav.getSchedules().length == 1); //removed a schedule
        assertTrue(trav.getSchedules()[0].getName() == "Fall classes"); //removed the right schedule

        //Attempt to remove a schedule that does not exist
        assertThrows(IllegalArgumentException.class, () -> trav.removeSchedule("F1")); 
        assertThrows(IllegalArgumentException.class, () -> trav.removeSchedule("Fall classe")); //off by one char
        assertThrows(IllegalArgumentException.class, () -> trav.removeSchedule("Fall classes ")); //off by one char
        assertTrue(trav.getSchedules().length == 1); //did not remove a schedule
    }

    @Test
    void changeMajorTest(){
        Student student = new Student("10111", "computer science", "password");
        assertTrue(student.getMajor().equals("computer science")); //equivalent class - first major set when made student
        student.changeMajor("physics");
        assertTrue(student.getMajor().equals("physics")); //equivalence class - change major to valid major
        student.changeMajor("BiolOGY");
        assertTrue(student.getMajor().equals("biology")); //equivalence class - capitol letters in new major
        assertThrows(IllegalArgumentException.class, ()-> student.changeMajor("asdfhugabb")); //equivalence class - invalid major
    }

    @Test
    void getterTests(){
        Student student = new Student("101101", "physics", "password");
        assertTrue(student.getPassword().equals("password"));
        assertTrue(student.getMajor().equals("physics"));
        assertTrue(student.getId().equals("101101"));
    }
}
