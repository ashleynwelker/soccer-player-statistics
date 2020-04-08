import menu.Menu;
import menu.MenuItem;

/**
 * Our application's main menu.
 */
public class SubMenu2 extends Menu {

   
    // Make this static so it stays with the class. This way
    // we can count how many times this SubMenu class gets
    // instantiated.
    private static int callCount = 0;
    private Utility list;
    private final static String[] countDescriptions = new String[] {
        "", "first", "second", "third", "fourth", "fifth", "sixth", "seventh", "eighth",
        "ninth", "tenth"
    };
   
    private static MenuItem[] menuItems = new MenuItem[] {
        new MenuItem('1', "Read the Filders"),
        new MenuItem('2', "Read All"),
        new MenuItem('R', "Return to previous menu")
    };

    /**
     * Constructor for the main menu
     */
    public SubMenu2(   ) {
        super();
       // this.list=list;
        callCount += 1;
    }

    @Override
    protected String getTitle() {
        return "********* 	Game Report	 *********";
    }
    
    @Override
    protected String getDescription() {
        // build our description dynamically.
        return String.format("This is the %s time you've called this menu.",
            callCount < countDescriptions.length ? countDescriptions[callCount] : callCount + "th");
    }
    
    @Override
    protected MenuItem[] getMenuItems() {
        return menuItems;
    }
    
    @Override
    protected boolean handleMenuSelection(char key) {
        switch(Character.toUpperCase(key)) {
            case '1': 
                subMenuOption1();
                break;
            case '2': 
                subMenuOption1();
                subMenuOption2();
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
     */
    private void subMenuOption1() {
        System.out.println("You have called sub menu option 1");
        TableTitleFilder();
      // myTable.TableDataFilder(list);
             
    }
    
    /**
     * Do the sub-menu 2 action.
     */
    private void subMenuOption2() {
        System.out.println("You have called sub menu option 2");
        TableTitleGoalie();
       // myTable.TableDataGoalie(list);
        
    }
    public void TableTitleGoalie() {
        System.out.printf("%5s     %2s   %5s   %5s   %5s   %5s   %5s   %5s   %5s   %5s   %5s   %2s\n", "Goalie", "#","Shots","Save","Goal","%","Punt","Pos","Neg","Gk","Pos","Neg");
        System.out.printf("%5s     %2s   %5s   %5s   %5s   %5s   %5s   %5s   %5s   %5s   %5s   %2s\n","----", "---","----","---", "---","---","---", "---","---","---", "---","---");
    }
     public void TableTitleFilder() {
        System.out.printf("%5s     %2s   %5s   %5s   %5s   %5s   %3s   %5s   %5s   %5s   %3s   %2s\n", "Filder", "#","Shots","Goal","Wide","Blocke","%","Touch","Pos","Neg","%","TA");
        System.out.printf("%5s     %2s   %5s   %5s   %5s   %5s   %3s   %5s   %5s   %5s   %3s   %2s\n","----", "---","----","---", "---","---","---", "---","---","---", "---","---");
     
    
    }
 //    public void TableDataGoalie(Utility list) {
 //       for(int i= 0; i < list.getTeams().size(); i ++) {
 //          if(list.getTeams().get(i) instanceof Goalie){
 //           // Convert the list to table 
 //           
 //           String stats = list.getTeams().get(i).toString1();
//
 //           // Print the formatted table
 //           System.out.printf("%-3s\n",stats);
 //          }
 //       }
 //    }
 //    public void TableDataFilder(Utility list) {
 //       for(int k = 0; k < list.getTeams().size(); k++) {
 //
 //          if(list.getTeams().get(k) instanceof Fielder){
 //           // Convert the list to table
 //           String stats = list.getTeams().get(k).toString1();
//
 //           // Print the formatted table
 //           System.out.printf("%-3s\n",stats);
 //          }
 //       }
 //    }
}