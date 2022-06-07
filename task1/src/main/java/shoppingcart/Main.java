package shoppingcart;

import java.io.Console;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        Console cons = System.console();
        List<String> cartList = new ArrayList<>();
        Methods method = new Methods();
        String path = "";
        String name = "";
        boolean stop = false; // while-loop control statement

        while (!stop) {
            // Getting Command
            String userInput = cons.readLine(">> What would you like to do? \n");
            String[] splitString = userInput.split(" ");
            String userCommand = splitString[0].toLowerCase();

            switch (userCommand) {
                case "load":
                    String userAction = splitString[1].toLowerCase();
                    path = "./shoppingcart/" + userAction + ".cart";
                    name = userAction;
                    cartList = method.load(path);
                    System.out.printf("%s shopping cart loaded\n", userAction);
                    break;

                case "exit":
                    System.out.println("Thank you for shopping with us.\n");
                    stop = true; // Stopping the while-loop
                    break;

                case "list":
                    method.list(cartList);
                    break;

                case "add":
                    method.add(splitString, cartList);
                    break;

                case "delete":
                    method.delete(splitString[1], cartList);
                    break;

                case "save":
                    Path output = Paths.get(path);
                    method.save(output, cartList);
                    System.out.printf("Cart contents saved to %s\n", name);
                    break;

                default:
                    break;
            }
        }
    }
}
