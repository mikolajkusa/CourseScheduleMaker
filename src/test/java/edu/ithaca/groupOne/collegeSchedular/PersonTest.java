package edu.ithaca.groupOne.collegeSchedular;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class PersonTest {
    @Test
    void loginTest(){
        Student s = new Student("1000", "bugatti25");

        //both match
        assertTrue(s.login("1000", "bugatti25"));

        //id number wrong
        assertFalse(s.login("1001", "bugatti25"));
        assertFalse(s.login("01000", "bugatti25")); //leading zeros
        assertFalse(s.login("000001000", "bugatti25")); //leading zeros

        //password wrong
        assertFalse(s.login("1000", "bugatti26")); // one off
        assertFalse(s.login("1000", "bugatti25 ")); // one off - space at the end
        assertFalse(s.login("1000", " bugatti25")); // one off - space in the beginning


        //both wrong
        s.login("1", "what"); // way off

    }

    @Test
    void isIDValidTest(){
        //Valid ID
        assertTrue(Person.isIDValid("123456"));
        assertTrue(Person.isIDValid("123456"));

        //Wrong amount of digits
        assertFalse(Person.isIDValid(""));
        assertFalse(Person.isIDValid("12345"));
        assertFalse(Person.isIDValid("1234567"));
        assertFalse(Person.isIDValid("11111111111111"));
        assertFalse(Person.isIDValid("123"));


        //First digit is not 1, 2, or 3
        assertFalse(Person.isIDValid("400000"));
        assertFalse(Person.isIDValid("012345"));


        //Non numeric digits
        assertFalse(Person.isIDValid("#123456"));
        assertFalse(Person.isIDValid("#12345"));

        assertFalse(Person.isIDValid(" 12345"));
        assertFalse(Person.isIDValid(" 123456"));

        assertFalse(Person.isIDValid("12345-"));
        assertFalse(Person.isIDValid("12345#"));
        
        assertFalse(Person.isIDValid(" 12_345"));
        assertFalse(Person.isIDValid(" 123%56"));

    }
}
