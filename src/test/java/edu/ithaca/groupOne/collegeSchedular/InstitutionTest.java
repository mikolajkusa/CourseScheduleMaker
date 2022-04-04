package edu.ithaca.groupOne.collegeSchedular;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class InstitutionTest {
    
    @Test
    public void addGetPersonTest(){
        Person s = new Student("computer science", "password");
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
        
    }

    @Test
    public void genIDTest(){

    }
}
