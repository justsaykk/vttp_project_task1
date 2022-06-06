package shoppingcart;

import java.io.Console;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        // Get console input
        Console cons = System.console();

        // While loop to run program
        boolean stop = false; // while-loop control statement
        while (!stop) {
            // Getting Command
            String userInput = cons.readLine(">> What would you like to do? \n");
            String[] splitString = userInput.split(" ");
            String userCommand = splitString[0].toLowerCase();
            ReadFile file = new ReadFile();

            switch (userCommand) {
                case "load":
                    String userAction = splitString[1].toLowerCase();
                    file.Read(userAction);
                    break;

                case "exit":
                    System.out.println("Thank you for shopping with us.\n");
                    stop = true; // Stopping the while-loop
                    break;

                case "add":
                    // Code here
                    break;

                default:
                    break;
            }
        }

        // Load file

    }
}
