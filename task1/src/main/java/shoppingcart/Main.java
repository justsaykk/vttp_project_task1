package shoppingcart;

import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        Console cons = System.console();
        List<String> cartList = new ArrayList<>();
        Cart cart = null;

        // Printing out initial statements
        String directory = "./" + args[0];
        File f = new File(directory);
        String[] directoryList = f.list();
        System.out.printf("There are %d carts in %s directory\n", directoryList.length, args[0]);

        // while-loop control statement
        boolean stop = false;

        // This is the main program
        while (!stop) {
            // Getting Command
            String userInput = cons.readLine(">> What would you like to do? \n");
            String[] splitString = userInput.split(" ");
            String userCommand = splitString[0].toLowerCase();

            switch (userCommand) {
                case "load":
                    String userAction = splitString[1].toLowerCase();
                    cart = new Cart(userAction);
                    cartList = cart.load();
                    System.out.printf("%s shopping cart loaded\n", userAction);
                    break;

                case "exit":
                    System.out.println("Thank you for shopping with us.\n");
                    stop = true; // Stopping the while-loop
                    break;

                case "list":
                    cart.list(cartList);
                    break;

                case "add":
                    List<String> toAdd = new ArrayList<>(Arrays.asList(splitString));
                    toAdd.remove(0);
                    cart.add(toAdd, cartList);
                    break;

                case "delete":
                    cart.delete(splitString[1], cartList);
                    break;

                case "save":
                    cart.save(cartList);
                    System.out.printf("Cart contents saved to %s\n", cart.getName());
                    break;

                default:
                    break;
            }
        }
    }
}
