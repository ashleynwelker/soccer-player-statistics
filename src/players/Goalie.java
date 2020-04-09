package players;

import players.Player;

/**
 * Our application's main menu.
 */
public class Goalie extends Player {
    private ShotAgainst saResult;
    private StatResult result;

    private String position;
    private int shotAgainstGoal;
    private int saves;
    private int totalPunts;
    private int positivePunts;
    private int totalGK;
    private int positiveGK;


    /*********** Class Constructors ******************/
    public Goalie() {
        super();
        this.position = "players.Goalie";
        this.shotAgainstGoal = 0;
        this.saves = 0;
        this.totalPunts = 0;
        positivePunts = 0;
        this.totalGK = 0;
        this.positiveGK = 0;
    }

    public Goalie(String fName, String lName) {
        super(fName, lName);
        this.position = "players.Goalie";
        this.shotAgainstGoal = 0;
        this.saves = 0;
        this.totalPunts = 0;
        positivePunts = 0;
        this.totalGK = 0;
        this.positiveGK = 0;
    }

    public Goalie(String fName, String lName, int jersey) {
        super(fName, lName, jersey);
        this.position = "players.Goalie";
        this.shotAgainstGoal = 0;
        this.saves = 0;
        this.totalPunts = 0;
        this.positivePunts = 0;
        this.totalGK = 0;
        this.positiveGK = 0;
    }


    /****** Getters *********/
    public int getShotAgainstGoal() {
        return shotAgainstGoal;
    }

    public int getSaves() {
        return saves;
    }

    public int getTotalPunts() {
        return totalPunts;
    }

    public int getpositivePunts() {
        return positivePunts;
    }

    public int getTotalGK() {
        return totalGK;
    }

    public int getpositiveGK() {
        return positiveGK;
    }

    public String getPosition() {
        return position;
    }

    /*********** Class Methods ***********/

    /**
     * Records the shots against the goalie
     * and counts the saves of the goalie
     * @param saResult either Saved or Allowed
     */
    public void shotAgainstGoal(ShotAgainst saResult) {
        ++this.shotAgainstGoal;
        if (saResult == ShotAgainst.SAVED) {
            ++this.saves;
        }
    }

    public void punts(StatResult result) {
        ++this.totalPunts;
        if (result == result.POSITIVE) {
            ++positivePunts;
        }
    }

    public void goalKick(StatResult result) {
        ++this.totalGK;
        if (result == result.POSITIVE) {
            ++this.positiveGK;
        }
    }

    public double savePercent() {
        double s;
        if (shotAgainstGoal!=0){
        s= saves / shotAgainstGoal * 100;
        }else{
        s= 0;
        }
        return s;
    }

    public double puntPercent() {
        double s;
        if (totalPunts!=0){
        s= positivePunts / totalPunts * 100;
        }else{
        s= 0;
        }
        return s;
       
    }

    public double goalKickPercent() {
        double s;
        if (totalGK!=0){
        s= positiveGK / totalGK * 100;
        }else{
        s= 0;
        }
        return s;
        
    }

    @Override
    public String toString() {
        String g2str = String.format("%s \n" +
            "%d saves out of %d shots\n" +
            "%.2f%% save success rate\n" +
            "%d positive possession punts out of %d \n" +
            "%.2f%% positive possession punt delivery\n" +
            "%d positive possession goal kicks out of %d\n" +
            "%.2f%% positive possession goal kick dellivery\n", super.toString(), saves, shotAgainstGoal, this.savePercent(),
            positivePunts, totalPunts, this.puntPercent(),
            positiveGK, totalGK, this.goalKickPercent());
        return g2str;
    }
}