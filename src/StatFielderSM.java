import menu.Menu;
import menu.MenuItem;
import players.Fielder;
import players.Player;
import players.ShotFor;
import players.StatResult;

/**
 * Our application's main menu.
 */
public class StatFielderSM extends Menu {
        private Fielder fielder;
        private static MenuItem[] menuItems = new MenuItem[] {
            new MenuItem('1', "Shot - Goal: Option 1"),
            new MenuItem('2', "Shot - Blocked: Option 2"),
            new MenuItem('3', "Shot - Wide: Option 3"),
            new MenuItem('4', "Touch - Positive: Option 4"),
            new MenuItem('5', "Touch - Negative: Option 5"),
            new MenuItem('6', "Take-away: Option 6"),
            new MenuItem('R', "Return to previous menu")
        };

    /**
     * Constructor for the main menu
     */
    public StatFielderSM(Fielder fielderPlayer) {
        super();
        fielder = fielderPlayer;
    }

    @Override
    protected String getTitle() {
        return "Enter Fielder's Statistics";
    }

    @Override
    protected String getDescription() {
        // build our description dynamically.
        return String.format("***********************\n* %s's stats!\n***********************\n" +
                "* Goals: %d\n* Shots blocked: %d\n* Wide shots: %d\n* Total shots: %d\n" +
                "* Positive touches: %d for a %5.2f%% success rate\n* Total touches: %d\n* Take-aways %d", fielder.getfName(),
                fielder.getShotGoal(), fielder.getShotBlocked(), fielder.getShotWide(),
                (fielder.getShotWide() + fielder.getShotBlocked() + fielder.getShotGoal()),
                fielder.getPositiveTouch(), fielder.positiveTouchPercent(), fielder.getTotalTouch(), fielder.getTakeAway());
    }

    @Override
    protected MenuItem[] getMenuItems() {
        return menuItems;
    }

    @Override
    protected boolean handleMenuSelection(char key) {
        switch(Character.toUpperCase(key)) {
            case '1':
                fielder.shotForGoal(ShotFor.GOAL);
                break;
            case '2':
                fielder.shotForGoal(ShotFor.BLOCKED);
                break;
            case '3':
                fielder.shotForGoal(ShotFor.WIDE);
                break;
            case '4':
                fielder.touch(StatResult.POSITIVE);
                break;
            case '5':
                fielder.touch(StatResult.NEGATIVE);
                break;
            case '6':
                fielder.takeAway();
                break;
            case 'R':
                return false;
            default:
                System.out.println("Please enter a valid selection");
        }

        return true;
    }
}