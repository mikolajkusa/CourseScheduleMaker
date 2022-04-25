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

    public static boolean isTimeConflict(Course c1, Course c2){
        //Initialize variables

        //Start/End times for 7 days of the week, -1 denotes that the class does not meet that day
        //Order: Su-M-Tu-W-Th-F-Sa
        float startTimes1[] = {-1, -1, -1, -1, -1, -1, -1};
        float endTimes2[] = {-1, -1, -1, -1, -1, -1, -1};

        float startTimes2[] = {-1, -1, -1, -1, -1, -1, -1};
        float endTimes1[] = {-1, -1, -1, -1, -1, -1, -1};

        //Parse the timeslots into times and days
        String rawTime1 = c1.getTimeSlot();
        String rawTime2 = c2.getTimeSlot();

        String c1Days = rawTime1.substring(0, rawTime1.indexOf(' '));
        String c2Days = rawTime2.substring(0, rawTime2.indexOf(' '));
        String c1Time = rawTime1.substring(rawTime1.indexOf(' ') + 1);
        String c2Time = rawTime2.substring(rawTime2.indexOf(' ') + 1);

        //Convert times String into a float 
        float c1Start = getTimeFromString(c1Time.substring(0, c1Time.indexOf('-')));
        float c2Start = getTimeFromString(c2Time.substring(0, c2Time.indexOf('-')));
        float c1End = getTimeFromString(c1Time.substring(c1Time.indexOf('-') + 1));
        float c2End = getTimeFromString(c2Time.substring(c2Time.indexOf('-') + 1));

        //Mark times in array for C1
        if(c1Days.contains("M")){
            startTimes1[1] = c1Start;
            endTimes1[1] = c1End;
        }
        else if(c1Days.contains("T")){
            startTimes1[2] = c1Start;
            endTimes1[2] = c1End;
        }
        else if(c1Days.contains("W")){
            startTimes1[3] = c1Start;
            endTimes1[3] = c1End;
        }
        else if(c1Days.contains("R")){
            startTimes1[4] = c1Start;
            endTimes1[4] = c1End;
        }
        else if(c1Days.contains("F")){
            startTimes1[5] = c1Start;
            endTimes1[5] = c1End;
        }
        else if(c1Days.contains("Sa")){
            startTimes1[6] = c1Start;
            endTimes1[6] = c1End;
        }
        else if(c1Days.contains("Su")){
            startTimes1[0] = c1Start;
            endTimes1[0] = c1End;
        }

        //Mark times in array for C2
        if(c2Days.contains("M")){
            startTimes2[1] = c2Start;
            endTimes2[1] = c2End;
        }
        else if(c2Days.contains("Tu")){
            startTimes2[2] = c2Start;
            endTimes2[2] = c2End;
        }
        else if(c2Days.contains("W")){
            startTimes2[3] = c2Start;
            endTimes2[3] = c2End;
        }
        else if(c2Days.contains("Th")){
            startTimes2[4] = c2Start;
            endTimes2[4] = c2End;
        }
        else if(c2Days.contains("F")){
            startTimes2[5] = c2Start;
            endTimes2[5] = c2End;
        }
        else if(c2Days.contains("Sa")){
            startTimes2[6] = c2Start;
            endTimes2[6] = c2End;
        }
        else if(c2Days.contains("Su")){
            startTimes2[0] = c2Start;
            endTimes2[0] = c2End;
        }


        //Finally compare the times on each day
        for(int i = 0; i<7; i++){
            float startTime1 = startTimes1[i];
            float startTime2 = startTimes2[i];
            float endTime1 = endTimes1[i];
            float endTime2 = endTimes2[i];

            //If both have a meeting time on this day
            if(startTime1!= -1 && startTime2 != -1){
                //If C1 starts before C2 and ends when or after C2 starts
                if(startTime1 < startTime2 && endTime1 > startTime2){
                    return true;
                }

                //If C2 starts before C1 and ends when or after C1 starts
                if(startTime2 < startTime1 && endTime2 > startTime1){
                    return true;
                }

                //If C1 and C2 have same start time or same end time
                if(startTime1 == startTime2 || endTime1 == endTime2){
                    return true;
                }

            }
        }

        return false;
    }

    private static float getTimeFromString(String time){
        //NOTE: Right now only handles even hour increments
        //Class can only be scheduled from 7am - 6pm

        float hour = 0;
        if(time.length() > 1){
            hour = 10 + (time.charAt(1) - ' ');
        }
        else if(time.length() == 1){
            hour = (time.charAt(0) - ' ');
            
            if(hour <= 6){
                //must be a pm class
                hour += 12;
            }

        }
        else{
            throw new IllegalArgumentException("Empty String with length 0");
        }

        return hour;
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
