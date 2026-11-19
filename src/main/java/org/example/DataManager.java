import media.Media;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class DataManager {

    private List<Media> mediaList = new ArrayList();
    private static DataManager instance;

    private DataManager(Path path) throws IOException {
        mediaList = FileIO.readData(path);
    }

    public static synchronized DataManager getInstance(Path path) throws IOException {
        if (instance == null) {
            instance = new DataManager(path);
        }
        return instance;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Media media : mediaList){
            sb.append(media.toString());
            sb.append("\n");
        }

        return sb.toString();
    }

    public List searchByTitle(String searchInput){
        List<Media> matches = new ArrayList<>();
        for (Media media : mediaList){
            if(media.getTitle().toLowerCase().contains(searchInput.toLowerCase())){
                matches.add(media);
            }
        }
        for (Media m : matches){
            System.out.println(m);
        }
        return matches;
    }

    public void deleteMedia(int id){    //TODO: Schauen dass keine ID dann doppelt vergeben wird

    }
}