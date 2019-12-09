
package thesoccerleague;


public class TheSoccerLeague {

   
    public static void main(String[] args) {
       
        Scheduler sched = new Scheduler();
        
        Teams team1 = new Teams("Sassy Spaghetti");
        Teams team2 = new Teams("Danger Noodles");
        Teams team3 = new Teams("Nope Ropes");
        Teams team4 = new Teams("Carrots");
        Teams team5 = new Teams("Hoppers");
        Teams team6 = new Teams("Potatoes");
        
        sched.startApplication();
    }
    
}
