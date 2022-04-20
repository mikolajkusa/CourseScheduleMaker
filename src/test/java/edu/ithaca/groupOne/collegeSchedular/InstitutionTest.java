package edu.ithaca.groupOne.collegeSchedular;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class InstitutionTest {
    
    @Test
    public void addGetPersonTest(){
        Person s = new Student(" ", " ", " ");
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
        Course c = new Course(0, 0, 0, null, null, null);

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
        Institution.addPerson("123456", new Student("asdf", "asdf", "adsf"));
        assertFalse(Institution.isIDValid("123456"));
    }

    @Test
    public void genIDTest(){
        String ID01 = Institution.genID(1); 
        assertTrue(Institution.isIDValid(ID01)); 
        Institution.addPerson(ID01, new Student(" ", " ", " "));
        
        String ID11 = Institution.genID(1); 
        assertTrue(Institution.isIDValid(ID11)); 
        Institution.addPerson(ID11, new Student(" ", " ", " "));
        
        String ID21 = Institution.genID(1); 
        assertTrue(Institution.isIDValid(ID21)); 
        Institution.addPerson(ID21, new Student(" ", " ", " ")); 
        
        String ID31 = Institution.genID(1); 
        assertTrue(Institution.isIDValid(ID31)); 
        Institution.addPerson(ID31, new Student(" ", " ", " ")); 
        
        String ID41 = Institution.genID(1); 
        assertTrue(Institution.isIDValid(ID41)); 
        Institution.addPerson(ID41, new Student(" ", " ", " ")); 
        
        String ID51 = Institution.genID(1); 
        assertTrue(Institution.isIDValid(ID51)); 
        Institution.addPerson(ID51, new Student(" ", " ", " ")); 
        
        String ID61 = Institution.genID(1); 
        assertTrue(Institution.isIDValid(ID61)); 
        Institution.addPerson(ID61, new Student(" ", " ", " ")); 
        
        String ID71 = Institution.genID(1); 
        assertTrue(Institution.isIDValid(ID71)); 
        Institution.addPerson(ID71, new Student(" ", " ", " ")); 
        
        String ID81 = Institution.genID(1); 
        assertTrue(Institution.isIDValid(ID81)); 
        Institution.addPerson(ID81, new Student(" ", " ", " ")); 
        
        String ID91 = Institution.genID(1); 
        assertTrue(Institution.isIDValid(ID91)); 
        Institution.addPerson(ID91, new Student(" ", " ", " ")); 
        String id1 = Institution.genID(1);
        String id2 = Institution.genID(2);
        String id3 = Institution.genID(3);

        //Invalid Person type
        assertThrows(IllegalArgumentException.class, ()-> Institution.genID(0));
        assertThrows(IllegalArgumentException.class, ()-> Institution.genID(4));
        assertThrows(IllegalArgumentException.class, ()-> Institution.genID(-1));
        assertThrows(IllegalArgumentException.class, ()-> Institution.genID(999));

        //6 digit length
        assertEquals(id1.length(), 6);
        assertEquals(id2.length(), 6);
        assertEquals(id3.length(), 6);

        //First digit matches
        assertEquals(id1.charAt(0), '1');
        assertEquals(id2.charAt(0), '2');
        assertEquals(id3.charAt(0), '3');

        //each digit is numeric
        for(int i = 0; i < 6; i++){
            assertTrue(id1.charAt(i) <= '9' && id1.charAt(i) >= '0');
            assertTrue(id2.charAt(i) <= '9' && id2.charAt(i) >= '0');
            assertTrue(id3.charAt(i) <= '9' && id3.charAt(i) >= '0');
        }
        


        String ID02 = Institution.genID(2); 
        assertTrue(Institution.isIDValid(ID02)); 
        Institution.addPerson(ID02, new Professor());

        String ID12 = Institution.genID(2); 
        assertTrue(Institution.isIDValid(ID12)); 
        Institution.addPerson(ID12, new Professor());

        String ID22 = Institution.genID(2); 
        assertTrue(Institution.isIDValid(ID22)); 
        Institution.addPerson(ID22, new Professor());

        String ID32 = Institution.genID(2); 
        assertTrue(Institution.isIDValid(ID32)); 
        Institution.addPerson(ID32, new Professor());

        String ID42 = Institution.genID(2); 
        assertTrue(Institution.isIDValid(ID42)); 
        Institution.addPerson(ID42, new Professor());

        String ID52 = Institution.genID(2); 
        assertTrue(Institution.isIDValid(ID52)); 
        Institution.addPerson(ID52, new Professor());

        String ID62 = Institution.genID(2); 
        assertTrue(Institution.isIDValid(ID62)); 
        Institution.addPerson(ID62, new Professor());

        String ID72 = Institution.genID(2); 
        assertTrue(Institution.isIDValid(ID72)); 
        Institution.addPerson(ID72, new Professor());

        String ID82 = Institution.genID(2); 
        assertTrue(Institution.isIDValid(ID82)); 
        Institution.addPerson(ID82, new Professor());

        String ID92 = Institution.genID(2); 
        assertTrue(Institution.isIDValid(ID92)); 
        Institution.addPerson(ID92, new Professor());
        
    }
}
