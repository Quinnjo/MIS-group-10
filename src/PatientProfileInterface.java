

import javax.swing.*;
public class PatientProfileInterface {
    public static void main(String args[]){
       JFrame frame = new JFrame("Patient Profile Interface");
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setSize(1000,1000);
       JButton button = new JButton("Press");
       frame.getContentPane().add(button); // Adds Button to content pane of frame
       frame.setVisible(true);
    }
}

