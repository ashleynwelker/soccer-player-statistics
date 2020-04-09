import menu.Menu;
import menu.MenuItem;
import players.Fielder;
import players.Goalie;
import players.Player;

import java.util.ArrayList;

import static java.lang.Integer.parseInt;

import java.io.FileNotFoundException;

/**
 * Our application's main menu.
 */
public class MainMenu extends Menu {
    public Player statPlayer;
    //private String userInputValue = null;
       private static MenuItem[] menuItems = new MenuItem[] {
            new MenuItem('1', "Add players"),
            new MenuItem('2', "Edit existing players"),
            new MenuItem('3', "Enter player statistics"),
            new MenuItem('4', "Produce the Game Report"),
            new MenuItem('X', "Exit Application")
    };

    /**
     * Constructor for the main menu
     */
    public MainMenu() {
        super();
    }

    @Override
    protected String getTitle() {
        return "--> Player Stat's Main Menu <--";
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
    protected boolean handleMenuSelection(char key) throws FileNotFoundException {
        switch(Character.toUpperCase(key)) {
            case '1':
                addPlayer();
                Utility.writeData();
                break;
            case '2':
                editPlayer();
                Utility.writeData();
                break;
            case '3':
                addStats();
                break;
            case '4':
                displayPlayerList();
                break;
            case 'X':
                Utility.writeData();
                return false;
            default:
                System.out.println("Please enter a valid selection");
        }
        return true;
    }

    /******************* Call Sub Menus ***************/
    /**
     * Transfer program control to the stat-sub-menu.
     */
    private void callStatGoalieSM(Goalie goalie) throws FileNotFoundException {
        new StatGoalieSM(goalie).display();
    }

    /**
     * Transfer program control to the stat-sub-menu.
     */
    private void callStatFielderSM(Fielder fielder) throws FileNotFoundException {
        new StatFielderSM(fielder).display();
    }

    /**
     * Transfer program control to the edit-sub-menu.
     * @param player
     */
    private void callEditSubMenu(Player player) throws FileNotFoundException {
        new EditSubMenu(player).display();
    }


    /***************** Add a player *******************************/
    /**
     * Snippet List<A> l = new ArrayList<A>();
     *         l.add(new B());
     *         l.add(new C());
     *  attributed to https://stackoverflow.com/users/982161/%ce%a6xoc%c4%99-%ec%9b%83-%d0%9fepe%c3%bapa-%e3%83%84
     */

    private void addPlayer() {
        String fName, lName, position;
        int jerseyNum;

        fName = prompt("Enter the player's first name: ");
        lName = prompt("Enter the player's last name: ");
        jerseyNum = parseInt(prompt("Enter the player's jersey number: "));
        position = prompt("Enter the player's position\n (If player is a goalie only type the 'g' character): ");
        if (position.length() == 1 && position.charAt(0) == 'g') {
            Utility.getPlayerList().add(new Goalie(fName, lName, jerseyNum));
        } else {
            Utility.getPlayerList().add(new Fielder(fName,lName, jerseyNum, position));
        }
    }

    /*************** Edit Player ***************************/

    /**
     *  Edit Player
     */
    private void editPlayer() {
        displayPlayerList();
        int playerID = Integer.parseInt(prompt("Enter the playerID you wish to edit: "));
       Utility.getPlayerList().forEach(player -> {
           if (player.getPlayerID() == playerID) {
               Player editPlayer = player;
               try {
                   callEditSubMenu(editPlayer);
               } catch (FileNotFoundException e) {
                   e.printStackTrace();
               }
           }
       });

    }

    /*************** Enter Stats ***************************/

    /**
     * Add stats
     */
    private void addStats() {
        String in = prompt("Enter the jersey Number to stat\n" +
                "Or, Press 'd' to display a list of players jersey numbers: ");
        if (in.length() == 1 && in.charAt(0) == 'd') {
            displayPlayerList();
            addStats();
        }
        if (parseInt(in) >= 0 && parseInt(in) < 100) {
            Utility.getPlayerList().forEach(player -> {
                if (player.getJersey() == parseInt(in) && player instanceof Goalie) {
                    //var 
                    Goalie goaliePlayer = (Goalie) player;
                    try {
                        callStatGoalieSM(goaliePlayer);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                } else if (player.getJersey() == parseInt(in) && player instanceof Fielder) {
                    //var 
                    Fielder fielderPlayer = (Fielder) player;
                    try {
                        callStatFielderSM(fielderPlayer);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    /************ Helper Methods ******************************/

    protected String getFullName(String fName, String lName) {
        return String.format("%s %s", fName, lName);
    }

    protected void displayPlayerList() {
        System.out.println("**********************************");
        System.out.println("PlayerID:  Jersey:  Player: \n");
        Utility.getPlayerList().forEach(player -> {
            System.out.format("  %-9d %-7d %9s\n", player.getPlayerID(),
                    player.getJersey(), getFullName(player.getfName(), player.getlName()));
        });
        System.out.println("**********************************");
        Menu.delay(1500);
    }

    public boolean deletePlayer(Player player) {
        Utility.getPlayerList().remove(player);
        return true;
    }
}