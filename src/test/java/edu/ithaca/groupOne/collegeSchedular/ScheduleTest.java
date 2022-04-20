package edu.ithaca.groupOne.collegeSchedular;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class ScheduleTest {
    @Test
    public void addRemoveScheduleTest() throws TimeConflictException, CourseNotFoundException{
        Course phys2 = new Course(10200, 20, 4, "Physics", "Spring", "MWF 8-10");
        Course calc3 = new Course(21100, 20, 4, "Math", "Spring", "MWF 9-10");
        Course calc4 = new Course(21200, 20, 4, "Math", "Spring", "TR 8-10");
        Course calc5 = new Course(21300, 20, 4, "Math", "Spring", "MWF 10-12");
        Course calc6 = new Course(21300, 20, 4, "Math", "Spring", "MWF 8-9");
        Schedule mySchedule = new Schedule("Mikolaj's Schedule");
        
        //add-remove course in empty schedule (border case) 
        mySchedule.addCourse(phys2);
        assertTrue(mySchedule.getCourses().contains(phys2));
        mySchedule.removeCourse(phys2);
        assertFalse(mySchedule.getCourses().contains(phys2));

        //removing course not in schedule equivalence class
        assertThrows(CourseNotFoundException.class, ()->mySchedule.removeCourse(phys2));
        assertThrows(CourseNotFoundException.class, ()->mySchedule.removeCourse(calc3));
        
        //adding time conflicting courses
        mySchedule.addCourse(calc3);
        assertThrows(TimeConflictException.class, ()->mySchedule.addCourse(phys2));
        mySchedule.addCourse(calc4);
        mySchedule.addCourse(calc5);//border case, adding classes with adjacent time slots
        mySchedule.addCourse(calc6);
    }
    
}
