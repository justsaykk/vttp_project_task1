package shoppingcart;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class Methods {

    public static List<String> cartList = new ArrayList<>();

    public void load(String fileName) throws IOException {
        String path = "./shoppingcart/" + fileName + ".cart";
        File file = new File(path);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;

        // Check if file exist. If !exist, create new file based on given path
        if (!file.exists()) {
            if (file.createNewFile()) {
                System.out.printf("New file created at %s\n", path);
            } else {
                System.out.println("Error creating file");
            }
            br.close();
            return;
        }
        if (file.exists()) {
            while ((st = br.readLine()) != null) {
                cartList.add(st);
            }
            System.out.printf("%s shopping cart loaded\n", fileName);
        }
        br.close();
    }

    public void list() throws IOException {
        // Evaluate if list is empty
        if (cartList.size() > 0) {
            for (int i = 0; i < cartList.size(); i++) {
                System.out.printf("%d. %s\n", (i + 1), cartList.get(i));
            }
        } else {
            System.out.println("Your cart is empty\n");
        }
    }

    public void add(String[] items) throws IOException {
        for (int i = 1; i < items.length; i++) {
            String itemsToAdd = items[i];
            cartList.add(itemsToAdd);
            System.out.printf("Cart List length %d", cartList.size());
        }

    }
}
