package shoppingcart;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.ArrayList;

public class Methods {

    public List<String> load(String path) throws IOException {
        List<String> cartList = new ArrayList<>();
        File file = new File(path);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;

        if (!file.exists()) {
            if (file.createNewFile()) {
                System.out.printf("New file created at %s\n", path);
            }
            br.close();
        }
        if (file.exists()) {
            while ((st = br.readLine()) != null) {
                cartList.add(st);
            }
            br.close();
        }
        return cartList;
    }

    public void list(List<String> cartList) throws IOException {
        if (cartList.size() > 0) {
            for (int i = 0; i < cartList.size(); i++) {
                System.out.printf("%d. %s\n", (i + 1), cartList.get(i));
            }
        } else {
            System.out.println("Your cart is empty\n");
        }
    }

    public void add(String[] items, List<String> cartList) throws IOException {
        for (int i = 1; i < items.length; i++) {
            String itemsToAdd = items[i];
            cartList.add(itemsToAdd);
        }
    }

    public void delete(String index, List<String> cartList) {
        int toIndex = Integer.parseInt(index);
        int toDelete = toIndex - 1;
        if (toIndex > cartList.size()) {
            System.out.println("Incorrect item index\n");
        } else {
            System.out.printf("%s removed from cart\n", cartList.get(toDelete));
            cartList.remove(toDelete);
        }
    }

    public void save(Path path, List<String> cartList) throws IOException {
        try {
            Files.write(path, cartList);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}