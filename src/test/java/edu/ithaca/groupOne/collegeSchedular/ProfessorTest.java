package edu.ithaca.groupOne.collegeSchedular;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class ProfessorTest {

    @Test
    void addDeleteTest() throws CourseIdInUseException, IllegalArgumentException{
        Professor prof = new Professor("2002", "password");
        assertEquals(0, Institution.getCourseLibrary().getCourses().size()); //equivalence case - nothing added to course library
        assertEquals(0, prof.getCoursesList().length); //Equivalence case - no courses made by the professor
        prof.createCourse(1, 10, 4, "computer science", "sp2022", "MWF 10-11");
        assertEquals(1, prof.getCoursesList().length); //Equivalence case - something in the courses map
        assertEquals(1, prof.getCourses().size());
        assertEquals(1, Institution.getCourseLibrary().getCourses().size()); //course library updated as well
        assertThrows(CourseIdInUseException.class, ()->prof.createCourse(1, 100, 3, "physics", "fa2021", "TTH 9-10")); //Equivalence class - course id already in use
        prof.createCourse(50, 100, 3, "physics", "fa2021", "TTH 9-10");
        assertEquals(2, prof.getCoursesList().length); //Equivalence case - have multiple courses in course map
        assertEquals(2, prof.getCourses().size());
        assertEquals(2, Institution.getCourseLibrary().getCourses().size());
        assertThrows(IllegalArgumentException.class, ()->prof.deleteCourse(13)); //Equivalence case - remove a course that does not exist
        assertEquals(2, prof.getCoursesList().length);
        assertEquals(2, prof.getCourses().size());
        prof.deleteCourse(1);
        assertEquals(1, prof.getCoursesList().length); //Equivalence case - removed a course
        assertEquals(1, prof.getCourses().size());
        assertEquals(1, Institution.getCourseLibrary().getCourses().size());
        assertThrows(IllegalArgumentException.class, ()->prof.createCourse(2, 10, 4, "computer science", "sf2022", "MWF 10-11")); //makes sure semester is tested during course creation
        changeSemesterTest(); //more tests for making sure new semster is valid
        assertThrows(IllegalArgumentException.class, ()->prof.createCourse(2, 10, 4, "computer science", "sp2022", "asg")); //make sure time is tested during course creation
        changeTimeTest(); //more tests for making sure new time is valid
    }

    @Test
    void changeStudentCountTest() throws CourseIdInUseException, IllegalArgumentException{
        Professor prof = new Professor("2002", "password");
        prof.createCourse(1, 10, 4, "computer science", "sp2022", "MWF 10-11");
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
        prof.createCourse(1, 10, 4, "computer science", "sp2022", "MWF 10-11");
        assertEquals(4, prof.getCourses().get(1).getCredits()); //equivalence case - no change in number of credits yet
        prof.changeCreditAmount(1, 3);
        assertEquals(3, prof.getCourses().get(1).getCredits()); //equivalence case - change number of credits to a valid amount
        assertThrows(IllegalArgumentException.class, ()->prof.changeCreditAmount(1, -2)); //equivalence case - change to invalid number of credits
        assertEquals(3, prof.getCourses().get(1).getCredits());
        assertThrows(IllegalArgumentException.class, ()->prof.changeCreditAmount(1, 0)); //boundary case - cannot have a course with zero credits
        assertEquals(3, prof.getCourses().get(1).getCredits());
        assertThrows(IllegalArgumentException.class, ()->prof.changeCreditAmount(2, 4)); //equivalence case - invalid course id
    }

    @Test
    void changeSemesterTest() throws CourseIdInUseException, IllegalArgumentException{
        Professor prof = new Professor("2002", "password");
        prof.createCourse(1, 10, 4, "computer science", "sp2022", "MWF 10-11");
        assertEquals("sp2022", prof.getCourses().get(1).getSemester()); //equivalance case - no change in semester yet
        assertThrows(IllegalArgumentException.class, ()-> prof.changeCourseSemester(2, "sp2022")); //equivalence case - invalid course id
        prof.changeCourseSemester(1, "fa2022");
        assertEquals("fa2022", prof.getCourses().get(1).getSemester()); //equivalence case - valid new semester
        assertThrows(IllegalArgumentException.class, ()->prof.changeCourseSemester(1, "")); //equivalence case - invalid new semester
        assertThrows(IllegalArgumentException.class, ()->prof.changeCourseSemester(1, "bfhdaf"));
        assertThrows(IllegalArgumentException.class, ()->prof.changeCourseSemester(1, "fp2021"));
        prof.changeCourseSemester(1, "wi2022"); //equivalence case - winter semester
        assertEquals("wi2022", prof.getCourses().get(1).getSemester());
        prof.changeCourseSemester(1, "su2022"); //equivalence case - summer semester
        assertEquals("su2022", prof.getCourses().get(1).getSemester());
        prof.changeCourseSemester(1, "Su2022");
        assertEquals("su2022", prof.getCourses().get(1).getSemester()); //equivalence case - ignore case
        assertThrows(IllegalArgumentException.class, ()->prof.changeCourseSemester(1, "fa20a10")); //equivalence class - year is invalid
        assertThrows(IllegalArgumentException.class, ()->prof.changeCourseSemester(1, "fa2021.9")); //equivalence class - year is a floating point number
        assertThrows(IllegalArgumentException.class, ()->prof.changeCourseSemester(1, "fa-2021")); //equivalance case - year is negative
        //do we want to allow any possible year between 0 and infinity?
    }

    @Test
    void changeTimeTest() throws CourseIdInUseException, IllegalArgumentException{
        Professor prof = new Professor("2002", "password");
        prof.createCourse(1, 10, 4, "computer science", "sp2022", "MWF 10-11");
        assertEquals("MWF 10-11", prof.getCourses().get(1).getTimeSlot()); //equivalance case - no change in time yet
        assertThrows(IllegalArgumentException.class, ()-> prof.changeCourseTime(2, "MWF 11-12")); //equivalence case - invalid course id
        prof.changeCourseTime(1, "MWF 11-12");
        assertEquals("MWF 11-12", prof.getCourses().get(1).getTimeSlot()); //equivalence case - valid new time
        assertThrows(IllegalArgumentException.class, ()-> prof.changeCourseTime(1, "")); //equivalence case - invalid new time
        assertThrows(IllegalArgumentException.class, ()-> prof.changeCourseTime(1, "gbjesbgl")); 
        assertThrows(IllegalArgumentException.class, ()-> prof.changeCourseTime(1, "MWF10-11")); //no space
        assertThrows(IllegalArgumentException.class, ()-> prof.changeCourseTime(1, "MWF 1011")); //no -
        //it was decided that times will only be on the hour
        assertThrows(IllegalArgumentException.class, ()-> prof.changeCourseTime(1, "MWF 10a-11")); //invalid times
        assertThrows(IllegalArgumentException.class, ()-> prof.changeCourseTime(1, "MWF 10.5-11"));
        assertThrows(IllegalArgumentException.class, ()-> prof.changeCourseTime(1, "MWF 10-11:30"));
        assertThrows(IllegalArgumentException.class, ()-> prof.changeCourseTime(1, "TTH 10-8")); //cannot have a course go backwards in time
        assertThrows(IllegalArgumentException.class, ()-> prof.changeCourseTime(1, "MWF 12-14")); //cannot have a course time above 12
        assertThrows(IllegalArgumentException.class, ()-> prof.changeCourseTime(1, "MWF 0-1")); //cannot have a zero course time
        assertThrows(IllegalArgumentException.class, ()-> prof.changeCourseTime(1, "MWF -1-1")); //cannot have a negative course time
        assertThrows(IllegalArgumentException.class, ()-> prof.changeCourseTime(1, "fewf 20-14")); //everything invalid
        assertThrows(IllegalArgumentException.class, ()-> prof.changeCourseTime(1, "MWF 2-7")); //course length too long
    }
    
}
