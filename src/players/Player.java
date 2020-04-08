package players;

/**
 * This class defines a sport player. Every player will have a name (first and last).
 * Every player on a team with have a jersey number assigned. Because the name and jersey
 * are mutable and subclasses with have statistics tied to a player, a unique ID is
 * assigned at construction that identifies that player. Since the unique ID is an
 * integer number that increases sequentially by a count of one, this number can
 * also indicate the number of objects created.
 */

public class Player {
    protected static int count = 0;

    /** Define the players.Player class attributes */
    private String fName;  // The player's first name
    private String lName;  // The player's last name
    private int jersey;  // The player's jersey number
    private int playerID;  // A unique identifier for every player object

    /******************* Class constructors ********************************/

    /**
     * Construct a player default players.Player
     */
    public Player() {
        this("First_Name", "Last_Name", -1);
    }

    /**
     * Construct a player with name parameter and a default jersey
     */
    public Player(String fName, String lName) {
        this(fName, lName, -1);
    }

    /**
     * Construct a player with name and jersey parameters.
     * Assigns a unique player ID to the player object.
     */
    public Player(String fName, String lName, int jersey) {
        setfName(fName);
        setlName(lName);
        setJersey(jersey);
        playerID= ++count;
    }


    /****************** Getters and Setters *******************/
    /**
     * Get the player's first name
     * @return string
     */
    public String getfName() {
        return fName;
    }

    /**
     * Sets the player's first name
     * @param newFName should be the desired first name
     * @throws IllegalArgumentException
     */
    public void setfName(String newFName) throws IllegalArgumentException {
        this.fName = nameValid(newFName);
    }

    /**
     * Get the player's last name
     * @return string
     */
    public String getlName() {
        return lName;
    }

    /**
     * Sets the player's last name
     * @param newLName should be the desired last name
     * @throws IllegalArgumentException
     */
    public void setlName(String newLName) throws IllegalArgumentException {
        this.lName = nameValid(newLName);
    }

    /**
     * Get the player's jersey number
     * @return integer
     */
    public int getJersey() {
        return jersey;
    }

    /**
     * Sets the player's jersey number
     * @param newJersey
     */
    public void setJersey(int newJersey)  throws IllegalArgumentException {
        if (newJersey >= -1 && newJersey < 100)
            this.jersey = newJersey;
        else
            throw new IllegalArgumentException("Jersey must be equal to or between 00 and 99");
    }

    /**
     * Get the unique identifier for each player
     * @return integer
     */
    public int getPlayerID() {
        return playerID;
    }

    /****************** Class Methods ***********************************/
    /**
     * Validate the desired name is valid
     * @param name
     * @return
     * @throws IllegalArgumentException
     */
    public static String nameValid(String name)
            throws IllegalArgumentException {
        if (name.matches("[a-zA-Z_ ]*")) {
            return name;
        } else {
            throw new IllegalArgumentException(
                    "Names must only include letters");
        }
    }


    /**
     * Return string representation of this object.
     */
    @Override
    public String toString() {
        return String.format("First name: %s\nLast name: %s \nJeresy #: %d\n" +
                "players.Player's unique ID: %d\n", fName, lName, jersey, playerID);

    }
}
