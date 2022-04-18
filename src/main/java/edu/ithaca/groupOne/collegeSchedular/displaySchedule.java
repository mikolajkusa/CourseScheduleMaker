package edu.ithaca.groupOne.collegeSchedular;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
 
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class displaySchedule extends JFrame {  

    private displaySchedule() {
        super("Schedule");
            // width height 
        setSize(550, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void genSchedule(Schedule s) {

    }


    private void setTimes() {
        JLabel nine = new JLabel("9:00 AM");
        nine.setBounds(10, 10, 100, 50);
        this.add(nine);
        
        JLabel ten = new JLabel("10:00 AM");
        ten.setBounds(10, 60, 100, 50);
        this.add(ten);
        
        JLabel eleven = new JLabel("11:00 AM");
        eleven.setBounds(10, 110, 100, 50);
        this.add(eleven);
        
        JLabel noon = new JLabel("12:00 PM");
        noon.setBounds(10, 160, 100, 50);
        this.add(noon);
        
        JLabel one = new JLabel("1:00 PM");
        one.setBounds(10, 210, 100, 50);
        this.add(one);
        
        JLabel two = new JLabel("2:00 PM");
        two.setBounds(10, 260, 100, 50);
        this.add(two);
        
        JLabel three = new JLabel("3:00 PM");
        three.setBounds(10, 310, 100, 50);
        this.add(three);
        
        JLabel four = new JLabel("4:00 PM");
        four.setBounds(10, 360, 100, 50);
        this.add(four);
        
        JLabel five = new JLabel("5:00 PM");
        five.setBounds(10, 410, 100, 50);
        this.add(five);
    }

    private void setDays() {
        JLabel mon = new JLabel("Mon");
        mon.setBounds(100, 0, 50, 50);
        this.add(mon);

        JLabel tue = new JLabel("Tue");
        tue.setBounds(200, 0, 50, 50);
        this.add(tue);

        JLabel wed = new JLabel("Wed");
        wed.setBounds(300, 0, 50, 50);
        this.add(wed);
        
        JLabel thur = new JLabel("Thur");
        thur.setBounds(400, 0, 50, 50);
        this.add(thur);

        JLabel fri = new JLabel("Fri");
        fri.setBounds(500, 0, 50, 50);
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
         
        float[] dashingPattern1 = {2f, 2f};
        Stroke stroke1 = new BasicStroke(2f, BasicStroke.CAP_BUTT,
        BasicStroke.JOIN_MITER, 1.0f, dashingPattern1, 2.0f);
 
        g2d.setStroke();
        
        g2d.drawLine(120, 50, 360, 50);
        g2d.drawLine(100, 0, 100, 550);
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