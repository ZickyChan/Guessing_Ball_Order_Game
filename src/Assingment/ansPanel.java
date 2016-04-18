/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Assingment;

/**
 *
 * @author Asus N56VZ
 */
import java.awt.*;
import javax.swing.*;

public class ansPanel extends JPanel{
    JLabel b2 = new JLabel(new ImageIcon("blue.png"));   
    public ansPanel(JLabel b){
        add(b2);
        add(b);
        b2.setVisible(false);
    }
    public void setB2(boolean x){
        b2.setVisible(x);
    }
}
