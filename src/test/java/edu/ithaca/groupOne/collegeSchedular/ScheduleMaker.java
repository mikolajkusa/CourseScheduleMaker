package edu.ithaca.groupOne.collegeSchedular;

import java.util.Scanner;

public class ScheduleMaker {
    public static void main(String[] args){
        Institution.getCourseLibrary().addCourse(new Course(34500, 30, 4, "Computer Science", "Spring", "MWF 11-12"));
        Institution.getCourseLibrary().addCourse(new Course(10200, 30, 4, "Physics", "Spring", "MWF 8-10"));
        Institution.getCourseLibrary().addCourse(new Course(11800, 30, 4, "Physics", "Spring", "MWF 10-12"));
        Institution.getCourseLibrary().addCourse(new Course(21800, 30, 4, "Physics", "Spring", "MWF 10-11"));
        Institution.getCourseLibrary().addCourse(new Course(17500, 30, 4, "Writing", "Spring", "TR 11-12"));
        Institution.getCourseLibrary().addCourse(new Course(21100, 30, 4, "Maths", "Spring", "MWF 9-10"));
        Institution.getCourseLibrary().addCourse(new Course(49000, 30, 4, "Philosophy", "Spring", "MWF 15-16"));
        Institution.getCourseLibrary().addCourse(new Course(10500, 30, 6, "Gender Studies", "Spring", "TR 13-15"));
        Institution.getCourseLibrary().addCourse(new Course(31100, 30, 4, "Psychology", "Spring", "TR 8-9"));
        Institution.getCourseLibrary().addCourse(new Course(21700, 30, 4, "Botany", "Spring", "MWF 19-21"));


        Schedule mySchedule = new Schedule("My Schedule");
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to the schedule maker!");
        System.out.println("Enter 'exit' to print out the schedule.");
        System.out.println("Please input the cID of the course you wish to add to the schedule:");
        System.out.println(Institution.getCourseLibrary());
        String cID = in.next();
        while (!cID.equalsIgnoreCase("EXIT")){
            try{
                int id = Integer.parseInt(cID);
                mySchedule.addCourse(Institution.getCourseLibrary().getCourse(id));
            }
            catch(TimeConflictException error){
                System.out.println(error);
            }
            System.out.println("Please input the cID of the course you wish to add to the schedule:");
            cID = in.next();
        }
        in.close();
        //INSERT PRINT SCHEDULE CODE HERE. USE "mySchedule". -MICKY

    }
    
}
