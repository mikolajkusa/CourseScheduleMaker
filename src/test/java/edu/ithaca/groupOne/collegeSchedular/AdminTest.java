package edu.ithaca.groupOne.collegeSchedular;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class AdminTest {
    @Test //integration test
    public void addRemoveStudentTest() throws CourseUnavailableException, StudentMaximumExceededException{
        Admin admin = new Admin("312345","dinosaurz");
        Course comp171 = new Course(17100,20,4,"Computer Science", "Fall","MWF 10-10.50");
        Institution.addCourse("17100", comp171);
        Student al = new Student("123456","Computer Science","ilovecompsci123");
        Institution.addPerson("123456", al);
        //equivalence class adding student to course
        admin.addStudent(al, comp171);
        assertEquals(14, al.getNumCredits());
        assertTrue(al.getClasses().contains(comp171));
        assertTrue(1 == comp171.getStudentCount());
        //equivalence class removing student from course
        admin.removeStudent(al, comp171);
        assertEquals(18, al.getNumCredits());
        assertFalse(al.getClasses().contains(comp171));
        assertTrue(0 == comp171.getStudentCount());
        //insufficient credits border case
        al.setNumCredits(3);
        assertThrows(InsufficientCreditsException.class, ()->admin.addStudent(al, comp171)); 
        //double enrollment border case
        al.setNumCredits(10);
        admin.addStudent(al, comp171);
        assertThrows(AlreadyEnrolledException.class, ()->admin.addStudent(al, comp171));
        admin.removeStudent(al, comp171);
        //enrolling when unavailable 
        comp171.setAvailability(false);
        assertThrows(CourseUnavailableException.class, ()->admin.addStudent(al, comp171));
        comp171.setAvailability(true);
        //enrolling to ful class border case
        
        for(int i = 0; i <20; i++){
            comp171.addStudent();
        }
        assertThrows(StudentMaximumExceededException.class, ()->admin.addStudent(al, comp171));









    }
    
}
