package org.example;

import org.example.io.Files_IO_KA;
import org.example.media.Media;
import org.w3c.dom.stylesheets.MediaList;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataManager {

    private List<Media> mediaList = new ArrayList();
    private List<Media> filterdList = new ArrayList();
    private static DataManager instance;
                                                                    // todo only for main methods del
    private DataManager(Path path) throws IOException {
        mediaList = Files_IO_KA.readData(path);
    }   // only for main
    private DataManager() {}

    public static synchronized DataManager getInstance(Path path) throws IOException {
        if (instance == null) {
            instance = new DataManager(path);
        }
        return instance;
    } // inly for main
    public static synchronized DataManager getInstance() throws IOException {
        if (instance == null) {
            instance = new DataManager();
        }
        return instance;
    }

    public void addList(List<Media> tokens)
    {
        mediaList.addAll(tokens);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Media media : filterdList){
            sb.append(media.toString());
            sb.append("\n");
        }

        return sb.toString();
    }

    public List<Media> searchByTitle(String searchInput) {
        List<Media> matches = new ArrayList<>();
        for (Media media : filterdList){
            if(media.getTitle().toLowerCase().contains(searchInput.toLowerCase())){
                matches.add(media);
            }
        }
        for (Media m : matches){
            System.out.println(m);
        }
        return matches;
    }

    public void filterListByInstance(String target) {
        // todo testing !!
        // Liste vorher leeren, falls sie wiederverwendet wird
        filterdList.clear();

        for (Media m : mediaList) {
            // Wenn nach "Media" gesucht wird, wollen wir ALLE Medien anzeigen
            if (target.contains("Media")) {
                filterdList.add(m);
            }
            // Ansonsten exakt nach der Unterklasse (Book, Game, Movie) filtern
            else if (m.getClass().toString().equalsIgnoreCase(target)) {
                filterdList.add(m);
            }
        }
    }

    public void deleteMedia(int id) {
        for (int i = 0; i < mediaList.size(); i++)
        {
            if (mediaList.get(i).getId() == id)
            {
                mediaList.remove(i);
                return;
            }
        }
    }

    private int getNewId() // todo test...
    {
        int x = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (Media m : mediaList)
        {
            map.put(m.getId(), map.get(m.getId()) + 1);
        }

        while (map.get(x) == 1)  //get the first feeld with no ID pair...
            x++;


        if (map.get(x) == 0)
            return x;
        else
            throw new IllegalArgumentException("one ID exists 2ce...");
    }

    public List<Media> getFilterdList()
    {
        return filterdList;
    }
    public List<Media> getMediaList()
    {
        System.out.println("list got returnt form datermanager");
        return mediaList;
    }
}