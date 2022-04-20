package edu.ithaca.groupOne.collegeSchedular;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class displaySchedule extends JFrame {  

    private displaySchedule() {
        super("Schedule");
            // width height 
        setSize(580, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void genSchedule(Schedule s) {
        ArrayList<Course> schedule = s.getCourses();
        for (Course c : schedule) {
            String timeSlot = c.getTimeSlot();
            String[] dayNTime = timeSlot.split(" ");
            if (dayNTime[0] == "MWF") {
                if (dayNTime[1] == "9") {

                }
                if (dayNTime[1] == "10") {
                    
                }
                if (dayNTime[1] == "11") {
                    
                }
                if (dayNTime[1] == "12") {
                    
                }
                if (dayNTime[1] == "1") {
                    
                }
                if (dayNTime[1] == "2") {
                    
                }
                if (dayNTime[1] == "3") {
                    
                }
                if (dayNTime[1] == "4") {
                    
                }
                if (dayNTime[1] == "5") {
                    
                }
            }
            if (dayNTime[0] == "TR") {
                if (dayNTime[1] == "9") {

                }
                if (dayNTime[1] == "10") {
                    
                }
                if (dayNTime[1] == "11") {
                    
                }
                if (dayNTime[1] == "12") {
                    
                }
                if (dayNTime[1] == "1") {
                    
                }
                if (dayNTime[1] == "2") {
                    
                }
                if (dayNTime[1] == "3") {
                    
                }
                if (dayNTime[1] == "4") {
                    
                }
                if (dayNTime[1] == "5") {
                    
                }
            }
        }
    }


    private void setTimes() {
        JLabel nine = new JLabel("9:00 AM");
        nine.setBounds(10, 30, 70, 50);
        this.add(nine);
        
        JLabel ten = new JLabel("10:00 AM");
        ten.setBounds(10, 80, 70, 50);
        this.add(ten);
        
        JLabel eleven = new JLabel("11:00 AM");
        eleven.setBounds(10, 130, 70, 50);
        this.add(eleven);
        
        JLabel noon = new JLabel("12:00 PM");
        noon.setBounds(10, 180, 70, 50);
        this.add(noon);
        
        JLabel one = new JLabel("1:00 PM");
        one.setBounds(10, 230, 70, 50);
        this.add(one);
        
        JLabel two = new JLabel("2:00 PM");
        two.setBounds(10, 280, 70, 50);
        this.add(two);
        
        JLabel three = new JLabel("3:00 PM");
        three.setBounds(10, 330, 70, 50);
        this.add(three);
        
        JLabel four = new JLabel("4:00 PM");
        four.setBounds(10, 380, 70, 50);
        this.add(four);
        
        JLabel five = new JLabel("5:00 PM");
        five.setBounds(10, 430, 70, 50);
        this.add(five);
    }

    private void setDays() {
        JLabel mon = new JLabel("Mon");
        mon.setBounds(115, 0, 50, 50);
        this.add(mon);

        JLabel tue = new JLabel("Tue");
        tue.setBounds(215, 0, 50, 50);
        this.add(tue);

        JLabel wed = new JLabel("Wed");
        wed.setBounds(315, 0, 50, 50);
        this.add(wed);
        
        JLabel thur = new JLabel("Thur");
        thur.setBounds(415, 0, 50, 50);
        this.add(thur);

        JLabel fri = new JLabel("Fri");
        fri.setBounds(515, 0, 50, 50);
        this.add(fri);

        JLabel nothing = new JLabel("");
        nothing.setBounds(530, 0, 0, 0);
        this.add(nothing);
    }

    public void paint(Graphics g) {
        super.paint(g);
        setGrid(g);
    }

    //should add lines to make time slots clear
    private void setGrid(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        
        //horizontal 
        g2d.drawLine(0, 65, 580, 65);
        g2d.drawLine(0, 110, 580, 110);
        g2d.drawLine(0, 165, 580, 165);
        g2d.drawLine(0, 210, 580, 210);
        g2d.drawLine(0, 265, 580, 265);
        g2d.drawLine(0, 310, 580, 310);
        g2d.drawLine(0, 365, 580, 365);
        g2d.drawLine(0, 410, 580, 410);
        g2d.drawLine(0, 465, 580, 465);


        //vertical
        g2d.drawLine(80, 0, 80, 550);
        g2d.drawLine(180, 0, 180, 550);
        g2d.drawLine(280, 0, 280, 550);
        g2d.drawLine(380, 0, 380, 550);
        g2d.drawLine(480, 0, 480, 550);
        
        /*

        g2d.drawLine(150, 0, 150, 550);

        g2d.drawLine(250, 0, 250, 550);

        g2d.drawLine(350, 0, 350, 550);

        g2d.drawLine(450, 0, 450, 550);
        */
    }


    private void setShell() {
        this.setTimes();
        this.setDays();   
    }

    public static void main(String[] args) {  
        displaySchedule window = new displaySchedule();
        window.setShell();
    }  
}  