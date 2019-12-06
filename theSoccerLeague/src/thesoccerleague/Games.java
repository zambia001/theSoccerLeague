/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesoccerleague;

import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;


public class Games {
    Random rn = new Random();
    
    //instantiate variables
    private int todayTemp;
    
    private Teams team1;
    
    private Teams team2;
    
    private int team1Score;
    
    private int team2Score;
    
    private int idNumb = 0;
    
    //Arraylist
    
    ArrayList<Games> gameList = new ArrayList<Games>();
    
    
    void determineScore()
    {
        //generate random team score based on today's temperature
        
        
        
        this.team1Score = rn.nextInt((this.todayTemp/10));
        
        this.team2Score = rn.nextInt((this.todayTemp/10));
        
    }
    
    void seasonStatistics()
    {
        
        String myMessage = "";
        
        for(Games game: gameList)
        {
            
            //create string for message including game number, day's temperature, team names and scores 
            myMessage = "Season Statistics \n\n\n" + "Game #" + game.idNumb + "\n" + "Day's Temperature:" + game.todayTemp + "\n" +
                    game.team1.getTeamName() + ": " + game.team1Score + "\n" + game.team2.getTeamName()
                    + ": " + game.team2Score + "\n\n\n";
            
        }
        
        JOptionPane.showMessageDialog(null, myMessage, "Game Statistics", JOptionPane.PLAIN_MESSAGE);
        
    }
    
    
    //constructor
    Games(Teams team1, Teams team2)
    {
        this.team1 = team1;
        this.team2 = team2;
        
        gameList.add(this);
        this.idNumb = gameList.size();
        
    }
    
}
