
package thesoccerleague;


public class Teams {
    
    //instantiated variables
    private String teamName;
    
    private int winTotal;
    
    private int tieTotal;
    
    private int totalGoalsScored;
    
    private int totalGoalsAllowed;
    
    
    //getters
    public String getTeamName() {
        return teamName;
    }

    public int getWinTotal() {
        return winTotal;
    }

    public int getTieTotal() {
        return tieTotal;
    }

    public int getTotalGoalsScored() {
        return totalGoalsScored;
    }

    public int getTotalGoalsAllowed() {
        return totalGoalsAllowed;
    }
    
    //setters

    public void setWinTotal(int winTotal) {
        this.winTotal = winTotal;
    }

    public void setTieTotal(int tieTotal) {
        this.tieTotal = tieTotal;
    }

    public void setTotalGoalsScored(int totalGoalsScored) {
        this.totalGoalsScored = totalGoalsScored;
    }

    public void setTotalGoalsAllowed(int totalGoalsAllowed) {
        this.totalGoalsAllowed = totalGoalsAllowed;
    }
    
    
    //constructor
    Teams(String teamName)
    {
        this.teamName = teamName;
        
        Scheduler.teamList.add(this);
        
    }
    
    static String teamAvgMessage(String message)
    {
        for(Teams team: Scheduler.teamList)
        {
            message += team.teamName + ": \n Total Wins:" + team.getWinTotal() + "\n Total Ties:" + team.getTieTotal() 
                    + "\n Total Goals Scored:" + team.getTotalGoalsScored() + "\n Total Goals Allowed" + team.getTotalGoalsAllowed() + "\n\n\n";
        }
        return message;
    }
    
    
}
