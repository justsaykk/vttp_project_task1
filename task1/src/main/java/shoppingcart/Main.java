package shoppingcart;

import java.io.Console;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        // Get console input
        Console cons = System.console();

        // While loop to run program
        boolean stop = true; // while-loop control statement
        while (stop) {
            // Getting Command
            String userInput = cons.readLine(">> What would you like to do? \n");
            String[] splitString = userInput.split(" ");
            String userCommand = splitString[0].toLowerCase();
            String userAction = splitString[1].toLowerCase();

            switch (userCommand) {
                case "load":
                    ReadFile file = new ReadFile();
                    file.Read(userAction);
                    break;
                
                case "list":
                    break;

                default:
                    break;
            }
        }

        // Load file

    }
}
