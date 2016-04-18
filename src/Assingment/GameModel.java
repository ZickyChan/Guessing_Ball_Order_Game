package Assingment;


import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.util.*;
import java.io.*;
import java.lang.*;
import java.awt.event.*;

public class GameModel {  
    protected LinkedList<String> set1;
    protected String[] result = new String[6];
    protected int score = 0;
    protected ArrayList all = new ArrayList();
    
    public GameModel(){
        set1 = new LinkedList<String>();
        set1.add("b1");
        set1.add("b2");
        set1.add("b3");
        set1.add("b4");
        set1.add("b5");
        set1.add("b6");
        set1.add("b7");
        set1.add("b8");
        Collections.shuffle(set1);
        
        Iterator i1 = set1.iterator();
        
        for (int i = 0; i<6; i++){
            result[i] = (String) i1.next();
        } 
        for (int i = 0; i<6; i++){
            System.out.println(result[i]);
        }
        System.out.println("");
    }
    public int calculateScore(int m){
        if (m > 72)
            score = 0;
        else if (m > 60)
            score = 50;
        else if (m > 42)
            score = 100;
        else if (m > 36)
            score = 250;
        else if (m > 12)
            score = 500;
        else if (m > 6)
            score = 750;
        else 
            score = 1000;
        return score;
    }
    public void readFile() throws IOException{
        String name;
        String score;
        String line;
        Scanner input = new Scanner(new File("record.txt"));
        while(input.hasNextLine()){
            line = input.nextLine();
            StringTokenizer a = new StringTokenizer(line,",");
            name = a.nextToken();
            score = a.nextToken();
            String[] playerInfo = {name,score};
            all.add(playerInfo);
        }
        input.close();
    }
    public void writeFile(ArrayList a) throws IOException{
        ListIterator i = a.listIterator();
        PrintWriter pw = new PrintWriter(new File("record.txt"));
        while(i.hasNext()){
            Object b = i.next();
            String[] store = (String[]) b;
            pw.println(store[0]+","+store[1]);          
        }
        pw.close();
    }
    public String[][] showScore(){
       String[][] ten = new String[10][2];
       String[][] finalArray = new String[10][2];
       LinkedList<Integer> tenList = new LinkedList<Integer>();
       int j =0;
       ListIterator lil = all.listIterator(all.size());
       while (lil.hasPrevious() && j < ten.length){
           String[] a = (String[])lil.previous();
           ten[j][0] = a[0];
           ten[j][1] = a[1];
           tenList.add(Integer.parseInt(a[1]));
           j++;
       }
       Collections.sort(tenList, Collections.reverseOrder());
       ListIterator lil1 = tenList.listIterator();
       int h = 0;
       while (lil1.hasNext()){
           finalArray[h][1] = (lil1.next()).toString();
           h++;
       }
       
       for (int i = 0; i<ten.length && ten[i][1] != null; i++){
           for (int k = 0; k < finalArray.length;k++){
               if((ten[i][1]).equals(finalArray[k][1]) && (finalArray[k][0]) == null){
                   finalArray[k][0] = ten[i][0];
                   break;
               }
           }
       }
       return finalArray;
    }

}
