import java.io.IOException;
import java.nio.file.Path;

public class Main {

    static void main() {

        try {
            DataManager manager = DataManager.getInstance(Path.of("src/res/data.csv"));
            System.out.println(manager);
            manager.searchByTitle("DREAM");
        } catch (IOException e) {
            System.out.println("Da ist was schief gelaufen");
        }


    }

}
