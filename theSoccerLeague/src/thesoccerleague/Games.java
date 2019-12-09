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
    
    static ArrayList<Games> gameList = new ArrayList<Games>();
    
    
    //determine score
    void determineScore(int todayTemp)
    {
        //generate random team score based on today's temperature
        this.todayTemp = todayTemp;
        
        setStatistics(team1, team2);     
              
    }
    
    static void seasonStatistics()
    {
        
        String myMessage = "";
        
        myMessage += Teams.teamAvgMessage(myMessage);
        
        int hottestTemp = 0;
        int avgTemp = 0;
        
        for(Games game: gameList)
        {
            //check to find hottest temp of season
            if(game.todayTemp > hottestTemp)
            {
                hottestTemp = game.todayTemp;
            }
            
            //find average temp
            avgTemp += game.todayTemp;
            
            //create string for message including game number, day's temperature, team names and scores 
            myMessage = "Season Statistics \n\n\n" + "Game #" + game.idNumb + "\n" + "Day's Temperature:" + game.todayTemp + "\n" +
                    game.team1.getTeamName() + ": " + game.team1Score + "\n" + game.team2.getTeamName()
                    + ": " + game.team2Score + "\n\n\n";
            
        }
        //divide for avg temp
        avgTemp = avgTemp/gameList.size();
        
        //add temperatures to the message
        myMessage += "Hottest Temperature:" + hottestTemp 
                + "\n Average Temperature:" + avgTemp + "\n\n";
        
        JOptionPane.showMessageDialog(null, myMessage, "Game Statistics", JOptionPane.PLAIN_MESSAGE);
        
    }
    void setStatistics(Teams team1, Teams team2)
    {
        //sets team1 score
        this.team1Score = rn.nextInt((this.todayTemp/10));
        
        //adds score to goalsScored for team 1
        int goalsScored = this.team1Score + team1.getTotalGoalsScored();
        team1.setTotalGoalsScored(goalsScored);
        
        //adds total goals allowed for team 2
        int goalsAllowed = this.team1Score + team2.getTotalGoalsAllowed();
        team2.setTotalGoalsAllowed(goalsAllowed);
        
        //generates team 2's score
        this.team2Score = rn.nextInt((this.todayTemp/10));
        
        //adds score to goalsScored for team 2
        int goalsScored2 = this.team2Score = team2.getTotalGoalsScored();
        team2.setTotalGoalsScored(goalsScored2);
        
        //adds to goals allowed for team 1
        int goalsAllowed2 = this.team2Score + team1.getTotalGoalsAllowed();
        team1.setTotalGoalsAllowed(goalsAllowed);
        
        
        
        //if statement to see who won
        if(team1Score > team2Score)
        {
            //adds total wins of team 1
            int wins = team1.getWinTotal() + 1;
            team1.setWinTotal(wins);
        }
        else if(team2Score > team1Score)
        {
            //adds total wins of team 2
            int wins2 = team2.getWinTotal() + 1;
            team2.setWinTotal(wins2);
        }
        else
        {
            //adds tie total to team 1
            int ties1 = team1.getTieTotal() + 1;
            team1.setTieTotal(ties1);
            
            //adds tie total to team 2
            int ties2 =  team2.getTieTotal() + 1;
            team2.setTieTotal(ties2);
        }
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
