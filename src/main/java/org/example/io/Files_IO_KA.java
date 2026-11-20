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

            int id = Integer.parseInt(tokens[0]);
            String title = tokens[2];
            LocalDate date = LocalDate.parse(tokens[3], Media.DTF);
            String genre = tokens[5];
            int rating = Integer.parseInt(tokens[4]);

            switch (tokens[1]){
                case "Game":
                    media.add(new Game(id, title, date, genre, rating, tokens[6]));
                    break;

                case "Book":
                    media.add(new Book(id, title, date, genre, rating, tokens[6], Integer.parseInt(tokens[7])));
                    break;

                case "Movie":
                    media.add(new Movie(id, title, date, genre, rating, Integer.parseInt(tokens[6])));
                    break;
            }
        }

        System.out.print("read in was completed\n");
        br.close();
        return media;
    }

    public static void writeData(Path path, List<Media> list, boolean keepData) throws IOException {// what the fuck is keep Data?
        FileWriter fw = new FileWriter(path.toString(), keepData);
        BufferedWriter bw = new BufferedWriter(fw);
        StringBuilder sb = new StringBuilder();

        list.sort(Comparator.comparing(Media::getId)); // sorts the list so the ids are in the write order
        if (!keepData){
            sb.append("ID;Type;Title;ReleaseDate;Genre;Rating;Author;Pages;RuntimeMinutes;Studio\n");
        }

        System.out.println();

        for(Media media : list){
            sb.append(media.toString());
            sb.append("\n");
        }

        System.out.println(sb.toString());
        bw.write(sb.toString());

        // ==========================================
        // NEU: Stream leeren und zwingend schließen!
        // ==========================================
        bw.flush();
        bw.close();

        System.out.print("save in was completed\n\n");
    }

   //  public static void deleteData(int id){ was das NICO??


}