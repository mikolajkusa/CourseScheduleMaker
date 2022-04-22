package edu.ithaca.groupOne.collegeSchedular;


public class SprintDemo1 {
    
    public static void main(String[] args) {
        //Login demo
        Student student = new Student("123456", "Computer Science", "password");
        System.out.println("Student created. ID number: 123456, Major: Computer Science, Password: password");
        System.out.println("Login in attempt with ID: 123456 and Password: wordpass");

        if(student.login("123456", "wordpass"))
            System.out.println("Login successful");
        else
            System.out.println("Login failed");

        System.out.println("Login in attempt with ID: 123456 and Password: password");

        if(student.login("123456", "password"))
            System.out.println("Login successful");
        else
            System.out.println("Login failed");

        
        //Institution class demo
        Institution institution = new Institution();

        //Show class diagram

        //Show sequence diagram

        //Change major
        System.out.println();
        System.out.println("Current student major: " + student.getMajor());
        
        System.out.println("Changing major to Biology");
        student.changeMajor("Biology");

        System.out.println("Student major now: " + student.getMajor());

        //Course library demo
        System.out.println();
        System.out.println("Retrieving course with ID: 6");
        try {
            Institution.getCourse("6");
            System.out.println("Course found");
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println("Course not found");
        }

        System.out.println("Adding course with ID: 6");
        Course course = new Course(6, 10, 4, "Biology", "Spring", "async");
        Institution.addCourse("6", course);

        System.out.println("Retrieving course with ID: 6");
        try {
            Institution.getCourse("6");
            System.out.println("Course found");
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println("Course not found");
        }

        //Student and Abstract Person demo
        //Student created earlier with major

    }
}
