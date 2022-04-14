package edu.ithaca.groupOne.collegeSchedular;

import javax.swing.*;  
public class test {  
public static void main(String[] args) {  
JFrame f = new JFrame();//creating instance of JFrame  
          
JLabel am9 = new JLabel("9:00 AM");
            //x    y   size
am9.setBounds(10, 0, 100, 50);

JLabel mon = new JLabel("Mon");
mon.setBounds(100, 0, 50, 50);
f.add(mon);
JLabel tue = new JLabel("Tue");
tue.setBounds(200, 0, 50, 50);
f.add(tue);
JLabel wed = new JLabel("Wed");
wed.setBounds(300, 0, 50, 50);
f.add(wed);
JLabel thur = new JLabel("Thur");
thur.setBounds(400, 0, 50, 50);
f.add(thur);
JLabel fri = new JLabel("Fri");
fri.setBounds(500, 0, 50, 50);
f.add(fri);
          
f.setSize(550, 500);//400 width and 500 height  
f.setLayout(null);//using no layout managers  
f.setVisible(true);//making the frame visible  
}  
}  