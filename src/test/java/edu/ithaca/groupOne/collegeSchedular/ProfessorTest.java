package edu.ithaca.groupOne.collegeSchedular;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class ProfessorTest {

    @Test
    void addDeleteTest() throws CourseIdInUseException{
        Professor prof = new Professor("2002", "password");
        assertEquals(0, prof.getCoursesList().length); //Equivalence case - no courses made by the professor
        prof.createCourse(1, 10, 4, "computer science", "sp2022", "MWF10-1050");
        assertEquals(1, prof.getCoursesList().length); //Equivalence case - something in the courses map
        assertEquals(1, prof.getCourses().size());
        assertThrows(CourseIdInUseException.class, ()->prof.createCourse(1, 100, 3, "physics", "fall2021", "TTH925-1040")); //Equivalence class - course id already in use
        prof.createCourse(50, 100, 3, "physics", "fall2021", "TTH925-1040");
        assertEquals(2, prof.getCoursesList().length); //Equivalence case - have multiple courses in course map
        assertEquals(2, prof.getCourses().size());
        assertThrows(IllegalArgumentException.class, ()->prof.deleteCourse(13)); //Equivalence case - remove a course that does not exist
        assertEquals(2, prof.getCoursesList().length);
        assertEquals(2, prof.getCourses().size());
        prof.deleteCourse(1);
        assertEquals(1, prof.getCoursesList().length); //Equivalence case - removed a course
        assertEquals(1, prof.getCourses().size());
    }

    @Test
    void changeStudentCountTest() throws CourseIdInUseException, IllegalArgumentException{
        Professor prof = new Professor("2002", "password");
        prof.createCourse(1, 10, 4, "computer science", "sp2022", "MWF10-1050");
        assertEquals(10, prof.getCourses().get(1).getMaxStudentCount()); //equivalence case - no change in student count yet
        prof.changeCourseStudentCount(1, 50);
        assertEquals(50, prof.getCourses().get(1).getMaxStudentCount()); //equivalence case - changed to valid number
        assertThrows(IllegalArgumentException.class, ()->prof.changeCourseStudentCount(1, -10)); //equivalence case - change to invalid student amount
        assertEquals(50, prof.getCourses().get(1).getMaxStudentCount());
        prof.changeCourseStudentCount(1, 0); //boundary case - change to allow no students in the course
        assertEquals(0, prof.getCourses().get(1).getMaxStudentCount());
        assertThrows(IllegalArgumentException.class, ()->prof.changeCourseStudentCount(2, 20)); //equivalence case - change student count of course that does not exist
    }

    @Test
    void changeCreditAmountTest() throws CourseIdInUseException, IllegalArgumentException{
        Professor prof = new Professor("2002", "password");
        prof.createCourse(1, 10, 4, "computer science", "sp2022", "MWF10-1050");
        assertEquals(4, prof.getCourses().get(1).getCredits()); //equivalence case - no change in number of credits yet
        prof.changeCreditAmount(1, 3);
        assertEquals(3, prof.getCourses().get(1).getCredits()); //equivalence case - change number of credits to a valid amount
        assertThrows(IllegalArgumentException.class, ()->prof.changeCreditAmount(1, -2)); //equivalence case - change to invalid number of credits
        assertEquals(3, prof.getCourses().get(1).getCredits());
        assertThrows(IllegalArgumentException.class, ()->prof.changeCreditAmount(1, 0)); //boundary case - cannot have a course with zero credits
        assertEquals(3, prof.getCourses().get(1).getCredits());
        assertThrows(IllegalArgumentException.class, ()->prof.changeCreditAmount(2, 4)); //equivalence case - invalid course id
    }
    
}
