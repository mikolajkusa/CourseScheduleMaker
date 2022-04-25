package edu.ithaca.groupOne.collegeSchedular;

import java.util.Scanner;

public class ScheduleMaker {
    public static void main(String[] args){
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
