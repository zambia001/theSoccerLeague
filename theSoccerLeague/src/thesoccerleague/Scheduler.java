
package thesoccerleague;

import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;


public class Scheduler {
    
    //initiate stuff
    
    Random rn = new Random();
    
    static ArrayList<Teams> teamList = new ArrayList<Teams>();
    static ArrayList<Integer> tempList = new ArrayList<Integer>();
    
    static Boolean summer = true;
   
    static boolean one = false;
    static boolean two = false;
    static boolean three = false;
    
    
    Teams team1;
    Teams team2;
    Teams team3;
    Teams team4;
    
    void startApplication()
    {
        while(summer == true)
        {
            String temp = JOptionPane.showInputDialog("Enter Temperature(F) in Whole Numbers:");
        
            int todayTemp = Integer.parseInt(temp);
            
            tempList.add(todayTemp);
        
            if(todayTemp <= 32)
            {
                 JOptionPane.showMessageDialog(null, "Too cold to play\n");
                 
                 if(one == false)
                 {
                     one = true;
                 }
                 else if(one == true && two == false)
                 {
                     two = true;
                 }
                 else if(two == true && three == false)
                 {
                     three = true;
                     summer = false;
                 }
            }
            else
            {
                one = false;
                two = false;
                three = false;
                
                //generate random numb
                int r1 = rn.nextInt(teamList.size());
                int r2 = rn.nextInt(teamList.size());
                int r3 = rn.nextInt(teamList.size());
                int r4 = rn.nextInt(teamList.size());
            
                r2 = checkTeams(r1, r2);
                r4 = checkTeams(r3, r4);
            
                Games game1 = new Games(teamList.get(r1), teamList.get(r2));
                Games game2 = new Games(teamList.get(r3), teamList.get(r4));
                
                game1.determineScore(todayTemp);
                game2.determineScore(todayTemp);
           
            }
        }
        
        
        
        Games.seasonStatistics();
    }
    
    int checkTeams(int r1, int r2)
    {
          if(r1 == r2)
            {
                while(r1 == r2)
                {
                    r2 = rn.nextInt(teamList.size());
                }
            }
         
          return r2;
    }
}
