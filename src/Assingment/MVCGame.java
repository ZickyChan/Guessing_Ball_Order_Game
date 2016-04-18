/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Assingment;

import javax.swing.*;
import java.io.*;

/**
 * @author Asus N56VZ
 */
public class MVCGame {
    public static void main(String[] args) throws IOException{
        GameView gv = new GameView();
        GameModel gm = new GameModel();
        GameController gc = new GameController(gv,gm);     
        
    }
}