package org.example.io;

import org.example.media.Book;
import org.example.media.Game;
import org.example.media.Media;
import org.example.media.Movie;

import java.io.*;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Files_IO_KA
{

    public static Path savedPath;

    public static List<Media> readData(Path path) throws IOException {
        List<Media> media = new ArrayList<Media>();
        String line;
        FileReader fr = new FileReader(path.toString());
        BufferedReader br = new BufferedReader(fr);

        br.readLine();

        while ((line = br.readLine()) != null){
            String[] tokens = line.split(";");
            switch (tokens[1]){
                case "Game":
                    media.add(new Game(Integer.parseInt(tokens[0]),
                                       tokens[2],
                                       LocalDate.parse(tokens[3], Media.DTF),
                                       tokens[4],
                                       Integer.parseInt(tokens[5]),
                                       tokens[6]));
                    break;

                case "Book":
                    media.add(new Book(Integer.parseInt(tokens[0]),
                            tokens[2],
                            LocalDate.parse(tokens[3], Media.DTF),
                            tokens[4],
                            Integer.parseInt(tokens[5]),
                            tokens[6],
                            Integer.parseInt(tokens[7])));
                    break;

                case "Movie":
                    media.add(new Movie(Integer.parseInt(tokens[0]),
                            tokens[2],
                            LocalDate.parse(tokens[3], Media.DTF),
                            tokens[4],
                            Integer.parseInt(tokens[5]),
                            Integer.parseInt(tokens[6])));
                    break;
            }
        }

        return media;
    }

    public static void writeData(Path path, List<Media> list, boolean keepData) throws IOException {// what the fuck is keep Data?
        FileWriter fw = new FileWriter(path.toString(), keepData);
        BufferedWriter bw = new BufferedWriter(fw);
        list.sort(Comparator.comparing(Media::getId)); // sorts the list so the ids are in the write order
        if (!keepData){
            bw.write("ID;Type;Title;ReleaseDate;Genre;Rating;Author;Pages;RuntimeMinutes;Studio\n");
        }
        for(Media media : list){
                    bw.write(media.toString());
                    bw.write("\n");
        }
    }

   //  public static void deleteData(int id){ was das NICO??


}