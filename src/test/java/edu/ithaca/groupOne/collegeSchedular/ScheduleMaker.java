package edu.ithaca.groupOne.collegeSchedular;

import java.util.Scanner;

public class ScheduleMaker {
    public static void main(String[] args){
        Institution.addCourse("34500",new Course(34500, 30, 4, "Computer Science", "Spring", "MWF 11-12"));
        Institution.addCourse("10200",new Course(10200, 30, 4, "Physics", "Spring", "MWF 8-10"));
        Institution.addCourse("11800",new Course(11800, 30, 4, "Physics", "Spring", "MWF 10-12"));
        Institution.addCourse("21800",new Course(21800, 30, 4, "Physics", "Spring", "MWF 10-11"));
        Institution.addCourse("17500",new Course(17500, 30, 4, "Writing", "Spring", "TR 11-12"));
        Institution.addCourse("21100",new Course(21100, 30, 4, "Maths", "Spring", "MWF 9-10"));
        Institution.addCourse("49000",new Course(49000, 30, 4, "Philosophy", "Spring", "MWF 15-16"));
        Institution.addCourse("10500",new Course(10500, 30, 6, "Gender Studies", "Spring", "TR 13-15"));
        Institution.addCourse("31100",new Course(31100, 30, 4, "Psychology", "Spring", "TR 8-9"));
        Institution.addCourse("21700",new Course(21700, 30, 4, "Botany", "Spring", "MWF 19-21"));


        Schedule mySchedule = new Schedule("My Schedule");
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to the schedule maker!");
        System.out.println("Enter 'exit' to print out the schedule.");
        System.out.println("Please input the cID of the course you wish to add to the schedule:");
        System.out.println(Institution.courses);
        String cID = in.next();
        while (!cID.equalsIgnoreCase("EXIT")){
            try{
                mySchedule.addCourse(Institution.getCourse(cID));
            }
            catch(TimeConflictException error){
                System.out.println(error);
            }
            System.out.println("Please input the cID of the course you wish to add to the schedule:");
            cID = in.next();
        }
        //INSERT PRINT SCHEDULE CODE HERE. USE "mySchedule". -MICKY

    }
    
}
