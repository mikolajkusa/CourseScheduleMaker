package edu.ithaca.groupOne.collegeSchedular;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class StudentTest {
    
    @Test
    void createScheduleTest(){

    }

    @Test
    void addCourseToScheduleTest(){

    }

    @Test
    void removeScheduleTest(){

    }

    @Test
    void changeMajorTest(){
        Student student = new Student("computer science", "password");
        assertTrue(student.getMajor().equals("computer science")); //equivalent class - first major set when made student
        student.changeMajor("physics");
        assertTrue(student.getMajor().equals("physics")); //equivalence class - change major to valid major
        student.changeMajor("BiolOGY");
        assertTrue(student.getMajor().equals("biology")); //equivalence class - capitol letters in new major
        assertThrows(IllegalArgumentException.class, ()-> student.changeMajor("asdfhugabb")); //equivalence class - invalid major
    }

    @Test
    void getterTests(){
        Student student = new Student("physics", "password");
        assertTrue(student.getPassword().equals("password"));
        assertTrue(student.getMajor().equals("physics"));
    }
}
