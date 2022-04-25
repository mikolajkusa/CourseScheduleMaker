package edu.ithaca.groupOne.collegeSchedular;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;



import org.junit.jupiter.api.Test;

public class CourseTest {

@Test
public void addRemoveStudentTest() throws CourseUnavailableException, StudentMaximumExceededException, CourseEmptyException{
    //border case, can't add student to unavailable course
    Course testCourse = new Course(10200, 20, 4, "Physics", "Spring", "MWF 8-10");
    testCourse.setAvailability(false);
    assertThrows(CourseUnavailableException.class, ()->testCourse.addStudent());
    
    //Adding student to available course, equivalence class
    testCourse.setAvailability(true);
    for(int i = 0; i< 20; i++){
        testCourse.addStudent();
        assertEquals(i+1, testCourse.getStudentCount()); //student count increments accordingly
    }

    //border case, can't add student when max count is achieved
    assertThrows(StudentMaximumExceededException.class, ()->testCourse.addStudent());

    //border case, setting availability to false resets student count
    testCourse.setAvailability(false);
    assertEquals(0, testCourse.getStudentCount());

    //equivalence class, removing students from class
    testCourse.setAvailability(true);
    for(int i = 0; i< 20; i++){
        testCourse.addStudent();
        assertEquals(i+1, testCourse.getStudentCount()); //student count increments accordingly
    }
    for(int i = 20; i> 0; i--){
        testCourse.removeStudent();
        assertEquals(i-1, testCourse.getStudentCount()); //student count decreases accordingly
    }
    assertThrows(CourseEmptyException.class, ()->testCourse.removeStudent());  

    //border case, removing from unavailable course
    testCourse.setAvailability(false);
    assertThrows(CourseUnavailableException.class, ()->testCourse.removeStudent()); 
}
@Test
public void courseIsValidTest(){
    assertThrows(IllegalArgumentException.class, ()->new Course(10500, 20, 4, "Physics", "Spring", "TT 8-10"));
    assertThrows(IllegalArgumentException.class, ()->new Course(10500, 20, 4, "Physics", "Spring", "MW 8-10"));
    assertThrows(IllegalArgumentException.class, ()->new Course(10500, 20, 4, "Physics", "Spring", "MF 8-10"));

    assertThrows(IllegalArgumentException.class, ()->new Course(10500, 20, 4, "Physics", "Spring", "TR 8:10"));

    assertThrows(IllegalArgumentException.class, ()->new Course(10500, 20, 4, "Physics", "Spring", "MWF 8 10"));

    assertThrows(IllegalArgumentException.class, ()->new Course(10500, 20, 4, "Physics", "Spring", "TR asbds"));

    assertThrows(IllegalArgumentException.class, ()->new Course(10500, 20, 4, "Physics", "Spring", "MWF 8.10"));
}

    
}
