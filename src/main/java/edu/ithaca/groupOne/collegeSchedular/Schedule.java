package edu.ithaca.groupOne.collegeSchedular;

import java.util.ArrayList;

public class Schedule {
    private String name;
    private ArrayList<Course> courses;

    public Schedule(String name){
        this.name = name;
        courses = new ArrayList<Course>();
    }
    /**
     * Adds a course to the schedule
     * @throws TimeConflictException if the new course conflicts with pre-existing course
     */
    public void addCourse(Course course) throws TimeConflictException{
        String timeSlot = course.getTimeSlot();
        String[] courseSlot = timeSlot.split(" ");
        for(int i = 0; i<courses.size();i++){
            String[] oldCourseTime = courses.get(i).getTimeSlot().split(" ");
            if(courseSlot[0].equals(oldCourseTime[0])){
                String[] newTime = courseSlot[1].split("-");
                String[] oldTime = oldCourseTime[1].split("-");
                if(Double.parseDouble(newTime[0])<Double.parseDouble(oldTime[1]) && Double.parseDouble(newTime[1])>Double.parseDouble(oldTime[0])){
                    throw new TimeConflictException("The time slots overlap; can't add new course to schedule");
                }

            }
            
        }
        courses.add(course);
    }
    
    /**Removes a course from the schedule
     * @throws CourseNotFoundException if the course is not in the schedule
     */
    public void removeCourse(Course course) throws CourseNotFoundException{
        if(!courses.contains(course)){
            throw new CourseNotFoundException("This course is not in the schedule");
        }
        courses.remove(course);
    }
    
    /**
     * Returns the name assigned to the schedule
     * @return
     */
    public String getName(){
        return name;
    }
    
    /**
     * Returns a list of courses in the schedule
     * @return
     */
    public ArrayList<Course> getCourses(){
        return courses;
    }

}
