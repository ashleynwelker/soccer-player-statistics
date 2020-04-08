import menu.Menu;
import menu.MenuItem;
import players.Goalie;
import players.Player;
import players.ShotAgainst;
import players.StatResult;

/**
 * Our application's main menu.
 */
public class StatGoalieSM extends Menu {
    private Goalie goalie;

    private static MenuItem[] menuItems = new MenuItem[]{
            new MenuItem('1', "Blocked or Saved goal: Option 1"),
            new MenuItem('2', "Allowed goal: Option 2"),
            new MenuItem('3', "Punt positive possession: Option 3"),
            new MenuItem('4', "Punt negative possession: Option 4"),
            new MenuItem('5', "Goal kick positive possession: Option 5"),
            new MenuItem('6', "Goal kick negative possession: Option 6"),
            new MenuItem('R', "Return to previous menu")
    };

    /**
     * Constructor for the main menu
     */
    public StatGoalieSM(Goalie goaliePlayer) {
        super();
        goalie = goaliePlayer;
    }

    @Override
    protected String getTitle() {
        return "Enter Goalie Statistics";
    }

    @Override
    protected String getDescription() {
        // build our description dynamically.
        return "";
    }

    @Override
    protected MenuItem[] getMenuItems() {
        return menuItems;
    }

    @Override
    protected boolean handleMenuSelection(char key) {
        switch (Character.toUpperCase(key)) {
            case '1':
                goalie.shotAgainstGoal(ShotAgainst.SAVED);
                break;
            case '2':
                goalie.shotAgainstGoal(ShotAgainst.ALLOWED);
                break;
            case '3':
                goalie.punts(StatResult.POSITIVE);
                break;
            case '4':
                goalie.punts(StatResult.NEGATIVE);
                break;
            case '5':
                goalie.goalKick(StatResult.POSITIVE);
                break;
            case '6':
                goalie.goalKick(StatResult.NEGATIVE);
                break;
            case 'R':
                return false;
            default:
                System.out.println("Please enter a valid selection");
        }

        return true;
    }
}