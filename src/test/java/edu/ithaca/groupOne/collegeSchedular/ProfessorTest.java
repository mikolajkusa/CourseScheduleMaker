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
    
}
