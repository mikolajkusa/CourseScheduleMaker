package edu.ithaca.groupOne.collegeSchedular;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ProfessorTest {

    @Test
    void addDeleteTest(){
        Professor prof = new Professor("2002", "password");
        assertEquals(0, prof.getCoursesList().length); //Equivalence case - no courses made by the professor
        prof.createCourse(1, 10, 4, "computer science", "sp2022", "MWF10-1050");
        assertEquals(1, prof.getCoursesList().length); //Equivalence case - something in the courses map
        assertEquals(1, prof.getCourses().size());
        prof.deleteCourse(13);
        assertEquals(1, prof.getCoursesList().length); //Equivalence case - remove a course that does not exist
        assertEquals(1, prof.getCourses().size());
        prof.deleteCourse(1);
        assertEquals(0, prof.getCoursesList().length); //Equivalence case - nothing left after removal
        assertEquals(0, prof.getCourses().size());
    }
    
}
