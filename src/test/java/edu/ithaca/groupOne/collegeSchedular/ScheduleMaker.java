package edu.ithaca.groupOne.collegeSchedular;

import java.util.Scanner;

public class ScheduleMaker {
    public static void main(String[] args){
        CourseLibrary lib = new CourseLibrary();
        lib.addCourse(new Course(34500, 30, 4, "Computer Science", "Spring", "MWF 11-12","COMP345"));
        lib.addCourse(new Course(10200, 30, 4, "Physics", "Spring", "MWF 8-10","PHYS102"));
        lib.addCourse(new Course(11800, 30, 4, "Physics", "Spring", "MWF 10-12","PHYS118"));
        lib.addCourse(new Course(21800, 30, 4, "Physics", "Spring", "MWF 10-11","PHYS218"));
        lib.addCourse(new Course(17500, 30, 4, "Writing", "Spring", "TR 11-12","WRTG175"));
        lib.addCourse(new Course(21100, 30, 4, "Maths", "Spring", "MWF 9-10","MATH211"));
        lib.addCourse(new Course(49000, 30, 4, "Philosophy", "Spring", "MWF 3-4","PHIL490"));
        lib.addCourse(new Course(10500, 30, 6, "Gender Studies", "Spring", "TR 1-3","GS105"));
        lib.addCourse(new Course(31100, 30, 4, "Psychology", "Spring", "TR 8-9","PSYC311"));
        lib.addCourse(new Course(21700, 30, 4, "Botany", "Spring", "MWF 7-9","BOT217"));


        Schedule mySchedule = new Schedule("My Schedule");
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to the schedule maker!");
        System.out.println("Enter 'exit' to print out the schedule.");
        System.out.println("Please input the cID of the course you wish to add to the schedule:");
        System.out.println(lib);
        String cID = in.next();
        while (!cID.equalsIgnoreCase("EXIT")){
            try{
                int id = Integer.parseInt(cID);
                mySchedule.addCourse(lib.getCourse(id));
            }
            catch(TimeConflictException error){
                System.out.println(error);
            }
            
            System.out.println("Please input the cID of the course you wish to add to the schedule:");
            cID = in.next();
        }
        in.close();
        displaySchedule.genSchedule(mySchedule);

    }
    
}
