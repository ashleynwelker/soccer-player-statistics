import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;
import players.Fielder;
import players.Goalie;
import players.Player;

public class Utility {
    private static List<Player> playerList = new ArrayList<>();
    private static final String FILENAME = "Data.txt";

    public static void createPlayer() {
    }

    /**
     * Write the array of data to the file specified.
     *
     * @throws FileNotFoundException
     */
    // we will change the input to string[]
    public static void writeData() throws FileNotFoundException {
        PrintWriter file = new PrintWriter(FILENAME);
        Gson dataConverter = new Gson();
        for (Player athlete: playerList) {
            if (athlete instanceof Goalie) {
                file.println("g:" + dataConverter.toJson(athlete, Goalie.class));
            }
            else {
                file.println("f:" + dataConverter.toJson(athlete, Fielder.class));
            }
        }
        file.flush();
    }

    public static List<Player> getPlayerList() {
        if (playerList.isEmpty()) {
            File file = new File(FILENAME);
            try {
                Scanner myScanner = new Scanner(file);
                Gson dataConverter = new Gson();
                while (myScanner.hasNext()) {
                    String content = myScanner.nextLine();
                    if (content.startsWith("g")) {
                        playerList.add(dataConverter.fromJson(content.substring(2), Goalie.class));
                    }
                    else {
                        playerList.add(dataConverter.fromJson(content.substring(2), Fielder.class));
                    }
                }
            } catch (FileNotFoundException e) {
                return playerList;
            }
        }
        return playerList;
    }
}
