package org.example;

import org.example.media.Media;

import java.io.IOException;
import java.nio.file.Path;

public class Main {

    public static void main(String[] args) {    // TESTER??

        try {
            DataManager manager = DataManager.getInstance(Path.of("src/main/java/org/example/res/data.csv"));
            System.out.println(manager);
            manager.searchByTitle("DREAM");

            //for (Media m : )
        } catch (IOException e) {
            System.out.println("Da ist was schief gelaufen");
        }
    }

}
