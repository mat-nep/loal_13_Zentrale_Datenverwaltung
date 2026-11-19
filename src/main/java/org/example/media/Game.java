package org.example.media;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Game extends Media{
    private String studio;

    public Game(int id, String title, LocalDate release, String genre, int rating, String studio) {
        super(id, title, release, genre, rating);
        this.studio = studio;
    }

    @Override
    public String toString() {
        String media = String.format("%s;%s", super.toString(), studio);
        return String.format(media, getClass().getSimpleName());
    }
}
