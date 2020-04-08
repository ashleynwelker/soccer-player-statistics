import menu.Menu;
import menu.MenuItem;
import players.Fielder;
import players.Goalie;
import players.Player;
//import java.util.ArrayList;


/**
 * Our application's main menu.
 */
public class EditSubMenu extends Menu {
    private Player player;

    private static MenuItem[] menuItems = new MenuItem[] {
            new MenuItem('1', "First Name: Option 1"),
            new MenuItem('2', "Last Name: Option 2"),
            new MenuItem('3', "Jersey Number: Option 3"),
            new MenuItem('4', "Position: Option 4"),
            new MenuItem('5', "Delete Player: Option 5"),
            new MenuItem('R', "Return to previous menu")
    };

    /**
     * Constructor for the main menu
     */
    public EditSubMenu(Player player) {
        super();
        this.player = player;
    }

    @Override
    protected String getTitle() {
        return "Edit Player";
    }

    @Override
    protected String getDescription() {

        return "";
    }

    @Override
    protected MenuItem[] getMenuItems() {
        return menuItems;
    }

    @Override
    protected boolean handleMenuSelection(char key) {
        switch(Character.toUpperCase(key)) {
            case '1':
                editPlayerFName();
                break;
            case '2':
                editPlayerLName();
                break;
            case '3':
                editPlayerJersey();
                break;
            case '4':
                editPlayerPosition();
                break;
            case '5':
                System.out.println("Done!");
                break;
            case 'R':
                return false;
            default:
                System.out.println("Please enter a valid selection");
        }

        return true;
    }

    /**
     * Do the sub-menu 1 action.
     * Replace the player's first name
     */
    private void editPlayerFName()
            throws IllegalArgumentException {
        try {
            player.setfName(prompt("Enter the replacement name: "));
        }
        catch (IllegalArgumentException exception) {
        }
    }

    /**
     * Do the sub-menu 2 action.
     * Replace the player's last name.
     */
    private void editPlayerLName()
            throws IllegalArgumentException {
        try {
            player.setlName(prompt("Enter the replacement name: "));
        }
        catch (IllegalArgumentException exception) {
        }
    }

    /**
     * Do the sub-menu 3 action.
     * Replace the player's jersey number.
     */
    private void editPlayerJersey()
            throws IllegalArgumentException {
        try {
            player.setJersey(Integer.parseInt(prompt("Enter the new number: ")));
        }
        catch (IllegalArgumentException exception) {
        }
    }

    /**
     * Do the sub-menu 4 action.
     */
    private void editPlayerPosition()
            throws IllegalArgumentException {
        try {
           if (player instanceof Goalie) {
               System.out.println("Can't change the goalie position");
           } else {
               //var 
              Fielder fielder = (Fielder) player;
                fielder.setPosition(prompt("Enter the new position: "));
           }
        }
        catch (IllegalArgumentException exception) {
        }
    }
}