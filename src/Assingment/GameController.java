package Assingment;


import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.lang.*;
import java.awt.event.*;
import static java.awt.image.ImageObserver.WIDTH;
import java.util.HashSet;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class GameController {
    protected GameView gv;
    protected GameModel gm;
    Timer timer;
    int gameMode;
    public GameController(GameView gv, GameModel gm) throws IOException{
        this.gv = gv;
        this.gm = gm;
        this.gv.addNewGame(new NewGame());
        this.gv.addExit(new ExitListener());
        this.gv.addAccept(new Accept());
        this.gv.addMouse(new MouseChoose());
        this.gv.addGiveUp(new GiveUp());
        this.gv.setIcon(new chooseIcon());
        this.gv.timer.setVisible(false);
        this.gm.readFile();
        this.gv.setScore(this.gm.showScore());
        gameMode = JOptionPane.showOptionDialog(null, "Choose game mode: \n Freeplay or Time trial (3 minutes)" , "Choose game mode", 
                            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, 
                            null, new Object[]{"Freeplay", "Time trial"}, "Freeplay");
        if (gameMode == 1) {
            TimeClass tc = new TimeClass(180);  //300 seconds
            timer = new Timer(1000, tc);    //each 1000 milliseconds - 1 second, ActionListener tc triggered once
            timer.start();
            (gv.timer).setVisible(true);
        }
    }
     class ExitListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            System.exit(WIDTH); 
        }
    }
    
    class GiveUp implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(gameMode == 1)
                timer.stop();
            gv.getAnswer(gm.result);
            gv.giveUp.setVisible(true);
            gv.freeze();
        }
    }
     
    class NewGame implements ActionListener {
        public void actionPerformed(ActionEvent e){
           if(gameMode == 1)
                timer.stop();   //stop if new game is chosen from button, other wise the current timer still running
            newGame();
        }
    }
    class Accept implements ActionListener{
        public void actionPerformed(ActionEvent e){
            int right = 0;
            int incode = 0;
            HashSet<String> set2 = new HashSet<String>();
            for(int i=0;i<gv.ball.length;i++){
                System.out.println(gv.ball[i].getName());
            }
            for(int i=0;(i<gv.ball.length);i++){
                if(gv.ball[i].getName()!= null){
                    System.out.println(""+i);
                    System.out.println(gv.ball[i].getName());
                    set2.add(gv.ball[i].getName());
                }
            }
            System.out.println(set2);
            for(int i =0;i<gm.result.length;i++){
                if(gm.result[i].equals(gv.ball[i].getName())){
                    right++;
                }
                if(set2.contains(gm.result[i])){
                    incode++;
                }
            }

            gv.move++;
            int ind = gv.move%6;
            gv.addRing(gv.ans,ind);
            gv.mv.setText("Number of moves: " + gv.move);
            for(int i =0; i<gv.resultBall.length;i++){
                gv.resultBall[i].setIcon(gv.circleImg);
            }
            for (int i = 0; i<incode;i++){
                gv.resultBall[i].setIcon(gv.white);
            }
            for (int i = 0; i<right;i++){
                gv.resultBall[i].setIcon(gv.black);
            }

            if (right == 6){
                gv.win.setVisible(true);
                if (gameMode == 1)
                    timer.stop();
                
                gv.noRing(gv.ans);
                gm.score = gm.calculateScore(gv.move);
                JPanel mess = new JPanel(new GridLayout(2,1,0,0));
                JLabel message= new JLabel("Your score is: " + gm.score);
                JLabel ask = new JLabel("Do you want to save your score?");
                message.setFont(gv.medium);
                ask.setFont(gv.medium);
                mess.add(message);
                mess.add(ask);     
                int value = JOptionPane.showOptionDialog(null, mess, "Congratulation!!", 
                            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, 
                            null, new Object[]{"Yes", "No"}, "Yes");
                if (value==0){
                    String player = JOptionPane.showInputDialog("Please type your name: ");
                    String score = String.valueOf(gm.score);
                    String[] m = {player,score};
                    gm.all.add(m);
                    try {
                        gm.writeFile(gm.all);
                    } catch (IOException ex) {
                        Logger.getLogger(GameController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    gv.setScore(gm.showScore());
                    gv.freeze();
                }
                else if(value == 1){
                    JLabel request = new JLabel("Do you want to restart new game");
                    int option = JOptionPane.showOptionDialog(null, request, "Congratulation!!", 
                            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, 
                            null, new Object[]{"Yes", "No"}, "Yes");
                    if(option==0){
                        newGame();
                    }
                    else{
                        gv.freeze();
                    }
                }
                else{
                    gv.freeze();
                }
             }
             
        }
    }
    
    class MouseChoose implements MouseListener {
        public void mouseEntered(MouseEvent m) {
            ((JComponent)m.getSource()).setBackground(Color.WHITE);
        }
        public void mouseExited(MouseEvent m) {
        }
        @Override
        public void mouseClicked(MouseEvent m) {   
            Component j = m.getComponent();
            JButton l = (JButton)j;
            String name = l.getName();
            Icon i = l.getIcon();
            ImageIcon a = (ImageIcon) i;      
            if(gv.move%6 == 0){                
                gv.ball[0].setIcon(a);
                gv.ball[0].setName(name);
                System.out.println(gv.ball[0].getName());
            }
            else if(gv.move%6 == 1){
                gv.ball[1].setIcon(a);
                gv.ball[1].setName(name);
                System.out.println(gv.ball[1].getName());
            }
            else if(gv.move%6 == 2){
                gv.ball[2].setIcon(a);
                gv.ball[2].setName(name);
                System.out.println(gv.ball[2].getName());
            }
            else if(gv.move%6 == 3){
                gv.ball[3].setIcon(a);
                gv.ball[3].setName(name);
                System.out.println(gv.ball[3].getName());
            }
            else if(gv.move%6 == 4){
                gv.ball[4].setIcon(a);
                gv.ball[4].setName(name);
                System.out.println(gv.ball[4].getName());
            }
            else{
                gv.ball[5].setIcon(a);
                gv.ball[5].setName(name);
                System.out.println(gv.ball[5].getName());
            }
        }
        public void mousePressed(MouseEvent m) {            
        }
        public void mouseReleased(MouseEvent m) {    
        }  
    }
    class chooseIcon implements MouseListener{
        public void mouseEntered(MouseEvent m){}
        public void mouseExited(MouseEvent m){}
        public void mouseClicked(MouseEvent m){
            JLabel label = (JLabel) m.getComponent();
            String name = label.getName();
            int index = Integer.parseInt(name);
            gv.setButton(index);
        }
        public void mousePressed(MouseEvent m){}
        public void mouseReleased(MouseEvent m){}
    }
    public void newGame(){
        gm = new GameModel();
        try {gm.readFile();}
            catch (Exception ex){
            System.out.println(ex.getMessage());
            }
        gv.timer.setVisible(false);
        gv.newGame();
        gameMode = JOptionPane.showOptionDialog(null, "Choose game mode: \n Freeplay or Time trial (3 minutes)" , "Choose game mode", 
                            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, 
                            null, new Object[]{"Freeplay", "Time trial"}, "Freeplay");
        if (gameMode == 1) {
            TimeClass tc = new TimeClass(180);  //180 seconds
            timer = new Timer(1000, tc);    //each 1000 milliseconds - 1 second, ActionListener tc triggered once
            timer.start();
            gv.timer.setVisible(true);
        }
    }
    public class TimeClass implements ActionListener {
        int count;
        public TimeClass(int counter){
            count = counter;
        }
        public void actionPerformed(ActionEvent tc){
            count--;
            if(count >= 1){
                (gv.timer).setText("Time left: " + count + " seconds");
            }
            else{
                timer.stop();
                (gv.timer).setText("Time is over!");
                int value = JOptionPane.showConfirmDialog(null, "Sorry, time is over \n Click OK to retry or Cancel to view the answer", "Time Over", 2, JOptionPane.INFORMATION_MESSAGE);
                switch(value){
                    case 0: newGame();
                            break;
                        
                    case 2: gv.getAnswer(gm.result);
                            gv.giveUp.setVisible(true);
                            gv.freeze();
                }
            }
        }
    }
}
