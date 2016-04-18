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
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;


class RoundButton extends JButton {
  public RoundButton(ImageIcon img) {
        setHorizontalTextPosition(SwingConstants.CENTER);            
        setOpaque(false);
        setIcon(img);
        setContentAreaFilled(false);        
        setForeground(Color.BLACK);
        setSize(52,52);
        setFocusPainted(false);        
        setBorderPainted(false);
        setBorder(new LineBorder(Color.BLUE,2));
        
  }
 
  }



