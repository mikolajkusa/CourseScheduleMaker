package edu.ithaca.groupOne.collegeSchedular;

public class displayScheduleTest {
    
    private static void displayScheduleOne() throws TimeConflictException {
        Course phys2 = new Course(10200, 20, 4, "Math", "Spring", "MWF 9-10", "Physics");
        Course calc3 = new Course(21100, 20, 4, "Math", "Spring", "MWF 10-11", "Calc1");
        Course calc4 = new Course(21200, 20, 4, "Math", "Spring", "TR 9-10", "English");
        Course calc5 = new Course(21300, 20, 4, "Math", "Spring", "MWF 11-12", "History");
        Course calc6 = new Course(21300, 20, 4, "Math", "Spring", "TR 3-4", "Art");
        Schedule mySchedule = new Schedule("Mikolaj's Schedule");
        mySchedule.addCourse(phys2);
        mySchedule.addCourse(calc3);
        mySchedule.addCourse(calc4);
        mySchedule.addCourse(calc5);
        mySchedule.addCourse(calc6);
        displaySchedule.genSchedule(mySchedule);
    }

    private static void displayScheduleTwo() throws TimeConflictException {
        Course phys2 = new Course(10200, 20, 4, "Math", "Spring", "TR 2-3", "Art");
        Course calc3 = new Course(21100, 20, 4, "Math", "Spring", "MWF 1-2", "Comp Sci");
        Course calc4 = new Course(21200, 20, 4, "Math", "Spring", "TR 9-10", "Philo");
        Course calc5 = new Course(21300, 20, 4, "Math", "Spring", "MWF 11-12", "Design");
        Course calc6 = new Course(21300, 20, 4, "Math", "Spring", "TR 3-4", "French");
        Schedule mySchedule = new Schedule("Mikolaj's Schedule");
        mySchedule.addCourse(phys2);
        mySchedule.addCourse(calc3);
        mySchedule.addCourse(calc4);
        mySchedule.addCourse(calc5);
        mySchedule.addCourse(calc6);
        displaySchedule.genSchedule(mySchedule);
    }

    public static void main(String[] args) throws TimeConflictException {
        //displayScheduleOne();
        displayScheduleTwo();
        
    }

}
