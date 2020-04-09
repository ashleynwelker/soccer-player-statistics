package players;

import players.Player;

/**
 * Our application's main menu.
 */
public class Fielder extends Player {
    private static ShotFor sfResult;
    private static StatResult result;

    private String position;
    private int shotWide;
    private int shotGoal;
    private int shotBlocked;
    private int totalTouch;
    private int positiveTouch;
    private int takeAway;


    /*********** Class Constructors ******************/
    public Fielder() {
        super();
        this.position = "";
        this.shotWide = 0;
        this.shotGoal = 0;
        this.shotBlocked = 0;
        this.totalTouch = 0;
        this.positiveTouch = 0;
        this.takeAway = 0;
    }

    public Fielder(String fName, String lName) {
        super(fName, lName);
        this.position = "";
        this.shotWide = 0;
        this.shotGoal = 0;
        this.shotBlocked = 0;
        this.totalTouch = 0;
        this.positiveTouch = 0;
        this.takeAway = 0;
    }

    public Fielder(String fName, String lName, int jersey, String position) {
        super(fName, lName, jersey);
        this.position = position;
        this.shotWide = 0;
        this.shotGoal = 0;
        this.shotBlocked = 0;
        this.totalTouch = 0;
        this.positiveTouch = 0;
        this.takeAway = 0;
    }

    /****** Setters and Getters ******/
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    /****** Getters *********/
    public int getShotWide() {
        return shotWide;
    }

    public int getShotGoal() {
        return shotGoal;
    }

    public int getShotBlocked() {
        return shotBlocked;
    }

    public int getTotalTouch() {
        return totalTouch;
    }

    public int getPositiveTouch() {
        return positiveTouch;
    }

    public int getTakeAway() {
        return takeAway;
    }


    /*********** Class Methods ***********/

    /**
     * Records the shots against the goalie
     * and counts the saves of the goalie
     * @param sfResult either Saved or Allowed
     */
    public void shotForGoal(ShotFor sfResult) {
        if (sfResult == ShotFor.GOAL) {
            ++this.shotGoal;
        }
        else if (sfResult == ShotFor.BLOCKED) {
            ++this.shotBlocked;
        }
        else {
            ++this.shotWide;
        }
    }

    public void touch(StatResult result) {
        ++this.totalTouch;

        if (result == StatResult.POSITIVE) {
            ++this.positiveTouch;
        }
    }

    public void takeAway() {
        ++this.takeAway;
    }

    public double shotGoalPercent() {
        if ((this.shotWide + this.shotGoal + this.shotBlocked) < 1) {
            return 0.0;
        }
        else {
            return this.shotGoal / (this.shotWide + this.shotGoal + this.shotBlocked) * 100;
        }
    }

    public double positiveTouchPercent() {
        if (this.totalTouch < 1) {
            return 0.0;
        }
        else {

            double divisor = this.totalTouch;
            return (this.positiveTouch / divisor) * 100;
        }
    }

    @Override
    public String toString() {
        String fielder2str = String.format("%s \n" +
            "Position: %s\n" +
            "Goals made: %d goals out of %d shots\n" +
            "Goals Wide: %d\n" +
            "Goals Blocked: %d\n" +
            "%.2f%% goal success rate\n" +
            "%d positive touches out of %d \n" +
            "%.2f%% positive touch delivery\n" +
            "Take-Aways: %d\n", super.toString(),
            position, shotGoal, (shotWide + shotGoal + shotBlocked),
            shotWide, shotBlocked, shotGoalPercent(),
            positiveTouch, totalTouch, positiveTouchPercent(), takeAway);
        return fielder2str;
    }
}