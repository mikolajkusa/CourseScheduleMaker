package edu.ithaca.groupOne.collegeSchedular;

public class Admin extends Person{

    
    
    public Admin(String id, String password){
        this.id = id;
        this.password = password;
    }

    /**
     * Removes a student from a course.
     * @param student
     * @param course
     */
    public void removeStudent(Student student, Course course) throws CourseUnavailableException, CourseEmptyException{
        course.removeStudent();
        student.getClasses().remove(course);
        student.setNumCredits(student.getNumCredits()+course.getCredits());
        
    }

    /**
     * Adds a new student to a course
     * @param student
     * @param course
     */
    public void addStudent(Student student, Course course) throws StudentMaximumExceededException, CourseUnavailableException, AlreadyEnrolledException, InsufficientCreditsException{
        if(student.getNumCredits()<course.getCredits()){
            throw new InsufficientCreditsException("Student does not have enough credits");

        }
        if(student.getClasses().contains(course)){
            throw new AlreadyEnrolledException("Student is already enrolled in this course!");

        }
        course.addStudent();
        student.setNumCredits(student.getNumCredits()-course.getCredits());
        student.addCourse(course);

    }
    
}
