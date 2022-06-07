package shoppingcart;

import java.io.Console;
import java.io.IOException;


public class Main {

    private String userCommand = "";
    private String userAction = "";
    private static String curFile = "";

    // Getters
    public String getUserCommand() {
        return userCommand;
    }

    public String getUserAction() {
        return userAction;
    }

    public String getCurFile() {
        return curFile;
    }

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
            Methods method = new Methods();

            switch (userCommand) {
                case "load":
                    String userAction = splitString[1].toLowerCase();
                    method.load(userAction);
                    curFile = userAction;
                    break;

                case "exit":
                    System.out.println("Thank you for shopping with us.\n");
                    stop = true; // Stopping the while-loop
                    break;

                case "list":
                    method.list();
                    break;

                case "add":
                    method.add(splitString);
                    break;

                case "delete":
                    method.delete(splitString[1]);
                    break;

                default:
                    break;
            }
        }
    }
}
