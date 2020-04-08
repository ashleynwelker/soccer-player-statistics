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
    public static ArrayList<Player> playerList = new ArrayList<Player>();
    public Player statPlayer;
    //private String userInputValue = null;
    private static final String FILENAME = "Data.txt";
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
    protected boolean handleMenuSelection(char key) {
        switch(Character.toUpperCase(key)) {
            case '1':
                addPlayer();
                updateFile();
                break;
            case '2':
                editPlayer();
                updateFile();
                break;
            case '3':
                addStats();
                break;
            case '4':
                displayPlayerList();
                break;
            case 'X':
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
    private void callStatGoalieSM(Goalie goalie) {
        new StatGoalieSM(goalie).display();
    }

    /**
     * Transfer program control to the stat-sub-menu.
     */
    private void callStatFielderSM(Fielder fielder) {
        new StatFielderSM(fielder).display();
    }

    /**
     * Transfer program control to the edit-sub-menu.
     * @param player
     */
    private void callEditSubMenu(Player player) {
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
            playerList.add(new Goalie(fName, lName, jerseyNum));
        } else {
            playerList.add(new Fielder(fName,lName, jerseyNum, position));
        }
    }

    /*************** Edit Player ***************************/

    /**
     *  Edit Player
     */
    private void editPlayer() {
        displayPlayerList();
        int playerID = Integer.parseInt(prompt("Enter the playerID you wish to edit: "));
       playerList.forEach(player -> {
           if (player.getPlayerID() == playerID) {
               Player editPlayer = player;
               callEditSubMenu(editPlayer);
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
            playerList.forEach(player -> {
                if (player.getJersey() == parseInt(in) && player instanceof Goalie) {
                    //var 
                    Goalie goaliePlayer = (Goalie) player;
                    callStatGoalieSM(goaliePlayer);
                } else if (player.getJersey() == parseInt(in) && player instanceof Fielder) {
                    //var 
                    Fielder fielderPlayer = (Fielder) player;
                    callStatFielderSM(fielderPlayer);
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
        playerList.forEach(player -> {
            System.out.format("  %-9d %-7d %9s\n", player.getPlayerID(),
                    player.getJersey(), getFullName(player.getfName(), player.getlName()));
        });
        System.out.println("**********************************");
        Menu.delay(1500);
    }

    public boolean deletePlayer(Player player) {
        playerList.remove(player);
        return true;
    }
    private void updateFile() {
       
            // Convert ArrayList to array
          ArrayList<Player> one=playerList;
          Object[] objects = one.toArray(new Object[] {});
          // Write the data to the file
          try {
              FileDemo files=new FileDemo();
              files.writeData(FILENAME, objects);
          } catch (FileNotFoundException exception) {
              System.err.println("Couldn't find the file to write");
          }
          System.out.println("You have finish !! to update!!");
    }

}