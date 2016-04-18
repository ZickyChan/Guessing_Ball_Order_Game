package Assingment;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author David
 */
import java.awt.*;
import javax.swing.*;
public class codePanel extends JPanel{
    public codePanel(JPanel p1, JPanel p2){
        add(p1);
        add(p2);
        p1.setVisible(false);
        p2.setVisible(false);
    }
    
    public void setP1(JPanel p1, boolean x){
        p1.setVisible(x);
    }
    
    public void setP2(JPanel p2, boolean x) {
        p2.setVisible(x);
    }
}
