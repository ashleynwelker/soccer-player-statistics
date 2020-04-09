import menu.Menu;

import java.io.FileNotFoundException;

/**
 * Application to demonstrate using the Menu framework
 */
public class Application {

    public static void main(String[] argv) throws FileNotFoundException {
        System.out.println();
        System.out.println("Welcome to our application. We hope you like it.");
        System.out.println();

        Menu.delay(1500);

        new MainMenu().display();

        System.out.println("Thank you for checking out our program!");
        
        Menu.delay(1500);
    }
}