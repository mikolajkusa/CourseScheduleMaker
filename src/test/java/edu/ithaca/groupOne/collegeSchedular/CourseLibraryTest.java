package edu.ithaca.groupOne.collegeSchedular;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class CourseLibraryTest {
    
    @Test
    void constructorTest(){
        CourseLibrary lib = new CourseLibrary();
        assertTrue(lib.getCourses() != null);
    }

    @Test
    void addCourseTest(){

        CourseLibrary lib = new CourseLibrary();

        //adds regular courses successfully
        for(int i = 0; i < 100; i++){
            lib.addCourse(new Course(i, i+10, 3, "Computer Science", "Spring", "Async"));
        }

        assertTrue(lib.getCourses().size() == 100);

        //adding a duplicate course
        assertThrows(IllegalArgumentException.class, () -> lib.addCourse(new Course(0, 10, 3, "Computer Science", "Spring", "Async")));
        assertThrows(IllegalArgumentException.class, () -> lib.addCourse(new Course(50, 10, 3, "Computer Science", "Spring", "Async")));
        assertThrows(IllegalArgumentException.class, () -> lib.addCourse(new Course(99, 10, 3, "Computer Science", "Spring", "Async")));

        //adding a null course
        assertThrows(IllegalArgumentException.class, () -> lib.addCourse(null));

    }

    @Test
    void removeCourseTest(){
        CourseLibrary lib = new CourseLibrary();

        //adds regular courses successfully
        for(int i = 0; i < 10; i++){
            lib.addCourse(new Course(i, i+10, 3, "Computer Science", "Spring", "Async"));
        }

        lib.removeCourse(2);
        
        //removes a course that exists
        assertTrue(lib.getCourses().size() == 9);

        //remove course that does not exist
        assertThrows(CourseUnavailableException.class, () -> lib.removeCourse(-1));
        assertThrows(CourseUnavailableException.class, () -> lib.removeCourse(2));
        assertThrows(CourseUnavailableException.class, () -> lib.removeCourse(11));

        

    }
}
