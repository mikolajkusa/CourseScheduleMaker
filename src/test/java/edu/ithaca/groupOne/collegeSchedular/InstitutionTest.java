package edu.ithaca.groupOne.collegeSchedular;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class InstitutionTest {
    
    @Test
    public void addGetPersonTest(){
        Person s = new Student();
        Person p = new Professor();
        Person a = new Admin();

        Institution.addPerson("123456", s);
        Institution.addPerson("223456", p);
        Institution.addPerson("323456", a);

        assertEquals(s, Institution.getPerson("123456"));
        assertEquals(p, Institution.getPerson("223456"));
        assertEquals(a, Institution.getPerson("323456"));
    }

    @Test
    public void addGetCourseTest(){
        Course c = new Course();

        Institution.addCourse("COMP345", c);

        assertEquals(c, Institution.getCourse("COMP345"));
    }

    @Test
    public void isIDValidTest(){

        //valid student ID
        assertTrue(Institution.isIDValid("123456"));
        //valid professor ID
        assertTrue(Institution.isIDValid("223456"));
        //valid admin ID
        assertTrue(Institution.isIDValid("323456"));

        //invalid identifier
        assertFalse(Institution.isIDValid("423456"));
        //too short
        assertFalse(Institution.isIDValid("12345"));
        //too long
        assertFalse(Institution.isIDValid("1234567"));
        //contains non-number char
        assertFalse(Institution.isIDValid("123d56"));
        assertFalse(Institution.isIDValid("1-3456"));
        assertFalse(Institution.isIDValid("1234\\56"));
        //identifier is non-number char
        assertFalse(Institution.isIDValid("a23456"));
        assertFalse(Institution.isIDValid("*23456"));
        assertFalse(Institution.isIDValid("\\23456"));
        //ID already exists
        Institution.addPerson("123456", new Student());
        assertFalse(Institution.isIDValid("123456"));
    }

    @Test
    public void genIDTest(){

    }
}
