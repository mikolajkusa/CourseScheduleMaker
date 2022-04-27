package edu.ithaca.groupOne.collegeSchedular;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.xml.validation.SchemaFactoryConfigurationError;

import org.junit.jupiter.api.Test;

public class ScheduleTest {
    @Test
    public void addRemoveScheduleTest() throws TimeConflictException, CourseNotFoundException{
        Course phys2 = new Course(10200, 20, 4, "Physics", "Spring", "MWF 8-10");
        Course calc3 = new Course(21100, 20, 4, "Math", "Spring", "MWF 9-10");
        //Course calc4 = new Course(21200, 20, 4, "Math", "Spring", "TR 8-10");
        Course calc4 = new Course(21200, 20, 4, "Math", "Spring", "TuTh 8-10"); //Trav - changed the Tues-Thurs format
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
    
    @Test
    void isTimeConflictTest(){
        Course conflict1 = new Course(10200, 20, 4, "Physics", "sp2020", "MWF 8-10");
        Course conflict2 = new Course(10300, 20, 4, "Physics", "sp2020", "MWF 8-10");
        Course conflict3 = new Course(10400, 20, 4, "Physics", "sp2020", "MWF 9-11");

        Course c1 = new Course(21100, 20, 4, "Math", "sp2020", "MWF 10-11");
        Course c2 = new Course(21200, 20, 4, "Biology", "sp2020", "MWF 2-4");
        Course c3 = new Course(31400, 20, 3, "Computer Science", "sp2020", "TuTh 10-11");
        Course c4 = new Course(31500, 20, 3, "Computer Science", "sp2020", "TuTh 11-12");
        Course c5 = new Course(31600, 20, 3, "Computer Science", "sp2020", "TuTh 4-6");
        Course c6 = new Course(11400, 20, 3, "Computer Science", "sp2020", "TuTh 7-9");

        //Same day, same time - conflict
        assertTrue(Schedule.isTimeConflict(conflict1, conflict2)); //exact same time slot
        assertTrue(Schedule.isTimeConflict(conflict1, conflict3)); //1 hour overlap
        assertTrue(Schedule.isTimeConflict(conflict2, conflict3)); //1 hour overlap
        assertTrue(Schedule.isTimeConflict(c1, c1)); //same course

        //Same day, different time - no conflict
        assertFalse(Schedule.isTimeConflict(conflict1, c1)); //adjacent times
        assertFalse(Schedule.isTimeConflict(conflict1, c2));

        //Different day, same time - no conflict
        assertFalse(Schedule.isTimeConflict(c1, c3)); //same time
        assertFalse(Schedule.isTimeConflict(c1, c4));//adjacent times

        //Different day, different time - no conflict
        assertFalse(Schedule.isTimeConflict(c2, c3));
        assertFalse(Schedule.isTimeConflict(c2, c5)); //adjacent times
        assertFalse(Schedule.isTimeConflict(c2, c6));
    }
}
