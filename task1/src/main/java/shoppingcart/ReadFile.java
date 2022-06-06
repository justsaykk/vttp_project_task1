package shoppingcart;

import java.io.File;
import java.io.IOException;

public class ReadFile {

    public void Read(String fileName) throws IOException {
        String path = "./shoppingcart/" + fileName + ".cart";
        File file = new File(path);

        // Check if file exist. If !exist, create new file based on given path
        if (!file.exists()) {
            if (file.createNewFile()) {
                System.out.printf("New file created at %s\n", path);
            } else {
                System.out.println("Error creating file");
            }
            ;
            return;
        }



    }
}
