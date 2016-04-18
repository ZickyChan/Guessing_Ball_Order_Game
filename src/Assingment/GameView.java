package Assingment;


import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.*;
import java.lang.*;
import java.awt.event.*;

public class GameView extends JFrame{
    int move = 0;
    //Create JPanel
    protected JPanel p1 = new JPanel();
    protected JPanel p2 = new JPanel();
    protected JPanel p3 = new JPanel();
    protected JPanel p4 = new JPanel();
    protected JPanel p5 = new JPanel();
    protected JPanel p6 = new JPanel();
    protected JPanel p7 = new JPanel();
    protected JPanel cenP1 = new JPanel();
    protected JPanel leftP1 = new JPanel(new GridLayout(1,3));
    protected JPanel rightP1 = new JPanel(new GridLayout(1,3,10,0));
    protected JPanel acc = new JPanel();
    protected JPanel count = new JPanel();
    protected JPanel bottom = new JPanel(new GridLayout(2,1,0,30));
    protected JPanel right = new JPanel(new BorderLayout());
    protected JPanel win = new JPanel(new GridLayout(3,1));
    protected JPanel giveUp = new JPanel();
    protected codePanel winGive = new codePanel(win, giveUp);
    protected JPanel p2s = new JPanel();
    protected JPanel cenP1s = new JPanel();
    protected JPanel p3s = new JPanel();
    protected JPanel giveUpPanel = new JPanel();
    protected JPanel option = new JPanel(new FlowLayout(FlowLayout.LEFT,100,40));
    protected JPanel whiteKey = new JPanel(new FlowLayout(FlowLayout.LEFT,30,10));
    protected JPanel blackKey = new JPanel(new FlowLayout(FlowLayout.LEFT,30,10));
    
    //Create JPanel for storing score and code key
    protected JPanel codeKey = new JPanel(new GridBagLayout());
    protected JPanel scorePanel = new JPanel(new GridBagLayout());
    protected JPanel instruc = new JPanel(new GridBagLayout());
    
    //Create GridBagConstraint
    GridBagConstraints c = new GridBagConstraints();

    
    //Create ImageIcon
    protected ImageIcon circleImg = new ImageIcon("circle.png");
    protected ImageIcon[][] ballBt ={{new ImageIcon("ball.png"),
                                    new ImageIcon("ball2.png"),
                                    new ImageIcon("ball3.png"),
                                    new ImageIcon("ball4.png"),
                                    new ImageIcon("ball5.png"),
                                    new ImageIcon("ball6.png"),
                                    new ImageIcon("ball7.png"),
                                    new ImageIcon("ball8.png")},
                                    {new ImageIcon("bird.png"),
                                    new ImageIcon("bird2.png"),
                                    new ImageIcon("bird3.png"),
                                    new ImageIcon("bird4.png"),
                                    new ImageIcon("bird5.png"),
                                    new ImageIcon("bird6.png"),
                                    new ImageIcon("bird7.png"),
                                    new ImageIcon("bird8.png")},
                                    {new ImageIcon("star.png"),
                                    new ImageIcon("star2.png"),
                                    new ImageIcon("star3.png"),
                                    new ImageIcon("star4.png"),
                                    new ImageIcon("star5.png"),
                                    new ImageIcon("star6.png"),
                                    new ImageIcon("star7.png"),
                                    new ImageIcon("star8.png")}};
    protected ImageIcon white = new ImageIcon("white.png");
    protected ImageIcon black = new ImageIcon("black.png");
    
    //Create JLabel
    protected JLabel mv = new JLabel("Number of moves: " + move);
    protected JLabel timer = new JLabel("Time left: 3 minutes");
    protected JLabel winMess = new JLabel("     Code");
    protected JLabel winMess2 = new JLabel("   has been");
    protected JLabel winMess3 = new JLabel("   broken!!!");
    protected JLabel ring = new JLabel(new ImageIcon("blue.png"));
    protected JLabel askOp = new JLabel("Choose your icon");
    protected JLabel op1 = new JLabel(new ImageIcon("ball.png"));
    protected JLabel op2 = new JLabel(new ImageIcon("bird.png"));
    protected JLabel op3 = new JLabel(new ImageIcon("star.png"));
    
    //Create two dimension JLabel array
    protected JLabel[][] store = new JLabel[10][2];

    
    //Create JButton
    protected JButton accept = new JButton("Accept");
    protected JButton nGame = new JButton("New Game");
    protected JButton exit = new JButton("Quit Game");
    protected JButton giveUpBt = new JButton("I give up");
    
    
    //Create RoundButton
    RoundButton[] button = new RoundButton[8];
    
    
    
    protected JLabel[] ball = {new JLabel(circleImg),new JLabel(circleImg),new JLabel(circleImg),
                                     new JLabel(circleImg),new JLabel(circleImg),new JLabel(circleImg)};
    
    protected JLabel[] ballShowUp = {new JLabel(),new JLabel(),new JLabel(),
                                     new JLabel(),new JLabel(),new JLabel()};
    
    protected ansPanel[] ans = new ansPanel[6];
    protected JLabel[] resultBall = {new JLabel(circleImg),new JLabel(circleImg),new JLabel(circleImg),
                                     new JLabel(circleImg),new JLabel(circleImg),new JLabel(circleImg)};
    
    
    Font huge = new Font("Monospaced", Font.BOLD, 35);       
    Font large = new Font("Monospaced", Font.BOLD, 28);
    Font medium = new Font("Monospaced", Font.BOLD, 20);
    Font small = new Font("Arial", Font.BOLD, 14);
        
    public GameView(){
        setAns(ans);
        ans[0].setB2(true);
        

        p2.setLayout(new GridLayout(1,4,20,0));
        p2.add(new JLabel(""));
        p2.add(ans[0]);
        p2.add(ans[1]);
        p2.add(new JLabel(""));
        
        
        
        p3.setBorder(BorderFactory.createMatteBorder(0,3,0,0,Color.red));
        p3.setLayout(new GridLayout(1,4,20,0));
        p3.add(new JLabel(""));
        p3.add(ans[4]);
        p3.add(ans[3]);
        p3.add(new JLabel(""));


        leftP1.add(new JLabel(""));    
        leftP1.add(ans[5]);

        rightP1.add(ans[2]);
        rightP1.add(new JLabel(""));
        rightP1.add(new JLabel(""));

        //Set giveUp
        p2s.setLayout(new GridLayout(1,4,0,0));
        p2s.add(new JLabel(""));
        p2s.add(ballShowUp[0]);
        p2s.add(ballShowUp[1]);
        p2s.add(new JLabel(""));
        
        
        p3s.setLayout(new GridLayout(1,4,0,0));
        p3s.add(new JLabel(""));
        p3s.add(ballShowUp[4]);
        p3s.add(ballShowUp[3]);
        p3s.add(new JLabel(""));

        cenP1s.setLayout(new GridLayout(1,4,0,0));
        cenP1s.add(ballShowUp[5]);
        cenP1s.add(new JLabel(""));
        cenP1s.add(new JLabel(""));
        cenP1s.add(ballShowUp[2]);

        
        //giveUp.setVisible(true);
        giveUp.setLayout(new BorderLayout());
        giveUp.add(p2s,BorderLayout.NORTH);
        giveUp.add(p3s,BorderLayout.SOUTH);
        giveUp.add(cenP1s,BorderLayout.CENTER);

        //Set winGive
        LayoutManager overlay2 = new OverlayLayout(winGive);
        winGive.setLayout(overlay2);
        
        //Set win message
        win.add(winMess);
        win.add(winMess2);
        win.add(winMess3);
        winMess.setForeground(Color.RED);
        winMess2.setForeground(Color.RED);
        winMess3.setForeground(Color.RED);
        winMess.setFont(huge);
        winMess2.setFont(huge);
        winMess3.setFont(huge);
        //win.setVisible(true);
        
        //Set round Button
        for (int i = 0; i<button.length;i++){
            button[i] = new RoundButton(ballBt[0][i]);
        }
        button[0].setName("b1");
        button[1].setName("b2");
        button[2].setName("b3");
        button[3].setName("b4");
        button[4].setName("b5");
        button[5].setName("b6");
        button[6].setName("b7");
        button[7].setName("b8");
        
        
        p5.setLayout(new GridLayout(1,9,10,10));
        for (int i = 0; i<button.length;i++){
            p5.add(button[i]);
        }
        
        
        bottom.add(p3);
        bottom.add(p5);
        
        p1.setLayout(new BorderLayout());
        leftP1.setBorder(BorderFactory.createMatteBorder(0,3,0,0,Color.red));
        p1.add(p2,BorderLayout.NORTH);
        p1.add(bottom,BorderLayout.SOUTH);
        p1.add(leftP1,BorderLayout.WEST);
        p1.add(rightP1,BorderLayout.EAST);
        p1.add(winGive,BorderLayout.CENTER);
        
        p4.setLayout(new BorderLayout());
        
        //Modified nGame button
        nGame.setBackground(Color.ORANGE);
        nGame.setForeground(Color.BLACK);
        p4.add(nGame ,BorderLayout.NORTH);
        
        //Modify exit button
        exit.setBackground(Color.BLACK);
        exit.setForeground(Color.WHITE);
        p4.add(exit, BorderLayout.SOUTH);
        
        //set whiteKey panel
        whiteKey.add(new JLabel(white));
        JLabel whiteKeyLabel= new JLabel("In code, not right position");
        whiteKeyLabel.setForeground(new Color(152,16,201));
        whiteKeyLabel.setFont(small);
        whiteKey.add(whiteKeyLabel);
        whiteKey.setForeground(new Color(192,209,195));  
        whiteKey.setBackground(new Color(171,228,235));
        
        //set blackKey panel
        blackKey.add(new JLabel(black));
        JLabel blackKeyLabel= new JLabel("In code, right position");
        blackKeyLabel.setForeground(new Color(152,16,201));
        blackKeyLabel.setFont(small);
        blackKey.add(blackKeyLabel);
        blackKey.setForeground(Color.RED);
        blackKey.setBackground(new Color(171,228,235));
        
        //Set the keyPanel so that the JLabel is in the center
        JLabel key = new JLabel("Code Breaker Answer Marbles");
        key.setFont(medium);
        JPanel keyPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        keyPanel.add(key);
        keyPanel.setBackground(new Color(113,139,255));
        
        //Set the codeKey panel
        codeKey.setBackground(new Color(171,228,235));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.ipadx = 20;
        c.gridwidth = 2;
        codeKey.add(keyPanel,c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady=8;
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 1;
        codeKey.add(whiteKey,c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 1;
        codeKey.add(blackKey,c);
        
        //Modify score Jpanel
        JLabel scoreLabel = new JLabel("Last 10 best players");
        scoreLabel.setHorizontalAlignment(JLabel.CENTER);
        scoreLabel.setFont(medium);
        JPanel scoreTitle = new JPanel(new FlowLayout(FlowLayout.CENTER));
        scoreTitle.add(scoreLabel);
        scoreTitle.setBackground(new Color(113,139,255));
        
        scorePanel.setBackground(new Color(171,228,235));
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.ipadx = 310;
        c.gridwidth = 2;
        scorePanel.add(scoreTitle,c);
        c.ipady = 7;
        c.gridwidth = 1;
        for (int i=0; i<store.length; i++){
            for (int j=0; j<store[i].length;j++){
                store[i][j] = new JLabel();
                store[i][j].setText("   ");
                store[i][j].setHorizontalAlignment(SwingConstants.CENTER); 
                store[i][j].setVerticalAlignment(SwingConstants.CENTER);
            }
        }
        for (int i=0; i<store.length; i++){
            for (int j=0; j<store[i].length;j++){
                c.fill = GridBagConstraints.HORIZONTAL;
                c.gridx = j;
                c.gridy = i+1;
                scorePanel.add(store[i][j],c);
            }
        }
        
        //Modify instruc
        instruc.setBackground(new Color(171,228,235));
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        instruc.add(codeKey,c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        instruc.add(scorePanel,c);
        
        
        p4.add(instruc);
        
        //Set accept button
        acc.setLayout(new FlowLayout(FlowLayout.LEFT,0,20));
        acc.add(accept);

        
        
        right.add(p4,BorderLayout.CENTER);
        right.add(acc,BorderLayout.SOUTH);
        
        p6.setLayout(new GridLayout(9,1,10,10));
        p6.add(new JLabel(""));
        for (int i = 0; i<resultBall.length;i++){
            p6.add(resultBall[i]);
        }
        
        //Set panel for give up button
        giveUpPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        giveUpPanel.add(giveUpBt);
        
        count.setLayout(new GridLayout(3,3,10,10));
        mv.setFont(large);
        timer.setFont(medium);
        count.add(new JLabel(""));
        count.add(new JLabel(""));
        count.add(new JLabel(""));
        count.add(timer, BorderLayout.EAST);
        count.add(mv, BorderLayout.CENTER);
        count.add(giveUpPanel, BorderLayout.WEST);
        count.add(new JLabel(""));
        count.add(new JLabel(""));
        count.add(new JLabel(""));
        
        p7.setLayout(new GridLayout(1,2,30,30));
        p7.add(p1);
        p7.add(right);
        
        //Modify option part
        op1.setName("0");
        op2.setName("1");
        op3.setName("2");
        askOp.setFont(medium);
        option.add(askOp);
        option.add(op1);
        option.add(op2);
        option.add(op3);
        
        /*for(int i=0;i<ball.length;i++){
            ball[i].setName("");
        }*/
        
        //Set Layout for the Frame
        setLayout(new BorderLayout());
        add(count,BorderLayout.NORTH);
        add(p7,BorderLayout.CENTER);
        add(p6,BorderLayout.WEST);
        add(option,BorderLayout.SOUTH);
        
        //get the screen size
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();   
        width = (width - 1300) /2;
        height = (height - 800)/2;
        
        setVisible(true);
        setLocation((int)width,(int)height); //set location for the frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1300,800);
        setTitle("Ring Code Breaker");
        setResizable(false);
    }
    public void addAccept(ActionListener ac){
        accept.addActionListener(ac);
    }
    public void addNewGame(ActionListener newGame){
        nGame.addActionListener(newGame);
    }
    public void addExit(ActionListener exitGame){
        exit.addActionListener(exitGame);
    }
    public void addMouse(MouseListener m1){
        for (int i = 0; i<button.length;i++){
            button[i].addMouseListener(m1);
        }
    }
    public void addGiveUp(ActionListener giveUp){
        giveUpBt.addActionListener(giveUp);
    }
    public void setIcon(MouseListener icon){
        op1.addMouseListener(icon);
        op2.addMouseListener(icon);
        op3.addMouseListener(icon);
    }
    public void newGame(){
        unFreeze();
        for (int i=0; i<ball.length; i++){
            ball[i].setIcon(circleImg);
            ball[i].setName(null);
        }
        for (int i=0; i<resultBall.length; i++){
            resultBall[i].setIcon(circleImg);
        }   
        move = 0;
        mv.setText("Number of moves: " + move);
        timer.setText("Time left: 3 minutes");
        timer.setVisible(false);
        addRing(ans,0);
        giveUp.setVisible(false);
        win.setVisible(false);
    }
    public void freeze(){
        accept.setEnabled(false);
        for (int i = 0; i<button.length;i++){
            button[i].setEnabled(false);
        }
        op1.setEnabled(false);
        op2.setEnabled(false);
        op3.setEnabled(false);
    }
    public void unFreeze(){
        accept.setEnabled(true);
        for (int i = 0; i<button.length;i++){
            button[i].setEnabled(true);
        }
        op1.setEnabled(true);
        op2.setEnabled(true);
        op3.setEnabled(true);
    }
    
    public void setAns(JPanel[] p){
        for (int i=0; i<p.length; i++){
            p[i] = new ansPanel(ball[i]);
            LayoutManager overlay = new OverlayLayout(p[i]);
            p[i].setLayout(overlay);

        }
    }
     public void addRing(ansPanel[] p, int index){
         for (int i=0; i<p.length;i++){
             p[i].setB2(false);
         }
         p[index].setB2(true);
     }
     public void noRing(ansPanel[] p){
         for (int i=0; i<p.length;i++){
             p[i].setB2(false);
         }
     }
    
     public void getAnswer(String[] result){
         for(int i = 0; i<result.length;i++){
             for (int j=0; j<button.length;j++){
                 if ((button[j].getName()).equals(result[i])){
                     ballShowUp[i].setIcon(button[j].getIcon());
                 }
                 else if ((button[j].getName()).equals(result[i])){
                     ballShowUp[i].setIcon(button[j].getIcon());
                 }
                 else if ((button[j].getName()).equals(result[i])){
                     ballShowUp[i].setIcon(button[j].getIcon());
                 }
                 else if ((button[j].getName()).equals(result[i])){
                     ballShowUp[i].setIcon(button[j].getIcon());
                 }
                 else if ((button[j].getName()).equals(result[i])){
                     ballShowUp[i].setIcon(button[j].getIcon());
                 }
                 else if ((button[j].getName()).equals(result[i])){
                     ballShowUp[i].setIcon(button[j].getIcon());
                 }
                 else if ((button[j].getName()).equals(result[i])){
                     ballShowUp[i].setIcon(button[j].getIcon());
                 }
                 else if ((button[j].getName()).equals(result[i])){
                     ballShowUp[i].setIcon(button[j].getIcon());
                 }
             }
         }
     }
     public void setButton(int index){
        for (int i = 0; i<button.length;i++){
            button[i].setIcon(ballBt[index][i]);
        }
        for (int i=0;i<ball.length && ball[i].getName() != null; i++){
            for (int j=0; j<button.length;j++){
                 String ballName = ball[i].getName();
                 if ((button[j].getName()).equals(ballName)){
                     ball[i].setIcon(button[j].getIcon());
                 }
                 else if ((button[j].getName()).equals(ballName)){
                     ball[i].setIcon(button[j].getIcon());
                 }
                 else if ((button[j].getName()).equals(ballName)){
                     ball[i].setIcon(button[j].getIcon());
                 }
                 else if ((button[j].getName()).equals(ballName)){
                     ball[i].setIcon(button[j].getIcon());
                 }
                 else if ((button[j].getName()).equals(ballName)){
                     ball[i].setIcon(button[j].getIcon());
                 }
                 else if ((button[j].getName()).equals(ballName)){
                     ball[i].setIcon(button[j].getIcon());
                 }
                 else if ((button[j].getName()).equals(ballName)){
                     ball[i].setIcon(button[j].getIcon());
                 }
                 else if ((button[j].getName()).equals(ballName)){
                     ball[i].setIcon(button[j].getIcon());
                 }
             }
        }
     }
     public void setScore(String[][] a){
         for (int i=0; i<a.length;i++){
            for(int j=0; j<a[i].length && a[i][j]!=null;j++){
                 store[i][j].setText(a[i][j]);
            }     
         }
         
     }
}
