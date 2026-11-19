package org.example;

import org.example.io.FileIO;
import org.example.media.Media;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataManager {

    private List<Media> mediaList = new ArrayList();
    private List<Media> filterdList = new ArrayList(); // todo geter
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

    public void filterListByInstance(String target)
    {
        // TODO filter by instance should take a string target and filter the list ( into filterd list ) for that Instance
    }

    public void deleteMedia(int id)
    {
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
}